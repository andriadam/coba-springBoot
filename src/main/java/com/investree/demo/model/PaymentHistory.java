package com.investree.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pembayaran_ke",length = 11)
    private int pembayaran_ke;

    @Column(name = "jumlah",length = 20)
    private Double jumlah;

    @Column(name = "bukti_pembayaran", nullable = false, length = 45)
    private String bukti_pembayaran;

    @OneToMany(mappedBy = "payment_history")
    private List<Transaksi> transaksi;
}