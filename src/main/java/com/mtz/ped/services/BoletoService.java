package com.mtz.ped.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.mtz.ped.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date InstateDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(InstateDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}

}
