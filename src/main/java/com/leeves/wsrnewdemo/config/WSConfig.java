package com.leeves.wsrnewdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Description:
 * Package: com.leeves.wsrnewdemo.ws
 *
 * @author Leeves
 * @version 1.0.0  2018-07-06
 */
@Configuration
public class WSConfig {

    @Bean
    public Jaxb2Marshaller leevesMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.leeves.wsrnewdemo.ws.leeves");
        return marshaller;
    }

    @Bean
    public Jaxb2Marshaller testMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.leeves.wsrnewdemo.ws.test");
        return marshaller;
    }

    @Bean
    public WSClient leevesWSClient(Jaxb2Marshaller leevesMarshaller) {
        WSClient client = new WSClient();
        client.setDefaultUri("http://localhost:7007/ws/leevesService.wsdl");
        client.setMarshaller(leevesMarshaller);
        client.setUnmarshaller(leevesMarshaller);
        return client;
    }

    @Bean
    public WSClient testWSClient(Jaxb2Marshaller testMarshaller) {
        WSClient client = new WSClient();
        client.setDefaultUri("http://localhost:7007/ws/testService.wsdl");
        client.setMarshaller(testMarshaller);
        client.setUnmarshaller(testMarshaller);
        return client;
    }

}