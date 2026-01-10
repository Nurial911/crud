package com.example.crud.controller;

import com.example.crud.dto.CreateNoteRequest;
import com.example.crud.dto.NoteDto;
import com.example.crud.dto.UpdateNoteRequest;
import com.example.crud.service.NoteService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/notes")
@Data
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/allnotes")
    public Iterable<NoteDto> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id){
        return noteService.getNoteById(id);
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@RequestBody CreateNoteRequest createNoteRequest, UriComponentsBuilder uriBuilder){
        var created = noteService.createNote(createNoteRequest);
        var uri = uriBuilder.path("/api/notes/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDto> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest, @PathVariable Long id){
        return noteService.updateNote(updateNoteRequest,id);
    }
}
