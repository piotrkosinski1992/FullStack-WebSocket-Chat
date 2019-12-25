package chat;

import chat.app.gateways.UserRepository;
import chat.app.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder encoder;

  public Application(UserRepository userRepository, PasswordEncoder encoder) {
    this.userRepository = userRepository;
      this.encoder = encoder;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... strings) {
      userRepository.save(new User("a@a.pl", encoder.encode("a"), "yngwie1992"));
      userRepository.save(new User("b@b.pl", encoder.encode("b"), "bonie69"));
  }
}
