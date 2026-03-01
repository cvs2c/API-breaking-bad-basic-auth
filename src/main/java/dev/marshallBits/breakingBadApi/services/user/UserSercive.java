package dev.marshallBits.breakingBadApi.services.user;

import dev.marshallBits.breakingBadApi.dto.CreateLoginUserDTO;
import dev.marshallBits.breakingBadApi.dto.CreateUserDTO;
import dev.marshallBits.breakingBadApi.dto.LoginResponseDTO;
import dev.marshallBits.breakingBadApi.models.User;

public interface UserSercive {

    User registerUser(CreateUserDTO user);

    LoginResponseDTO authenticateUser(CreateLoginUserDTO user);

}
