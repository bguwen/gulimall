package com.hngc.thirdparty;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class GulimallThirdPartyApplicationTests {


    @Value("${spring.cloud.alicloud.oss.bucket}")
    private String bucket;
    @Autowired
    private OSS ossClient;
    @Test
    void contextLoads() throws IOException {
        PutObjectResult putObjectResult = ossClient.putObject(bucket, "open_graph_logo.png", Files.newInputStream(Paths.get("D:\\SoftwareDate\\系统自带文件\\Saved Pictures\\open_graph_logo.png")));
        System.out.println(putObjectResult);
    }

}
