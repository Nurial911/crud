package com.example.crud.controller;

import com.example.crud.dto.CreateNoteRequest;
import com.example.crud.dto.NoteResponse;
import com.example.crud.entities.Note;
import com.example.crud.service.NoteService;
import lombok.Data;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@Data
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/allnotes")
    public Iterable<NoteResponse> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable Long id){
        return noteService.getNoteById(id);
    }
}
