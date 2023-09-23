package com.picpay.picpaydemo.domain.user;
import com.picpay.picpaydemo.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User implements UserDetails {

    // region -- constructors
    public User (UserDTO user){
        this.email = user.email();
        this.password = user.password();
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.document = user.document();
        this.balance = BigDecimal.ZERO;
        this.role = user.role();
    }

    // endregion --

    // region -- parameters
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String document;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String email, String encryptedPassword, String firstName, String lastName, String document) {
        this.email = email;
        this.password = encryptedPassword;
        this.role = UserRole.COMMON;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.balance = BigDecimal.ZERO;
    }

    // endregion

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public UserRole getRole(){
        return this.role;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // endregion

}
