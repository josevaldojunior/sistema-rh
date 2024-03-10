package br.com.tech.payrollapi.domain.service;

import br.com.tech.payrollapi.api.feignClients.UserFeign;
import br.com.tech.payrollapi.domain.exception.EntityNotFoundException;
import br.com.tech.payrollapi.domain.model.Payroll;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment environment;
    private final UserFeign feign;

    public Payroll getPayment(Long workedId, Payroll payroll) {

        log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");

        try {
            var user = feign.findById(workedId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getNome(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()

                );
            }
        } catch (FeignException.NotFound ex) {
            throw new EntityNotFoundException("Entity not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exeception");
        }
        return null;
    }

}
