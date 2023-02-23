package io.github.tuliohsa87.userinfo.controller;

import io.github.tuliohsa87.userinfo.dto.StatusDTO;
import io.github.tuliohsa87.userinfo.model.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "user", description = "The user-info API")
public interface UserApi {

    @Operation(summary = "Create User-info", description = "The user-info API", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(example = "{\n" +
                            "    \"cpf\": \"36921787001\",\n" +
                            "    \"status\": \"ABLE_TO_VOTE\"\n" +
                            "}"))
            })
    })
    @PostMapping
    ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo);


    @Operation(summary = "Find all User-info", description = "The find all User-info API", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(example = "[\n" +
                            "    {\n" +
                            "        \"cpf\": \"88752646009\",\n" +
                            "        \"status\": \"UNABLE_TO_VOTE\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "        \"cpf\": \"36921787001\",\n" +
                            "        \"status\": \"ABLE_TO_VOTE\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "        \"cpf\": \"79208823032\",\n" +
                            "        \"status\": \"ABLE_TO_VOTE\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "        \"cpf\": \"77444079030\",\n" +
                            "        \"status\": \"ABLE_TO_VOTE\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "        \"cpf\": \"24402825024\",\n" +
                            "        \"status\": \"UNABLE_TO_VOTE\"\n" +
                            "    }\n" +
                            "]"))
            })
    })
    @GetMapping
    List<UserInfo> findAll();

    @Operation(summary = "Find User-info", description = "The find user-info API", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(example = "{\n" +
                            "    \"status\": \"ABLE_TO_VOTE\"\n" +
                            "}"))
            }),
            @ApiResponse(responseCode = "404", description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(example = "{\n" +
                            "    \"timestamp\": \"2023-02-23T15:07:24.363821100Z\",\n" +
                            "    \"status\": 404,\n" +
                            "    \"error\": \"Not Found\",\n" +
                            "    \"message\": \"Invalid CPF\",\n" +
                            "    \"path\": \"/api/v1/user/887526460090\"\n" +
                            "}"))
            })
    })
    @GetMapping("/{cpf}")
    ResponseEntity<StatusDTO> getCpfStatus(@PathVariable String cpf);
}
