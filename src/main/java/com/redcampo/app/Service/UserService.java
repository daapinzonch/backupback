package com.redcampo.app.Service;

import com.redcampo.app.Entity.User;
import com.redcampo.app.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public List<User> findByUserId(Long id){
        return userRepo.findByUserId(id);
    }

    public User create(User user){
        return userRepo.save(user);
    }
}
