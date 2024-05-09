package br.com.tech.userapi.domain.service;

import br.com.tech.userapi.domain.exception.EntityNotFoundException;
import br.com.tech.userapi.domain.model.User;
import br.com.tech.userapi.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final Environment environment;
    private final UserRepository userRepository;

    public User findById(Long id){
        log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
