package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    public TransaksiService service;

    @Autowired
    public TransaksiRepository repo;


    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
        Map save = service.save(objModel);
        Map map = new HashMap();
        map.put("data",save);
        map.put("status", "sukses");
        map.put("code", "200");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel) {
        Map save = service.updateStatus(objModel);
        Map map = new HashMap();
        map.put("data",save);
        map.put("status", "sukses");
        map.put("code", "200");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map> getListData(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String status) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = null;
        if (status != null) {
            repo.getByStatus(status, show_data);
        } else {
            repo.getAllData(show_data);
        }
        Map map = new HashMap();
        map.put("content", list);
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }
}
