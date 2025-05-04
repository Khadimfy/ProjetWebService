package com.bibliotheque.ApiBiblio.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }


    @Bean(name = "livres")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema livresSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BibliothequePort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://www.bibliotheque.com/wsdl");
        definition.setSchema(livresSchema);  // <-- ici
        return definition;
    }

    @Bean
    public XsdSchema livresSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/livres.xsd"));
    }
    // WSDL pour les utilisateurs
    @Bean(name = "utilisateurs")
    public DefaultWsdl11Definition utilisateursWsdl(XsdSchema utilisateursSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BibliothequePort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://www.bibliotheque.com/wsdl");
        definition.setSchema(utilisateursSchema);
        return definition;
    }
    @Bean
    public XsdSchema utilisateursSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/livres.xsd"));
    }

    // WSDL pour les réservations
   
    @Bean(name = "bibliotheque")
    public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema bibliothequeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BibliothequePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.bibliotheque.com/wsdl");
        wsdl11Definition.setSchema(bibliothequeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema bibliothequeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/bibliotheque.xsd"));
    }
}

   
    


