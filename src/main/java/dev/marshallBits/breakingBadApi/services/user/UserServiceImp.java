package dev.marshallBits.breakingBadApi.services.user;

import dev.marshallBits.breakingBadApi.dto.CreateUserDTO;
import dev.marshallBits.breakingBadApi.models.User;
import dev.marshallBits.breakingBadApi.models.UserRole;
import dev.marshallBits.breakingBadApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImp implements UserSercive{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(CreateUserDTO user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
       User newUser = new User();
        newUser.setUserRole(UserRole.ROLE_USER);
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setCi(user.getCi());
        newUser.setMail(user.getMail());
        newUser.setPhone(user.getPhone());

        return userRepository.save(newUser);

    }

}
