package com.leandromendes25.notificacao.infrastructure.messages.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.JacksonJsonMessageConverter;

@Configuration
public class RabbitMqConfig {
    //configuramos nessa ordem.
public static final String FILA_EMAIL = "fila.email";
public static final String EXCHANGE_EMAIL = "email.exchange";
//necessaria para exchange direct.
public static final String ROUTING_KEY = "email.key";
    @Bean
    public Queue filaEmail() {
    return new Queue(FILA_EMAIL);
    }
    @Bean
    public DirectExchange  exchange(){
        return new DirectExchange(EXCHANGE_EMAIL);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(filaEmail()).to(exchange()).with(ROUTING_KEY);
    }
    @Bean
    public Binding bindingFa(){
        return BindingBuilder.bind(filaEmail()).to(exchange()).with("br.suporte.com");
    }
    //jacksonJsonMessageConverter faz conversão de objeto para json
    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter(){
        return new JacksonJsonMessageConverter();
    }
}
