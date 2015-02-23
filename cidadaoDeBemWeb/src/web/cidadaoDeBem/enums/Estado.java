package web.cidadaoDeBem.enums;

public enum Estado {

	AC("Acre"), AL("Alagoas"), AP("Amap�"), AM("Amazonas"), BA("Bahia"), CE(
			"Cear�"), DF("Distrito Federal"), GO("Goi�s"), ES("Esp�rito Santo"), MA(
			"Maranh�o"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
			"Minas Gerais"), PA("Par�"), PB("Paraiba"), PR("Paran�"), PE(
			"Pernambuco"), PI("Piau�"), RJ("Rio de Janeiro"), RN(
			"Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rond�nia"), RR(
			"Ror�ima"), SP("S�o Paulo"), SC("Santa Catarina"), SE("Sergipe"), TO(
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