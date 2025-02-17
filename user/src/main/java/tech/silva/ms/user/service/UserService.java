package tech.silva.ms.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.ms.user.entity.UserEntity;
import tech.silva.ms.user.repository.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
}
