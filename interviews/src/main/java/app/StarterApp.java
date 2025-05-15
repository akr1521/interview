package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApp implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(StarterApp.class, args);
    }

    @Override
    public void run (String... args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("");
    }



}
