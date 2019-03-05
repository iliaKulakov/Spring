package io.github.personal_finance.domainSecurity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

import static io.github.personal_finance.domainSecurity.Role.USER;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usersLogins")
public class UserSecurity implements UserDetails
{
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private long id;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name = "username", length = 256)
    private String username;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "accountNonExpired", columnDefinition = "BIT", length = 1)
    private boolean accountNonExpired;

    @Column(name = "accountNonLocked", columnDefinition = "BIT", length = 1)
    private boolean accountNonLocked;

    @Column(name = "credentialsNonExpired", columnDefinition = "BIT", length = 1)
    private boolean credentialsNonExpired;

    @Column(name = "enabled", columnDefinition = "BIT", length = 1)
    private boolean enabled;

//    //i don't know but lombok does not work correctly and i overrided methods manually
    @Override
    public boolean isEnabled() {
//        boolean enabled;
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired(){
//        boolean credentialsNonExpired;
        return credentialsNonExpired;
    }
//
    @Override
    public boolean isAccountNonLocked(){
//        boolean accountNonLocked;
        return accountNonLocked;
    }
//
    @Override
    public boolean isAccountNonExpired(){
//        boolean accountNonExpired;
        return accountNonExpired;
    }
//
    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }
//
    @Override
    public List<Role> getAuthorities(){
        List<Role> authorities = Arrays.asList(USER);
        return authorities;
    }
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
