package DAM.MP06.UF02.P01.Jellal.Mohamed.controller;

import java.util.ArrayList;

import DAM.MP06.UF02.P01.Jellal.Mohamed.model.domain.Ciutat;
import DAM.MP06.UF02.P01.Jellal.Mohamed.model.service.CiutatService;
import DAM.MP06.UF02.P01.Jellal.Mohamed.view.CommonView;
import DAM.MP06.UF02.P01.Jellal.Mohamed.view.CiutatView;

public class CiutatController {

	private CiutatController() {
		ciutatService = CiutatService.getInstance();
		commonView = CommonView.getInstance();
		ciutatView = CiutatView.getInstance();
	}

	public static CiutatController getInstance() {
		if (instance == null) {
			instance = new CiutatController();
		}
		return instance;
	}

	private static CiutatController instance = null;

	private CiutatService ciutatService = null;
	private CiutatView ciutatView = null;
	private CommonView commonView = null;

	public void getUnaCiutat() {
		try {
			int id = ciutatView.getIdCiutat();
			Ciutat ciutat = ciutatService.getOne(id);
			commonView.showMessage(ciutat.toString(), false);

		} catch (Exception e) {
			commonView.showMessage(e.getMessage(), true);
		}
	}

	public void getAll() {
		try {

			ArrayList<Ciutat> ciutats = ciutatService.getAll();
			commonView.showMessage(ciutats.toString(), false);

		} catch (Exception e) {
			commonView.showMessage(e.getMessage(), true);
		}
	}

	public void ciutatAlta() {
		try {
			Ciutat ciutat = ciutatView.getCiutatAlta();
			int filesAfectades = ciutatService.insert(ciutat);

			if (filesAfectades > 0) {
				commonView.showMessage("Alta realitzada", false);
			}

		} catch (Exception e) {
			commonView.showMessage(e.getMessage(), true);
		}
	}

	public void ciutatUpdate() {
		try {
			Ciutat ciutat = ciutatView.getCiutatUpdate();
			int filesAfectades = ciutatService.update(ciutat);
			if (filesAfectades > 0) {
				commonView.showMessage("Modificació realitzada", false);
			} else {
				commonView.showMessage("No s'ha trobat cap ciutat amb aquest Id", false);
			}

		} catch (Exception e) {
			commonView.showMessage(e.getMessage(), true);
		}
	}

	public void ciutatDelete() {
		try {
			int id = ciutatView.getIdCiutatDelete();
			int filesAfectades = ciutatService.delete(id);
			if (filesAfectades > 0) {
				commonView.showMessage("Baixa realitzada", false);
			} else {
				commonView.showMessage("No s'ha trobat cap ciutat amb aquest Id", false);
			}

		} catch (Exception e) {
			commonView.showMessage(e.getMessage(), true);
		}
	}
}
