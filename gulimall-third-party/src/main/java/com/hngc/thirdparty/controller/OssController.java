package com.hngc.thirdparty.controller;


import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;

import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.Callback;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import com.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OSS ossClient;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessId;
    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;
    @Value("${spring.cloud.alicloud.oss.bucket}")
    private String bucket;

    /**
     * 获取签名
     *
     * @return
     */
    @GetMapping("policy")
    public Result policy() {
        //https://guli-college2022.oss-cn-shanghai.aliyuncs.com/open_graph_logo.png
        String host = "https://" + bucket + "." + endpoint;
        // 设置上传回调URL，即回调服务器地址，用于处理应用服务器与OSS之间的通信。OSS会在文件上传完成后，把文件上传信息通过此回调URL发送给应用服务器。
//        String callbackUrl = "https://192.168.0.0:8888";
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String dir = new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()) + "/";

        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            /**
             * 回调设置
             */
//            Callback callback = new Callback();
//            callback.setCallbackUrl("http://localhost:20000/oss/callback");
//            callback.setCallbackBody("filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
//            // 设置发起回调请求的Content-Type。
//            callback.setCalbackBodyType(Callback.CalbackBodyType.JSON);
//
//            String callbackData = BinaryUtil.toBase64String(JSONObject.toJSON(callback).toString().getBytes(StandardCharsets.UTF_8));

            //过期时间
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
//            respMap.put("callback", callbackData);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.success().put("data", respMap);
    }

    /**
     * oss上传成功回调
      * @param request
     * @return
     */
    @PostMapping(value = "/callback")
    public Result callback(HttpServletRequest request) {
        log.info("callback --------------> start");
        System.out.println(request);
        log.info("callback --------------> end");
        return Result.success(request);
    }

}
