package br.com.tech.userapi.domain.service;

import br.com.tech.userapi.domain.exception.EntityNotFoundException;
import br.com.tech.userapi.domain.model.User;
import br.com.tech.userapi.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
