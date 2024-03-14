package DAM.MP06.UF02.P01.Jellal.Mohamed.model.configuration;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class MySettings {

	private MySettings() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(FILE)));
			inits();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MySettings getInstance() {
		if (instance == null) {
			instance = new MySettings();
		}
		return instance;
	}

	private static MySettings instance = null;

	private String prefixe_Db = "";

	private final static String FILE = "src/Files/configuration.properties";
	private Properties properties;

	private void inits() {
		prefixe_Db = (String) properties.get("current_type_db") + "_";
	}

	public String getDbDriver() {
		return (String) properties.get(prefixe_Db + "classDriver");
	}

	public String getProtocol() {
		return (String) properties.get(prefixe_Db + "protocol");
	}

	public String getTipusBaseDades() {
		return (String) properties.get(prefixe_Db + "tipusBaseDades");
	}

	public String getServidor() {
		return (String) properties.get(prefixe_Db + "servidor");
	}

	public Integer getPort() {
		Integer result = null;
		String wPort = (String) properties.get(prefixe_Db + "port");
		if (wPort != null) {
			result = Integer.parseInt(wPort);
		}
		return result;
	}

	public String getNomBaseDades() {
		return (String) properties.get(prefixe_Db + "nomBaseDades");
	}

	public String getNomUsuari() {
		return (String) properties.get(prefixe_Db + "nomUsuari");
	}

	public String getPassword() {
		return (String) properties.get(prefixe_Db + "password");
	}

	/*
	 * protocol=jdbc tipusBaseDades=h2 servidor=C:/work/prat/h2db/ #port=
	 * nomBaseDades=test1 nomUsuari=sa password=
	 * 
	 */

}
