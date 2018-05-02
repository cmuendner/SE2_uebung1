/**
 *@author nweige2s 
 */

package registrierungundtests;
import java.util.regex.*;
public class RegistrierenControl {
	//To-Do was wenn Passwort zu lang? Namen am Anfang gro�? Sonderzeichen in Namen etc.
	//Linuxkennung auch checken?
	//Datum muss sp�ter als Datum in Datenbank-----Check und konvertierung wichtig! Oder
	//aus html als Datum rauslesen etc?
	
	public static RegistrationResult registerUser(UserDTO userdto){
		RegistrationResult regresult=checkUserDTO(userdto);
		//Check Status von regresult
		if(!regresult.getStatus()){
			//Abbruch
			return regresult;
		}
		//folgende Funktionalit�ten/Prozesse
		speichere(userdto);
		
		regresult.addMessage("Sie wurden erfolgreich registriert!");
		return regresult;
	}
	private static RegistrationResult checkUserDTO(UserDTO u){
		RegistrationResult regresult=new RegistrationResult(true);
		
		//checke die einzelnen Fehlerf�lle
		//Vorname und Nachname
		if(!checkName(u.getVorname())||!checkName(u.getNachname())){
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			regresult.setStatus(false);
		}
		//Email
		if(!checkEmail(u.getEmail())){
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			regresult.setStatus(false);
		}
		//Passwort
		if(!checkPasswort(u.getPasswort())){
			regresult.addMessage("Bitte w�hlen Sie ein sicheres Passwort!");
			regresult.setStatus(false);
		}
		
		return regresult;
	}
	
	
	//Methoden f�r Checks
	private static boolean checkName(String name){
		if(name==null){return false;}
		return true;
	}
	private static boolean checkEmail(String email){
		if(email==null){return false;}
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
	}
	private static boolean checkPasswort(String passwort){
		//Passwort darf nicht leer sein und muss mindestens:
		//einen Gro�buchstaben
		//einen kleinbuchstaben
		//eine Ziffer
		//und ein Sonderzeichen enthalten und insgesamt mindestens
		//8 Characters lang sein
		if(passwort==null){return false;}
		Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        Matcher mat = pattern.matcher(passwort);
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
	}
	
	
	//Abspeichern/Weitere Prozesse
	private static void speichere(UserDTO u){
		
	}
}
