package fr.sittaramane.vasanthakumar.payment.business;

import fr.sittaramane.vasanthakumar.payment.model.Payment;
import fr.sittaramane.vasanthakumar.payment.repository.PaymentRepository;
import fr.sittaramane.vasanthakumar.payment.web.rest.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public void createPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPaymentById(long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent()) {
            return payment.get();
        } else {
            throw new ResourceNotFoundException("Payment with id " + id + " not found");
        }
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void updatePayment(Payment payment){
        if (payment.getId() != null) {
            paymentRepository.save(payment);
        } else {
            throw new ResourceNotFoundException("Id non valide");
        }
    }

    public void deletePaymentById(long id) {
        paymentRepository.deleteById(id);
    }

    public void deletePayment(Payment payment) {
        if (payment.getId() != null) {
            paymentRepository.delete(payment);
        } else {
            throw new ResourceNotFoundException("Id non valide");
        }
    }
}
