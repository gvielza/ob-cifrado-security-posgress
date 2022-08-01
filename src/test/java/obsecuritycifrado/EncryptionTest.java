package obsecuritycifrado;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class EncryptionTest {
	/*
	 * Bcrypt genera su propio salt de 16 bits que se le añade al texto codificado
	 * el resultado de usar bcrypt será un string de 60 caracteres
	 -la version2a y fuerza, x defecto 10
	 */

	@Test
	void bcryptTest() {	
	BCryptPasswordEncoder passencoder = new BCryptPasswordEncoder();
	String hashedPassword = passencoder.encode("admin");
	System.out.println(hashedPassword);
	Boolean matches=passencoder.matches("admin", hashedPassword);
	System.out.println(matches);
	}
	
	@Test
	void bcryptList() {
		for (int i = 0; i < 30; i++) {
			System.out.println(new BCryptPasswordEncoder().encode("admin"));
		}
	}
	//ahora con pbk
	@Test
	void Pbkdf2() {
		System.out.println("*********pbkdf2**********");
		for (int i = 0; i < 30; i++) {
			System.out.println(new Pbkdf2PasswordEncoder().encode("admin"));
		}
	}
	//scrypt
	@Test
	void SCrypt() {
		System.out.println("---------scrypt-----------");
		for (int i = 0; i < 30; i++) {
			System.out.println(new SCryptPasswordEncoder().encode("admin"));
		}
		System.out.println("---------scrypt-----------");
	}
	
	
	
	
	
	
	
	
	
}
