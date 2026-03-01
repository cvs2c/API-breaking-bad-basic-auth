package dev.marshallBits.breakingBadApi.services.user;

import dev.marshallBits.breakingBadApi.dto.CreateLoginUserDTO;
import dev.marshallBits.breakingBadApi.dto.CreateUserDTO;
import dev.marshallBits.breakingBadApi.dto.LoginResponseDTO;
import dev.marshallBits.breakingBadApi.models.User;
import dev.marshallBits.breakingBadApi.models.UserRole;
import dev.marshallBits.breakingBadApi.repositories.UserRepository;
import dev.marshallBits.breakingBadApi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImp implements UserSercive{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public User registerUser(CreateUserDTO user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
       User newUser = new User();
        newUser.setUserRole(UserRole.ROLE_USER);
        newUser.setName(user.getName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        newUser.setCi(user.getCi());
        newUser.setMail(user.getMail());
        newUser.setPhone(user.getPhone());

        return userRepository.save(newUser);

    }

    @Override
    public LoginResponseDTO authenticateUser(CreateLoginUserDTO user) {
       User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña inconrrecto"));

       //La contraseña no es correcta
        if(!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña incorrecta");
        }

        String token = jwtUtil.generateTocken(existingUser.getUsername(), existingUser.getUserRole().name());

        return LoginResponseDTO.builder()
                .token(token)
                .username(existingUser.getUsername())
                .build();
    }

}
