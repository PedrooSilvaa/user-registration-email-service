package tech.silva.ms.user.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.silva.ms.user.dto.EmailDto;
import tech.silva.ms.user.entity.UserEntity;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserEntity userEntity){
        var emailDto = new EmailDto();
        emailDto.setUserId(userEntity.getId());
        emailDto.setEmailTo(userEntity.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userEntity.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
