package DAM.MP06.UF02.P01.Jellal.Mohamed.model.respository;

import DAM.MP06.UF02.P01.Jellal.Mohamed.model.domain.Ciutat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CiutatRepository {

	private CiutatRepository() {
		connectionRepository = ConnectionRepository.getInstance();
	}

	public static CiutatRepository getInstance() {
		if (instance == null) {
			instance = new CiutatRepository();
		}
		return instance;
	}

	private static CiutatRepository instance = null;

	private ConnectionRepository connectionRepository = null;

	public Ciutat getOne(int idCiutat) throws SQLException {
		Ciutat result = null;
		String sql = Ciutat.getSQLSelectOne(idCiutat);

		ArrayList<Ciutat> list = getAllBasic(sql);
		if (list != null && list.size() > 0) {
			result = list.get(0);
		}

		return result;
	}

	public ArrayList<Ciutat> getAll() throws SQLException {
		String sql = Ciutat.getSQLSelectAll();
		return getAllBasic(sql);
	}

	public int insert(Ciutat ciutat) throws SQLException {
		String sql = Ciutat.getSQLInsert(ciutat);
		return updateDatabase(sql);
	}

	public int update(Ciutat ciutat) throws SQLException {
		String sql = Ciutat.getSQLUpdate(ciutat);
		return updateDatabase(sql);
	}

	public int delete(int id) throws SQLException {
		String sql = Ciutat.getSQLDelete(id);
		return updateDatabase(sql);
	}

	private ArrayList<Ciutat> getAllBasic(String sql) throws SQLException {
		Connection connection = null;
		ArrayList<Ciutat> result = new ArrayList<>();

		try {
			connection = connectionRepository.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Ciutat ciutat = new Ciutat();
				ciutat.setPk_Ciutat_Id(resultSet.getInt(1));
				ciutat.setNomCiutat(resultSet.getString(2));
				ciutat.setPrefixTelefonic(resultSet.getInt(3));
				result.add(ciutat);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}

	private int updateDatabase(String sql) throws SQLException {
		int result = 0;
		Connection connection = null;

		try {
			connection = connectionRepository.getConnection();
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(sql);
		} catch (SQLException e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}
}
