package br.com.felipetravassos.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.felipetravassos.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
