package org.sid.springjaxws.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class SoapConfig {
     @Bean
    public SimpleJaxWsServiceExporter serviceExporter(){
         SimpleJaxWsServiceExporter serviceExporter
                 =new SimpleJaxWsServiceExporter();
         serviceExporter.setBaseAddress("http://0.0.0.0:8087/banqueService/");
         return serviceExporter;
    }

}
