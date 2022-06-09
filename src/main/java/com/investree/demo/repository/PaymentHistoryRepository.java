package com.investree.demo.repository;

import com.investree.demo.model.PaymentHistory;
import com.investree.demo.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    @Query("select c from PaymentHistory c")
    public List<Transaksi> getList();
}
