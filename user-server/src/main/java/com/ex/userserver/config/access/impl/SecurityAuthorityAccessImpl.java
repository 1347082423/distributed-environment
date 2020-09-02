package com.ex.userserver.config.access.impl;

import com.ex.comm.pojo.ExSysUser;
import com.ex.userserver.config.access.SecurityAuthorityAccess;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * @Describe
 * @Author wex
 * @Date 2020-9-2 11:16
 * @Version
 **/
@Service
public class SecurityAuthorityAccessImpl implements SecurityAuthorityAccess {

    @Override
    public boolean hasPermit(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        ExSysUser exSysUser = null;
        String requestURI = request.getRequestURI();
        if (principal instanceof ExSysUser)
            exSysUser = (ExSysUser) principal;
        if (exSysUser != null){
            Collection<? extends GrantedAuthority> authorities = exSysUser.getAuthorities();
            return authorities.stream().anyMatch(authoritie -> requestURI.equals(((GrantedAuthority) authoritie).getAuthority()));

        }
        return false;
    }
}
