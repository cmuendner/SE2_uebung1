package registrierungundtests;

public class UserDTO {
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String anschrift;
	private String geburtsdatum;
	private String telefonnummer;
	private String linuxkennung;
	private String art;
	public UserDTO(String vorname, String nachname, String email, String passwort, String anschrift, String geburtsdatum, String telefonnummer, String linuxkennung, String art){
		this.vorname=vorname;
		this.nachname=nachname;
		this.email=email;
		this.passwort=passwort;
		this.anschrift=anschrift;
		this.geburtsdatum=geburtsdatum;
		this.telefonnummer=telefonnummer;
		this.linuxkennung=linuxkennung;
		this.art=art;
	}
	
	//Getters
	public String getVorname() {
		return vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public String getEmail() {
		return email;
	}
	public String getPasswort() {
		return passwort;
	}
	public String getAnschrift() {
		return anschrift;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public String getLinuxkennung() {
		return linuxkennung;
	}
	public String getArt() {
		return art;
	}
	
}
