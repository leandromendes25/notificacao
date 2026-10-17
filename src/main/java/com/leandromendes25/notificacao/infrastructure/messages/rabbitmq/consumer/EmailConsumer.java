package com.leandromendes25.notificacao.infrastructure.messages.rabbitmq.consumer;

import com.leandromendes25.notificacao.business.EmailService;
import com.leandromendes25.notificacao.business.dto.TarefasDTO;
import com.leandromendes25.notificacao.infrastructure.messages.rabbitmq.config.RabbitMqConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;
    //funciona independentemente se fazer um chamado para ela, parecido com o bean
    //diz qual a fila q irá consumir
    //notification envia a mensagem
    @RabbitListener(queues = RabbitMqConfig.FILA_EMAIL)
    public void enviarEmail(TarefasDTO dto){
    emailService.enviaEmail(dto);
    }
}
