/**
 *@author nweige2s 
 */

package registrierungundtests;

public class UserDTOFactory {
	private static UserDTOFactory instance;
	private UserDTOFactory(){
		
	}
	public static UserDTOFactory getInstance(){
		if(instance==null){
			instance=new UserDTOFactory();
		}
		return instance;
	}
	//Constructor for creating UserDTO Objects
	public UserDTO createUserDTO(String vorname, String nachname,String email, String passwort, String anschrift,
			String geburtsdatum, String telefonnummer, String linuxkennung, String art){
		return new UserDTO(vorname, nachname, email, passwort, anschrift, geburtsdatum, telefonnummer, linuxkennung, art);
	}
	
	//Constructor for test - UserDTO Objects
	public UserDTO createDefaultUser(){
		return new UserDTO(
				"Max",
				"Mustermann",
				"mm@gmail.com",
				"!Passwort1",
				"Prenzlauer Berg 1",
				"01.01.2000",
				"080008150815",
				"mmuste2s",
				"keinStudent");
	}
	public UserDTO createDefaultUserWithNoPassword(){
		return new UserDTO(
				"Max",
				"Mustermann",
				"mm@gmail.com",
				null,
				"Prenzlauer Berg 1",
				"01.01.2000",
				"080008150815",
				"wasisteinelinuxkennung?",
				"keinStudent");
	}
	public UserDTO createDefaultUserWithNoPasswordAndNoName(){
		return new UserDTO(
				null,
				"Mustermann",
				"mm@gmail.com",
				null,
				"Prenzlauer Berg 1",
				"01.01.2000",
				"080008150815",
				"wasisteinelinuxkennung?",
				"keinStudent");
	}
}
