package com.redcampo.app.Repository;

import com.redcampo.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    public List<User> findByUserId(long id);
}
