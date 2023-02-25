package io.github.tuliohsa87.userinfo.model;

import io.github.tuliohsa87.userinfo.enums.StatusToVote;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @CPF(message = "Enter a valid CPF")
    private String cpf;
    private StatusToVote status;
}
