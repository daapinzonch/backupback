package com.redcampo.app.Entity.Support;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {
    private String User;
    private String Token;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
