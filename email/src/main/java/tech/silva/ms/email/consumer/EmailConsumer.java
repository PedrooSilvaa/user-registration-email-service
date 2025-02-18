package tech.silva.ms.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tech.silva.ms.email.dto.EmailRecordDto;
import tech.silva.ms.email.entity.EmailEntity;
import tech.silva.ms.email.service.EmailService;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailRecordDto, emailEntity);
        emailService.sendEmail(emailEntity);
    }

}
