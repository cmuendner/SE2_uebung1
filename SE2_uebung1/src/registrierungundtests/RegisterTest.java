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

	@Test
	public void testFactory() {
		assertTrue(RegistrierenControl.registerUser(dto1).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto1).getBool());
		
		dto1=factory.createDefaultUserWithNoPassword();
		assertFalse(RegistrierenControl.registerUser(dto1).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto1).getBool());
		
		dto1=factory.createDefaultUserWithNoPasswordAndNoName();
		assertFalse(RegistrierenControl.registerUser(dto1).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto1).getBool());
	}
	
	@Test
	public void testBuilder() {
		assertTrue(RegistrierenControl.registerUser(dto2).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto2).getBool());
		
		dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoEmail().thatsall();
		assertFalse(RegistrierenControl.registerUser(dto2).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto2).getBool());
		
		dto2=UserBuilder.getInstance().create().DefaultUser().but().WithNoEmail().and().WithNoName().thatsall();
		assertFalse(RegistrierenControl.registerUser(dto2).getBool());
		assertNotNull(RegistrierenControl.registerUser(dto2).getBool());
	}

}
