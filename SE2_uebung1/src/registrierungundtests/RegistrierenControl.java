package registrierungundtests;

public class RegistrierenControl {
	//beim registrieren viele möglichkeiten von fehlern
//	bsp Userfactory.createDefaultUserWithNoPassword...   zum erstellen eines zu testenden falles  -> problem habe mega vile funktionen in factory
//	-> builder pattern
//	UserDTO dto=UserBuilder().getInstance().createDefaultUser().done();
//	dto = UserBuilder().getInstance().createDefaultUser().but().withNoPassword().and().withNoName().done();
	
	public static RegistrationResult registerUser(UserDTO u){
		if(checkUserDTO(u)){
			speichere(u);
			return new RegistrationResult(true);
		}else{			
			return new RegistrationResult(false);
		}
	}
	private static boolean checkUserDTO(UserDTO u){
		if(u.getEmail_pflicht()!=null&u.getName_pflicht()!=null&u.getPasswort_pflicht()!=null){
			//Check später mit regex etc.
			return true;
		}else{
			return false;
		}
	}
	private static void speichere(UserDTO u){
		
	}
}
