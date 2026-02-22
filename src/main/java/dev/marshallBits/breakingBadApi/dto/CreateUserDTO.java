package dev.marshallBits.breakingBadApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String password;

    @Email
    private String mail;

    @NotNull
    @NotEmpty
    private Integer ci;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String username;

}
