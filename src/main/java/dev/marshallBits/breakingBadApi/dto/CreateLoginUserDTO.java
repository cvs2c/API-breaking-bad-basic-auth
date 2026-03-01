package dev.marshallBits.breakingBadApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateLoginUserDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
