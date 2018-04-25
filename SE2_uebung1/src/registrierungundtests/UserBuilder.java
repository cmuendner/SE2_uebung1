package registrierungundtests;

public class UserBuilder {
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String anschrift;
	private String geburtsdatum;
	private String telefonnummer;
	private String linuxkennung;
	private String art;
	
	private UserBuilder(){
		
	}
	public static UserBuilder getInstance(){
		return new UserBuilder();
	}
	public UserBuilder DefaultUser(){
		this.vorname="Max";
		this.nachname="Mustermann";
		this.email="mm@gmail.com";
		this.passwort="!Passwort1";
		this.anschrift="Prenzlauer Berg 1";
		this.geburtsdatum="01.01.2000";
		this.telefonnummer="080008150815";
		this.linuxkennung="mmuste2s";
		this.art="keinStudent";
		return this;
	}
	
	
	//Methoden zum testen
	public UserBuilder create(){
		return this;
	}
	
	public UserBuilder but(){
		return this;
	}
	public UserBuilder and(){
		return this;
	}
	
	//WithNo
	public UserBuilder WithNoEmail(){
		this.email=null;
		return this;
	}
	public UserBuilder WithNoPassword(){
		this.passwort=null;
		return this;
	}
	public UserBuilder WithNoFirstName(){
		this.vorname=null;
		return this;
	}
	public UserBuilder WithNoLastName(){
		this.nachname=null;
		return this;
	}
	
	//Invalid Entry
	public UserBuilder WithInvalidFirstName(){
		this.vorname="max";
		return this;
	}
	public UserBuilder WithInvalidLastName(){
		this.vorname="max";
		return this;
	}
	public UserBuilder WithInvalidEmailMissingat(){
		this.email="peteratgmail.com";
		return this;
	}
	public UserBuilder WithInvalidEmailWrongEnd(){
		this.email="peter@gmailcom";
		return this;
	}
	public UserBuilder WithInvalidEmailMissingStart(){
		this.email="@gmailcom";
		return this;
	}
	public UserBuilder WithInvalidPasswort(){
		this.passwort="passwort";
		return this;
	}
	public UserBuilder WithInvalidPasswortLength(){
		this.passwort="!Past1";
		return this;
	}
	public UserBuilder WithInvalidPasswortKeinSonderzeichen(){
		this.passwort="Passwort1";
		return this;
	}
	
	public UserDTO done(){
		return new UserDTO(this.vorname, this.nachname,this.email,this.passwort,this.anschrift,this.geburtsdatum,this.telefonnummer,this.linuxkennung,this.art);
	}
	public UserDTO thatsall(){
		return new UserDTO(this.vorname, this.nachname,this.email,this.passwort,this.anschrift,this.geburtsdatum,this.telefonnummer,this.linuxkennung,this.art);
	}
}
