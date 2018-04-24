package klassendiagramm;

public class UserDTO {
	private String name_pflicht;
	private String email_pflicht;
	private String passwort_pflicht;
	private String anschrift;
	private String geburtsdatum;
	private String telefonnummer;
	private String linuxkennung;
	private String art;
	public UserDTO(String name, String email, String pw, String anschrift, String geburtsdatum, String telefonnummer, String linuxkennung, String art){
		this.name_pflicht=name;
		this.email_pflicht=email;
		this.passwort_pflicht=pw;
		this.anschrift=anschrift;
		this.geburtsdatum=geburtsdatum;
		this.telefonnummer=telefonnummer;
		this.linuxkennung=linuxkennung;
		this.art=art;
	}
	public String getName_pflicht() {
		return name_pflicht;
	}
	public String getEmail_pflicht() {
		return email_pflicht;
	}
	public String getPasswort_pflicht() {
		return passwort_pflicht;
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
