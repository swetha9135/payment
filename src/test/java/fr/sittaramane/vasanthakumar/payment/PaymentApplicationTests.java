package fr.sittaramane.vasanthakumar.payment;

import fr.sittaramane.vasanthakumar.payment.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPayment(){
		Payment payment = Payment.builder().payed(true).amount(BigDecimal.valueOf(112.45 )).build();
		ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(
				"http://localhost:" + port + "/payment", payment, String.class);
		Assertions.assertTrue(stringResponseEntity.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void getPayment(){
		ResponseEntity<List> stringResponseEntity = restTemplate.getForEntity(
				"http://localhost:" + port + "/payment", List.class);
		Assertions.assertTrue(stringResponseEntity.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void getPaymentById(){
		long id = new Random().nextLong(Long.MAX_VALUE);
		ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(
				"http://localhost:" + port + "/payment?id="+id, String.class);
		Assertions.assertTrue(stringResponseEntity.getStatusCode().is4xxClientError());
	}

	@Test
	public void createAndPatchPayment(){
		Payment payment = Payment.builder().payed(true).amount(BigDecimal.valueOf(112.45 )).build();
		ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(
				"http://localhost:" + port + "/payment", payment, String.class);
		Assertions.assertTrue(stringResponseEntity.getStatusCode().is2xxSuccessful());

		payment.setAmount(BigDecimal.valueOf(559.99 ));
		String stringResponseEntityPatched = restTemplate.patchForObject(
				"http://localhost:" + port + "/payment", payment, String.class);
		Assertions.assertNotNull(stringResponseEntityPatched);
	}

	@Test
	public void createAndPutPayment(){
		Payment payment = Payment.builder().payed(true).amount(BigDecimal.valueOf(112.45 )).build();
		ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(
				"http://localhost:" + port + "/payment", payment, String.class);
		Assertions.assertTrue(stringResponseEntity.getStatusCode().is2xxSuccessful());

		payment.setPayed(false);
		restTemplate.put(
				"http://localhost:" + port + "/payment", payment, "");
	}


	@Test
	public void deletePaymentById(){
		long id = new Random().nextLong(Long.MAX_VALUE);
		restTemplate.delete(
				"http://localhost:" + port + "/payment?id="+id);
	}


	@Test
	public void deletePaymentByObject(){
		restTemplate.delete(
				"http://localhost:" + port + "/payment", new Payment());
	}

}
