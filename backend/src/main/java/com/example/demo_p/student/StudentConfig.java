package com.example.demo_p.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository  repository){
        return args ->{
            Student mariam  = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)

            );
            Student alex  = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)
            );
            Student elvis = new Student(
                    "Elvis",
                    "elvisk@gmail.com",
                    LocalDate.of(2005,Month.SEPTEMBER,28)

            );
            repository.saveAll(
                    List.of(mariam,alex,elvis)
            );
        };
    }

}
