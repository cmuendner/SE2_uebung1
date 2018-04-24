package registrierungundtests;
import java.util.regex.*;
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
//			System.out.println(checkEmail(u.getEmail_pflicht()));
//			System.out.println(u.getEmail_pflicht());
			return checkEmail(u.getEmail_pflicht())&&true;
		}else{
			return false;
		}
	}
	private static boolean checkEmail(String email){
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
	}
	private static void speichere(UserDTO u){
		
	}
}
