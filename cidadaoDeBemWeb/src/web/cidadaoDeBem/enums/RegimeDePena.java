package web.cidadaoDeBem.enums;

public enum RegimeDePena {
	Aberto("aberto"), Fechado("fechado"), Semi_Aberto("semi_aberto");

	RegimeDePena(String regime) {

	}

	public static RegimeDePena getRegimeDePena(String regime) {
		if (regime != null) {
			for (RegimeDePena r : values()) {
				if (regime.equalsIgnoreCase(r.name()))
					return r;
			}
		}
		return null;
	}
}
