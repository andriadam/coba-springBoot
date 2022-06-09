package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean is_active = true;

    @OneToOne(mappedBy = "users")
    private UserDetail user_detail;

    @OneToMany(mappedBy = "users")
    private List<Transaksi> transaksi;
}
