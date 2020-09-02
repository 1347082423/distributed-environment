package com.ex.userserver.config.access;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Describe
 * @Author wex
 * @Date 2020-9-2 11:15
 * @Version
 **/
public interface SecurityAuthorityAccess {

    boolean hasPermit(HttpServletRequest request, Authentication authentication);
}
