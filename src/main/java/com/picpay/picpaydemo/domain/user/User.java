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
@NoArgsConstructorUs

public class User extends UserBase {

    // region -- constructors
    public User (UserDTO user){
        this.setEmail(user.email());
        this.setPassword(user.password());
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.document = user.document();
        this.balance = BigDecimal.ZERO;
        this.userType = UserType.COMMON;
    }
    // endregion --

    // region -- parameters
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String document;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    // endregion

}
