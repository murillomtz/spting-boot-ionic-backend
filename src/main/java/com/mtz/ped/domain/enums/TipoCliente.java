package com.mtz.ped.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descrição;

	private TipoCliente(int cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {

			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
