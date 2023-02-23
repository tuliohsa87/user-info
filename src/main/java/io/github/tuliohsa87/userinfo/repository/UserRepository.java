package io.github.tuliohsa87.userinfo.repository;

import io.github.tuliohsa87.userinfo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByCpf(String cpf);
}
