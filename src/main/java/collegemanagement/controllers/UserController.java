package collegemanagement.controllers;

import collegemanagement.entities.Users;
import collegemanagement.requestDto.UserDto;
import collegemanagement.responseDto.ApiResponse;
import collegemanagement.security.AuthRequest;
import collegemanagement.security.JwtService;
import collegemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<Users>> createStudent(@RequestBody Users users){
        return new ResponseEntity<>(new ApiResponse<>(userService.addUser(users)), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        //authentication for verify the user before generating the token
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else {
            throw new UsernameNotFoundException("Invalid user request !");
        }

    }



}
