package com.mtz.ped.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.mtz.ped.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);

		sendEmail(sm);
	}

	// Protect pois ele pode ser acessado por subclasses, classes filhas
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido Confirmardo!: Codigo" + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis())); // Seta a data atual do servidor
		sm.setText(obj.toString());
		return sm;
	}

}
