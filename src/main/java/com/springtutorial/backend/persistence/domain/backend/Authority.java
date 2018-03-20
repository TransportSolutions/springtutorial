package com.springtutorial.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by agrewal on 2/23/18.
 */
public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
