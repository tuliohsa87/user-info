package io.github.tuliohsa87.userinfo.service;

import io.github.tuliohsa87.userinfo.dto.StatusDTO;
import io.github.tuliohsa87.userinfo.exceptions.exception.CpfException;
import io.github.tuliohsa87.userinfo.model.UserInfo;
import io.github.tuliohsa87.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserInfo> createUserService(UserInfo userInfo){
        try {
            UserInfo userCreate = userRepository.save(userInfo);
            return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    public List<UserInfo> findAllService(){
        return userRepository.findAll();
    }

    public ResponseEntity<StatusDTO> getCpfStatusService(String cpf){
        Optional<UserInfo> userInfo = userRepository.findByCpf(cpf);
        if (userInfo.isEmpty()) throw new CpfException("Invalid CPF");
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatus(userInfo.get().getStatus());
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }
}
