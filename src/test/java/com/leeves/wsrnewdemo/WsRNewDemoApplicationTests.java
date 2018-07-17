package com.leeves.wsrnewdemo;

import com.leeves.wsrnewdemo.config.WSClient;
import com.leeves.wsrnewdemo.ws.leeves.LeevesServiceResponse;
import com.leeves.wsrnewdemo.ws.test.TestServiceResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsRNewDemoApplicationTests {

    @Autowired
    private WSClient testWSClient;

    @Autowired
    private WSClient leevesWSClient;

    @Test
    public void contextLoads() {
        TestServiceResponse testService = testWSClient.sendToTestService("test88");
        System.out.println(testService.getResMsg());
        LeevesServiceResponse leevesService = leevesWSClient.sendToLeevesService("leeves99");
        System.out.println(leevesService.getResMsg());
    }

}
