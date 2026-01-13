package com.example.crud;

import com.example.crud.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.webmvc.autoconfigure.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class CrudApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CrudApplication.class, args);
        var service = context.getBean(NoteService.class);
    }

}
