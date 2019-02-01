package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.model.FileShare;
import com.epam.jdbcadvanced.repository.FileShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.nio.file.Files;
import java.nio.file.Paths;

@EntityScan("com.epam.jdbcadvanced.model")
@ComponentScan({"com.epam.jdbcadvanced"})
@EnableJpaRepositories("com.epam.jdbcadvanced.repository")
@SpringBootApplication
public class JdbcAdvancedApplication implements CommandLineRunner {

    @Autowired
    FileShareRepository fileShareRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ClassPathResource imgFile = new ClassPathResource("image_input/sonarqube-7.5.zip");
        byte[] arrayPic = new byte[(int) imgFile.contentLength()];
        imgFile.getInputStream().read(arrayPic);
        FileShare gifpic = new FileShare(1, "OUTPUT-LOGO", arrayPic);
        fileShareRepository.save(gifpic);

        for (FileShare fileShare : fileShareRepository.findAll()) {
            Files.write(Paths.get("sonarQube-output.zip"), fileShare.getPic());
        }

    }
}

