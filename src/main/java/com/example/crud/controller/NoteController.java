package com.example.crud.controller;

import com.example.crud.service.NoteService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
@Data
public class NoteController {
    private final NoteService noteService;

}
