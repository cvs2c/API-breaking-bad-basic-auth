package dev.marshallBits.breakingBadApi.dto;

import jakarta.validation.constraints.*;
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
    @Pattern( regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&_]{5,}$", message = "La contraseña de ser al menos de 5 caracteres, contener mayúscula, minúscula, un carácter especial y un numero")
    private String password;

    @Email
    private String mail;

    @NotNull
    private Integer ci;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank(message = "El username no puede estar vacío")
    @Size(min = 1, max = 100)
    private String username;

}
