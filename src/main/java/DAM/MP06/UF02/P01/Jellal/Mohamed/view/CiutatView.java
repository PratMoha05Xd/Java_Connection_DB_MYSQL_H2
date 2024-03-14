package DAM.MP06.UF02.P01.Jellal.Mohamed.view;

import DAM.MP06.UF02.P01.Jellal.Mohamed.model.domain.Ciutat;

public class CiutatView {

	private CiutatView() {
		commonView = CommonView.getInstance();
	}

	public static CiutatView getInstance() {
		if (instance == null) {
			instance = new CiutatView();
		}
		return instance;
	}

	private static CiutatView instance = null;

	private CommonView commonView;

	public int getIdSearch() {
		commonView.showMessage("-- Cerca per Id --", false);
		return getIdCiutat();
	}

	public Ciutat getCiutatAlta() {
		Ciutat result = new Ciutat();
		commonView.showMessage("-- ALTA --", false);
		result.setNomCiutat(getNomCiutat());
		result.setPrefixTelefonic(getPrefixTelefonic());
		return result;
	}

	public Ciutat getCiutatUpdate() {
		Ciutat result = new Ciutat();
		commonView.showMessage("-- CANVI --", false);
		result.setPk_Ciutat_Id(getIdCiutat());
		result.setNomCiutat(getNomCiutat());
		result.setPrefixTelefonic(getPrefixTelefonic());
		return result;
	}

	public int getIdCiutatDelete() {
		commonView.showMessage("-- Baixa --", false);
		return getIdCiutat();
	}

	public int getIdCiutat() {
		return commonView.getInt("Introdueix l'id de la ciutat: ");
	}

	public String getNomCiutat() {
		return commonView.getString("Introdueix el nom de la ciutat: ");
	}

	public int getPrefixTelefonic() {
		return commonView.getInt("Introdueix el prefix telefònic de la ciutat: ");
	}

	public void destroy() {
		commonView = null;
	}
}
