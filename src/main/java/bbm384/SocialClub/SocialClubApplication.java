package bbm384.SocialClub;

import bbm384.SocialClub.util.DatabasePopulator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SocialClubApplication {

	private final DatabasePopulator databasePopulator;

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(SocialClubApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase(){
		databasePopulator.populateDatabase();
	}
}
