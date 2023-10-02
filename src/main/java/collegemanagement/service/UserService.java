package collegemanagement.service;

import collegemanagement.entities.Users;
import collegemanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private UserRepo userRepo;
    public Users addUser(Users userDto) {
        Users  users = new Users();

        users.setUsername(userDto.getUsername());
        users.setRoles(userDto.getRoles());
        users.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepo.save(users);
    }
}
