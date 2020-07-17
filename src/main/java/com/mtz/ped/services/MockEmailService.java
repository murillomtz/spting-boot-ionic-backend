package com.mtz.ped.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	// Static para não ter q criar varas variaveis ao chamar o metodo, um servirá
	// para todos
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando encio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");

	}

}
