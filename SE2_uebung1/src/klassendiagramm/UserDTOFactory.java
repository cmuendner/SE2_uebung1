package klassendiagramm;

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
	public UserDTO createDefaultUser(){
		return new UserDTO(
				"Max Mustermann",
				"mm@gmail.com",
				"passwort101",
				"Prenzlauer Berg 1",
				"01.01.2000",
				"080008150815",
				"mmuste2s",
				"keinStudent");
	}
	public UserDTO createDefaultUserWithNoPassword(){
		return new UserDTO(
				"Max Mustermann",
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
				"mm@gmail.com",
				null,
				"Prenzlauer Berg 1",
				"01.01.2000",
				"080008150815",
				"wasisteinelinuxkennung?",
				"keinStudent");
	}
}
