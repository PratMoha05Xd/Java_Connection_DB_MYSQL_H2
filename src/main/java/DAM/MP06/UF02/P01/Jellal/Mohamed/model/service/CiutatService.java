package DAM.MP06.UF02.P01.Jellal.Mohamed.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAM.MP06.UF02.P01.Jellal.Mohamed.model.domain.Ciutat;
import DAM.MP06.UF02.P01.Jellal.Mohamed.model.respository.CiutatRepository;

public class CiutatService {

	private CiutatService() {
		ciutatRepository = CiutatRepository.getInstance();
	}

	public static CiutatService getInstance() {
		if (instance == null) {
			instance = new CiutatService();
		}
		return instance;
	}

	private static CiutatService instance = null;

	private CiutatRepository ciutatRepository = null;

	public Ciutat getOne(int id) throws SQLException {
		Ciutat ciutat = ciutatRepository.getOne(id);
		if (ciutat == null) {
			throw new RuntimeException("No hi ha cap ciutat amb aquest id");
		}

		return ciutat;
	}

	public ArrayList<Ciutat> getAll() throws SQLException {
		return ciutatRepository.getAll();
	}

	public int insert(Ciutat ciutat) throws SQLException {
		validaCiutat(ciutat);
		return ciutatRepository.insert(ciutat);
	}

	public int update(Ciutat ciutat) throws SQLException {
		validaCiutat(ciutat);
		return ciutatRepository.update(ciutat);
	}

	public int delete(int id) throws SQLException {
		return ciutatRepository.delete(id);
	}

	private void validaCiutat(Ciutat ciutat) {
		if (ciutat == null) {
			throw new RuntimeException("L'entitat és nul·la");
		}
		String nom = ciutat.getNomCiutat();
		if (nom == null || nom.length() < 2) {
			throw new RuntimeException("El nom de la ciutat ha de tenir almenys dos caràcters");
		}
	}
}