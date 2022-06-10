package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService {
    @Autowired
    public TransaksiRepository repo;

    @Override
    public Map save(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi obj = repo.save(transaksi);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;

        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi update = repo.getById(transaksi.getId());
            update.setStatus(transaksi.getStatus());
            Transaksi doSave = repo.save(update);
            map.put("data", doSave);
            map.put("code", "200");
            map.put("status", "success");
            return map;

        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
    }
}
