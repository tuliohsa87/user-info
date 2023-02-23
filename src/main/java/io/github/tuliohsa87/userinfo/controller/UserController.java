package io.github.tuliohsa87.userinfo.controller;

import io.github.tuliohsa87.userinfo.dto.StatusDTO;
import io.github.tuliohsa87.userinfo.model.UserInfo;
import io.github.tuliohsa87.userinfo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo){
        return userService.createUserService(userInfo);
    }

    @GetMapping
    public List<UserInfo> findAll(){
        return userService.findAllService();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<StatusDTO> getCpfStatus(@PathVariable String cpf){
        return userService.getCpfStatusService(cpf);
    }
}
