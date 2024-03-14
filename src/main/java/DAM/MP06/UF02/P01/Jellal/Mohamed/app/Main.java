package DAM.MP06.UF02.P01.Jellal.Mohamed.app;

import DAM.MP06.UF02.P01.Jellal.Mohamed.controller.CiutatController;

public class Main {

	public static void main(String[] args) {

		CiutatController ciutatController = CiutatController.getInstance();

		ciutatController.ciutatAlta();
		ciutatController.ciutatUpdate();
		ciutatController.ciutatDelete();
		ciutatController.getUnaCiutat();
		ciutatController.getAll();
	}
}
