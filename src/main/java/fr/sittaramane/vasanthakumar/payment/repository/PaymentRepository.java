package fr.sittaramane.vasanthakumar.payment.repository;

import fr.sittaramane.vasanthakumar.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
