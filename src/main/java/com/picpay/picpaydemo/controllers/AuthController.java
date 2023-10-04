package com.picpay.picpaydemo.controllers;
import com.picpay.picpaydemo.auth.security.TokenService;
import com.picpay.picpaydemo.domain.user.User;
import com.picpay.picpaydemo.dtos.AuthDTO;
import com.picpay.picpaydemo.dtos.LoginResponseDTO;
import com.picpay.picpaydemo.dtos.RegisterDTO;
import com.picpay.picpaydemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthDTO authDTO){

        String encryptedPassword = new BCryptPasswordEncoder().encode(authDTO.password());

        var userPassword = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());

        var auth = this.authenticationManager.authenticate(userPassword);

        var token = tokenService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword, data.firstName(), data.lastName(), data.document());
        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }



}
