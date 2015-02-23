package web.cidadaoDeBem.enums;

public enum Estado {

	AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE(
			"Ceará"), DF("Distrito Federal"), GO("Goiás"), ES("Espírito Santo"), MA(
			"Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
			"Minas Gerais"), PA("Pará"), PB("Paraiba"), PR("Paraná"), PE(
			"Pernambuco"), PI("Piauí"), RJ("Rio de Janeiro"), RN(
			"Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rondônia"), RR(
			"Rorâima"), SP("São Paulo"), SC("Santa Catarina"), SE("Sergipe"), TO(
			"Tocantins");

	Estado(String nome) {

	}

	public static Estado getEstado(String estado) {
		if (estado != null) {
			for (Estado e : values()) {
				if (estado.equalsIgnoreCase(e.name()))
					return e;
			}
		}
		return null;
	}
}