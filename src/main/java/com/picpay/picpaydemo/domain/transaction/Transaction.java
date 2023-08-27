package com.picpay.picpaydemo.domain.transaction;

import com.picpay.picpaydemo.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    private BigDecimal amount;
    @ManyToOne
    private User sender;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;
    private LocalDateTime timestamp;

}
