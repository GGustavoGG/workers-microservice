package com.payroll.hrpayroll.services;

import com.payroll.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("bob", 200.0, days);
    }
}
