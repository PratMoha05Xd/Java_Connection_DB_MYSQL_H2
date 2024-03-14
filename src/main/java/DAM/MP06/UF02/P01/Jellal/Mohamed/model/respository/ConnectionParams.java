package DAM.MP06.UF02.P01.Jellal.Mohamed.model.respository;

import DAM.MP06.UF02.P01.Jellal.Mohamed.model.configuration.MySettings;

public class ConnectionParams {

	public ConnectionParams() {
		super();
		MySettings s = MySettings.getInstance();
		this.classDriver = s.getDbDriver();
		this.protocol = s.getProtocol();
		this.tipusBaseDades = s.getTipusBaseDades();
		this.servidor = s.getServidor();
		this.port = s.getPort();
		this.nomBaseDades = s.getNomBaseDades();
		this.nomUsuari = s.getNomUsuari();
		this.password = s.getPassword();
	}

	public ConnectionParams(String classDriver, String protocol, String tipusBaseDades, String servidor, Integer port,
			String nomBaseDades, String nomUsuari, String password) {
		super();
		this.classDriver = classDriver;
		this.protocol = protocol;
		this.tipusBaseDades = tipusBaseDades;
		this.servidor = servidor;
		this.port = port;
		this.nomBaseDades = nomBaseDades;
		this.nomUsuari = nomUsuari;
		this.password = password;
	}

	private String classDriver;
	private String protocol;
	private String tipusBaseDades;
	private String servidor;
	private Integer port;
	private String nomBaseDades;
	private String nomUsuari;
	private String password;

	public String getClassDriver() {
		return classDriver;
	}

	public void setClassDriver(String classDriver) {
		this.classDriver = classDriver;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getTipusBaseDades() {
		return tipusBaseDades;
	}

	public void setTipusBaseDades(String tipusBaseDades) {
		this.tipusBaseDades = tipusBaseDades;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getNomBaseDades() {
		return nomBaseDades;
	}

	public void setNomBaseDades(String nomBaseDades) {
		this.nomBaseDades = nomBaseDades;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConnectionParams [classDriver=" + classDriver + ", protocol=" + protocol + ", tipusBaseDades="
				+ tipusBaseDades + ", servidor=" + servidor + ", port=" + port + ", nomBaseDades=" + nomBaseDades
				+ ", nomUsuari=" + nomUsuari + ", password=" + password + "]";
	}

}
