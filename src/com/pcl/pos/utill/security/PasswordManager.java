package com.pcl.pos.utill.security;

import org.mindrot.BCrypt;

public class PasswordManager {
    public String encode(String rawPassword){
     return   BCrypt.hashpw(rawPassword,BCrypt.gensalt(10));
    }
    public boolean check(String rawPassword,String haspassword){
        return BCrypt.checkpw(rawPassword,haspassword);
    }
}
