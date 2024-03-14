package DAM.MP06.UF02.P01.Jellal.Mohamed.model.domain;

public class Ciutat {

	private int pk_Ciutat_Id;
	private String nomCiutat;
	private int prefixTelefonic;

	public int getPk_Ciutat_Id() {
		return pk_Ciutat_Id;
	}

	public void setPk_Ciutat_Id(int pk_Ciutat_Id) {
		this.pk_Ciutat_Id = pk_Ciutat_Id;
	}

	public String getNomCiutat() {
		return nomCiutat;
	}

	public void setNomCiutat(String nomCiutat) {
		this.nomCiutat = nomCiutat;
	}

	public int getPrefixTelefonic() {
		return prefixTelefonic;
	}

	public void setPrefixTelefonic(int prefixTelefonic) {
		this.prefixTelefonic = prefixTelefonic;
	}

	@Override
	public String toString() {
		return "Ciutat [pk_Ciutat_Id=" + pk_Ciutat_Id + ", nomCiutat=" + nomCiutat + ", prefixTelefonic=" + prefixTelefonic + "]";
	}

	public static String getSQLSelectAll() {
		return "SELECT * FROM Ciutats";
	}

	public static String getSQLSelectOne(int idCiutat) {
		return "SELECT * FROM Ciutats WHERE pk_Ciutat_Id = " + idCiutat;
	}

	public static String getSQLInsert(Ciutat ciutat) {
		return "INSERT INTO Ciutats (nomCiutat, prefixTelefonic) VALUES ('" + ciutat.nomCiutat + "', " + ciutat.prefixTelefonic + ")";
	}

	public static String getSQLUpdate(Ciutat ciutat) {
		return "UPDATE Ciutats SET nomCiutat='" + ciutat.nomCiutat + "', prefixTelefonic=" + ciutat.prefixTelefonic + " WHERE pk_Ciutat_Id = " + ciutat.pk_Ciutat_Id + ";";
	}

	public static String getSQLDelete(int id) {
		return "DELETE FROM Ciutats WHERE pk_Ciutat_Id = " + id + ";";
	}
}
