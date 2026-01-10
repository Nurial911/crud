package com.example.crud.service;

import com.example.crud.dto.NoteResponse;
import com.example.crud.entities.Note;
import com.example.crud.mappers.NoteMapper;
import com.example.crud.repositories.NoteRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Data
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public Iterable<NoteResponse> getAllNotes(){
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::toResponse)
                .toList();
    }

    public ResponseEntity<NoteResponse> getNoteById(Long id){
        var note = noteRepository.findById(id).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(noteMapper.toResponse(note));
    }



}
