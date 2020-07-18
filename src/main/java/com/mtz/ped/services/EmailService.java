package com.mtz.ped.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.mtz.ped.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	// Envio em Texto Plano
	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	// Html
	void sendHtmlEmail(MimeMessage msg);

}
