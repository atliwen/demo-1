package com.example.demo;

import com.example.demo.news.AbstractNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class DcController
{

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() throws URISyntaxException {
        ResponseEntity<String> result = restTemplate.exchange(
                new RequestEntity<>(HttpMethod.GET, new URI("http://test1/dc"))
                , String.class);
        return result.getBody();
    }
    @Autowired
    private AbstractNotifier notifier;
    @GetMapping("/a")
    public String dc1() throws URISyntaxException {
        notifier.postForEntity("测试服务", "10.10.01", "处理消息有100个积压，请及时关注！ ");

        return  "a";
    }



}