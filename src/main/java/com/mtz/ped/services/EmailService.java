package com.mtz.ped.services;

import org.springframework.mail.SimpleMailMessage;

import com.mtz.ped.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
