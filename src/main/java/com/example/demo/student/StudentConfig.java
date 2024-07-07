package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student itmam = new Student("Itmam", "itmamkhairi@cybersolution.com.my", LocalDate.of(2024, Month.APRIL, 17));

            repository.save(itmam);
//            repository.saveAll(List.of(itmam));
        };
    }
}
