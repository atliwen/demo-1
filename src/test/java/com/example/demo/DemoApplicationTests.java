package com.example.demo;

import com.example.demo.news.AbstractNotifier;
import com.example.demo.news.DingDingNews;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests
{


    String url1 = "https://oapi.dingtalk.com/robot/send?access_token=ab4de3f91e1d62be5516f3f1aedb955898edbec21c19295600c16651e72991a0";
    String url2 = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=587aedec-7d87-40fe-9bdb-c39b4a858b7e";

    @Test
    void contextLoads() {

        AbstractNotifier notifier = new DingDingNews(url1);

        //notifier = new WeChatNews(url2);
        notifier.postForEntity("测试服务", "10.10.01", "处理消息有100个积压，请及时关注！ ");

    }

}
