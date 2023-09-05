package com.picpay.picpaydemo.domain.user;


import com.picpay.picpaydemo.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class User {


    public User (UserDTO user){
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.email = user.email();
        this.document = user.document();
        this.password = user.password();
        //this.balance = BigDecimal.ZERO;
        this.userType = UserType.COMMON;
        this.balance = user.amount();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String document;
    @Column(unique=true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
