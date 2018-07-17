package com.leeves.wsrnewdemo.config;


import com.leeves.wsrnewdemo.ws.leeves.LeevesServiceRequest;
import com.leeves.wsrnewdemo.ws.leeves.LeevesServiceResponse;
import com.leeves.wsrnewdemo.ws.test.TestService;
import com.leeves.wsrnewdemo.ws.test.TestServiceResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * Description:
 * Package: com.leeves.wsrnewdemo.ws
 *
 * @author Leeves
 * @version 1.0.0  2018-07-06
 */
public class WSClient extends WebServiceGatewaySupport {

    public LeevesServiceResponse sendToLeevesService(String reqMsg) {
        LeevesServiceRequest request = new LeevesServiceRequest();
        request.setReqMsg(reqMsg);
        return (LeevesServiceResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7007/ws/leevesService.wsdl", request);
    }

    public TestServiceResponse sendToTestService(String reqMsg) {
        TestService request = new TestService();
        request.setReqMsg(reqMsg);
        return (TestServiceResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7007/ws/testService.wsdl", request);
    }

}