package io.github.personal_finance.domainSecurity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSecurity implements UserDetails {
    private List<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

//    //i don't know but lombok does not work correctly and i overrided methods manually
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired(){
//        return credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked(){
//        return accountNonLocked;
//    }
//
//    @Override
//    public boolean isAccountNonExpired(){
//        return accountNonExpired;
//    }
//
//    @Override
//    public String getUsername(){
//        return username;
//    }
//
//    @Override
//    public String getPassword(){
//        return password;
//    }
//
//    @Override
//    public List<Role> getAuthorities(){
//        return authorities;
//    }
//
//    public UserSecurity(List<Role> authorities, String password, String username, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
//        this.authorities = authorities;
//        this.password = password;
//        this.username = username;
//        this.accountNonExpired = accountNonExpired;
//        this.accountNonLocked = accountNonLocked;
//        this.credentialsNonExpired = credentialsNonExpired;
//        this.enabled = enabled;
//    }
}
