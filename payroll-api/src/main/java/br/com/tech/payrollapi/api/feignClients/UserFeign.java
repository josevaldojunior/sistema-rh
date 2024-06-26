package br.com.tech.payrollapi.api.feignClients;

import br.com.tech.payrollapi.domain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api")
public interface UserFeign {

    @GetMapping
    ResponseEntity<List<User>> findAll();

    @GetMapping("/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

}
