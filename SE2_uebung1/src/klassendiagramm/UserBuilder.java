package klassendiagramm;

public class UserBuilder {
	private String name_pflicht;
	private String email_pflicht;
	private String passwort_pflicht;
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
	public UserBuilder create(){
		return this;
	}
	public UserBuilder DefaultUser(){
		this.name_pflicht="Max Mustermann";
		this.email_pflicht="mm@gmail.com";
		this.passwort_pflicht="passwort101";
		this.anschrift="Prenzlauer Berg 1";
		this.geburtsdatum="01.01.2000";
		this.telefonnummer="080008150815";
		this.linuxkennung="mmuste2s";
		this.art="keinStudent";
		return this;
	}
	public UserBuilder but(){
		return this;
	}
	public UserBuilder and(){
		return this;
	}
	
	public UserBuilder WithNoName(){
		this.name_pflicht=null;
		return this;
	}
	public UserBuilder WithNoEmail(){
		this.email_pflicht=null;
		return this;
	}
	public UserBuilder WithNoPassword(){
		this.passwort_pflicht=null;
		return this;
	}
	
	
	
	
	public UserDTO done(){
		return new UserDTO(this.name_pflicht,this.email_pflicht,this.passwort_pflicht,this.anschrift,this.geburtsdatum,this.telefonnummer,this.linuxkennung,this.art);
	}
	public UserDTO thatsall(){
		return new UserDTO(this.name_pflicht,this.email_pflicht,this.passwort_pflicht,this.anschrift,this.geburtsdatum,this.telefonnummer,this.linuxkennung,this.art);
	}
}
