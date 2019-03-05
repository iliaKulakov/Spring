package io.github.personal_finance.domainSecurity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usersLogins")
public class UserSecurity //implements UserDetails
{

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private long id;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name = "username", length = 256)
    private String username;

//    private List<Role> authorities;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;

//    //i don't know but lombok does not work correctly and i overrided methods manually
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
////
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
////
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
