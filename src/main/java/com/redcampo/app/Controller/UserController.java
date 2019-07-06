package com.redcampo.app.Controller;

import com.redcampo.app.Entity.User;
import com.redcampo.app.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService usCon;

    @GetMapping("/hola")
    public String hola(){
        return "Estoy conectado wiiii";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(usCon.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity create(@Valid @RequestBody User temp){
        List<User> pair = usCon.findByUserId(temp.getUserId());
        if (pair.isEmpty()){
            usCon.create(temp);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ACEPTED");
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("DENIED");
        }
    }
}
