package registrierungundtests;

import static org.junit.Assert.*;

import org.hamcrest.Factory;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
	private UserDTOFactory factory;
	UserDTO dto1;
	UserDTO dto2;
	@Before
	public void setUp() throws Exception {
		factory=UserDTOFactory.getInstance();
		dto1=factory.createDefaultUser();
		dto2=UserBuilder.getInstance().create().DefaultUser().thatsall();
	}
	//Nur für die Übung
	@Test
	public void testFactory() {
		assertTrue(RegistrierenControl.registerUser(dto1).getStatus());
		assertNotNull(RegistrierenControl.registerUser(dto1).getStatus());
		
		dto1=factory.createDefaultUserWithNoPassword();
		assertFalse(RegistrierenControl.registerUser(dto1).getStatus());
		assertNotNull(RegistrierenControl.registerUser(dto1).getStatus());
		
		dto1=factory.createDefaultUserWithNoPasswordAndNoName();
		assertFalse(RegistrierenControl.registerUser(dto1).getStatus());
		assertNotNull(RegistrierenControl.registerUser(dto1).getStatus());
	}
	
	//hier starten die richtigen tests mit Builder
	@Test
	public void testRegistrierung() {
		//Default User - Alle Angaben richtig
			dto2=UserBuilder.getInstance().create().DefaultUser().thatsall();
			RegistrationResult regresult=new RegistrationResult(true);
			regresult.addMessage("Sie wurden erfolgreich registriert!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		
		//Name nicht null
		//Vorname nicht null
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoFirstName().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Nachname nicht null
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoLastName().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Name nicht null
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoFirstName().and().WithNoLastName().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		
		//Email konform
		//Email nicht null
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoEmail().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Email ohne @
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidEmailMissingat().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Email Falsches Ende
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidEmailWrongEnd().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Email Ohne Anfang
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidEmailMissingStart().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		
		//Passwort konform
		//Passwort nicht null
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoPassword().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Passwort invalid wegen Länge
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidPasswortLength().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Passwort invalid wegen fehldender Sonderzeichen
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidPasswortKeinSonderzeichen().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Passwort invalid aus mehreren Gründen
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidPasswort().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
			
		//Kombinationen von Fehlern
		//Vorname nicht null und Email invalid
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoFirstName().and().WithInvalidEmailMissingat().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Vorname nicht null und Passwort invalid
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoFirstName().and().WithInvalidPasswortKeinSonderzeichen().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Vorname nicht null, Email invalid und Passwort invalid
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoFirstName().and().and().WithInvalidEmailWrongEnd().WithInvalidPasswortKeinSonderzeichen().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Bitte geben Sie einen Namen ein!");
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
		//Email invalid und Passwort invalid
			dto2=UserBuilder.getInstance().create().DefaultUser().but().WithInvalidEmailMissingStart().and().WithInvalidPasswortLength().thatsall();
			regresult=new RegistrationResult(false);
			regresult.addMessage("Die angegebene Email Adresse is inkorrekt.");
			regresult.addMessage("Bitte wählen Sie ein sicheres Passwort!");
			assertEquals(RegistrierenControl.registerUser(dto2),regresult);
	}

}
