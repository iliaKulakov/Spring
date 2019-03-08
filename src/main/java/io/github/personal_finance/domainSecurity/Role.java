package io.github.personal_finance.domainSecurity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER;

    @Override
    public String getAuthority() {
        return name();
    }

}
