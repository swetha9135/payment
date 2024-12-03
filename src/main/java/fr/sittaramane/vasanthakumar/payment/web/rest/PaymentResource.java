package fr.sittaramane.vasanthakumar.payment.web.rest;

import fr.sittaramane.vasanthakumar.payment.business.PaymentService;
import fr.sittaramane.vasanthakumar.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController(PaymentResource.PAYMENT)
public class PaymentResource {

    public static final String PAYMENT = "/payment";


    @Autowired
    private PaymentService paymentService;

    @PostMapping(PAYMENT)
    public void createPayment(@RequestBody Payment payment) {
        paymentService.createPayment(payment);
    }
    
    // get localhost:8080/payment
    @GetMapping(PAYMENT)
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }

    // localhost:8080/payment?id=1
    @GetMapping(value = PAYMENT, params = "id")
    public Payment getPayment(long id) {
        return paymentService.getPaymentById(id);
    }
    
    @PutMapping(PAYMENT)
    public void updateHeavilyPayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
    }
    
    @PatchMapping(PAYMENT)
    public void updateLightlyPayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
    }
    
    @DeleteMapping(value = "deleteById", params = "id")
    public void deletePaymentById(long id) {
        paymentService.deletePaymentById(id);
    }
    
    @DeleteMapping(PAYMENT)
    public void deletePayment(@RequestBody Payment payment) {
        paymentService.deletePayment(payment);
    }
    
    
    
}
