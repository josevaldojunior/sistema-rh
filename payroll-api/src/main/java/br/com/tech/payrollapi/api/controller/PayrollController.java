package br.com.tech.payrollapi.api.controller;

import br.com.tech.payrollapi.domain.model.Payroll;
import br.com.tech.payrollapi.domain.service.PayrollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PayrollController {

    private final PayrollService payrollService;

    @GetMapping("/{workedId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workedId, @RequestBody Payroll payment){
        return ResponseEntity.ok().body(payrollService.getPayment(workedId, payment));
    }

}
