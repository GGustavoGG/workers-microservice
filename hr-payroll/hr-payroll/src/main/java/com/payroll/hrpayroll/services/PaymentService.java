package com.payroll.hrpayroll.services;

import com.payroll.hrpayroll.entities.Payment;
import com.payroll.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(
                workerHost + "/workers/{id}", Worker.class, uriVariables);
        if (Objects.isNull(worker)) return null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
