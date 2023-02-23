package io.github.tuliohsa87.userinfo.dto;

import io.github.tuliohsa87.userinfo.enums.StatusToVote;
import lombok.Data;

@Data
public class StatusDTO {
    private StatusToVote status;
}
