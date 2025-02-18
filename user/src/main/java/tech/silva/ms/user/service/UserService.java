package tech.silva.ms.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.ms.user.entity.UserEntity;
import tech.silva.ms.user.producer.UserProducer;
import tech.silva.ms.user.repository.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserEntity save(UserEntity userEntity){
        userEntity =  userRepository.save(userEntity);
        userProducer.publishMessageEmail(userEntity);
        return userEntity;
    }
}
