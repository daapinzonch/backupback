package com.redcampo.app.Controller;

import com.redcampo.app.Entity.User;
import com.redcampo.app.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiuser")
public class UserController {
    private final UserService usCon;

    @GetMapping
    public String msg(){
        return "USERS AVAIABLE";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(usCon.findAll());
    }

    @PostMapping(path ="/insertdata", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        List<User> users = usCon.findByUserId(user.getUserId());
        if (users.isEmpty()){
            usCon.create(user);
            return new ResponseEntity<>("USER CREATED", HttpStatus.ACCEPTED);
        }else {
            User empty = new User();
            return new ResponseEntity<>("USER DUPLICATED", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletedata/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        List<User> users = usCon.findByUserId(id);
        if(!users.isEmpty()) {
            for (int i = 0; i < users.size(); i++) {
                usCon.delete(users.get(i));
            }
            return new ResponseEntity<>("USER DELETED", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("USER EMPTY", HttpStatus.BAD_REQUEST);
        }
    }
}
