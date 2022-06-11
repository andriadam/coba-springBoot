package com.investree.demo.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestingController {

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void restTemplateSave() throws Exception {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        String bodyTesting = "{\"id\":2,\"bunga_persen\":20,\"id_meminjam\":1,\"id_peminjam\":1,\"status\":\"lunas\",\"tenor\":12,\"total_pinjaman\":100000,\"payment_history_id\":1,\"user_id\":1}";
//        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
//        ResponseEntity<String> exchange = restTemplate.exchange
//                ("http://localhost:8081/api/v1/transaksi", HttpMethod.POST, entity, String.class);
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        System.out.println("response =" + exchange.getBody());
//    }
}
