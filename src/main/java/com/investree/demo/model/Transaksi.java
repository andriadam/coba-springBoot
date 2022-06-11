package com.investree.demo.model;
import com.investree.demo.model.oauth.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_peminjam")
    private Long id_peminjam;

    @Column(name = "id_meminjam")
    private Long id_meminjam;

    @Column(name = "tenor",length = 11)
    private int tenor;

    @Column(name = "total_pinjaman",length = 20)
    private Double total_pinjaman;

    @Column(name = "bunga_persen",length = 20)
    private Double bunga_persen;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User users;

    @ManyToOne
    @JoinColumn(name = "payment_history_id")
    PaymentHistory payment_history;
}
