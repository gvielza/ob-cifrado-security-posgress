package obsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSecurityCifradoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(ObSecurityCifradoApplication.class, args);
		UserRepo repo= context.getBean(UserRepo.class);
		PasswordEncoder encoder=context.getBean(PasswordEncoder.class);
		User usuario=new User(null,encoder.encode("geo"),"admin");
		repo.save(usuario);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
