package DAM.MP06.UF02.P01.Jellal.Mohamed.model.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionRepository {

	private ConnectionRepository() {

	}

	public static ConnectionRepository getInstance() {
		if (instance == null) {
			instance = new ConnectionRepository();
		}
		return instance;
	}

	private static ConnectionRepository instance = null;

	public Connection getConnection() throws SQLException {
		ConnectionParams p = new ConnectionParams();
		return this.getConnection(p);
	}

	public Connection getConnection(ConnectionParams p) throws SQLException {
		Connection connection = null;

//		String jdbcUrl = "jdbc:h2:C:/work/prat/h2db/test1";
//		String userName = "sa";
//		String password = "";

		String jdbcUrl = null;

		if (p.getPort() == null) {
			jdbcUrl = p.getProtocol() + ":" + p.getTipusBaseDades() + ":" + p.getServidor() + p.getNomBaseDades();
		} else {
			jdbcUrl = p.getProtocol() + ":" + p.getTipusBaseDades() + ":" + p.getServidor() + ":" + p.getPort() + "/"
					+ p.getNomBaseDades();
		}
		System.out.println(jdbcUrl);

		String userName = p.getNomUsuari();
		String password = p.getPassword();

		try {
			// Class.forName("org.h2.Driver");
			Class.forName(p.getClassDriver());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}

		try {
			connection = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (SQLException e) {
			throw e;
		}

		// System.out.println("Connexió realitzada correctament");
		return connection;

	}

}
