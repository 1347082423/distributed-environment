package com.ex.userserver;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Describe
 * @Author wex
 * @Date 2020-9-2 13:58
 * @Version
 **/
public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        boolean matches = bCryptPasswordEncoder.matches("123", "$10$NRTOaqnHlqd27OsKH/CwGOxuf/UWsC05JbPIlquxGCE0dEypbABxS");
        System.out.println(matches);
//$10$NRTOaqnHlqd27OsKH/CwGOxuf/UWsC05JbPIlquxGCE0dEypbABxS
    }
}
