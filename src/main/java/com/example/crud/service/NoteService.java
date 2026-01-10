package com.example.crud.service;

import com.example.crud.dto.CreateNoteRequest;
import com.example.crud.dto.NoteDto;
import com.example.crud.dto.UpdateNoteRequest;
import com.example.crud.mappers.NoteMapper;
import com.example.crud.repositories.NoteRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
@Data
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public Iterable<NoteDto> getAllNotes(){
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::toDto)
                .toList();
    }

    public ResponseEntity<NoteDto> getNoteById(Long id){
        var note = noteRepository.findById(id).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(noteMapper.toDto(note));
    }

    public NoteDto createNote(CreateNoteRequest request){
        var saved = noteRepository.save(noteMapper.toNoteEntity(request));
        return noteMapper.toDto(saved);
    }

    public ResponseEntity<NoteDto> updateNote(UpdateNoteRequest request, Long id){
        var note =  noteRepository.findById(id).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        noteMapper.update(request,note);
        noteRepository.save(note);
        return ResponseEntity.ok(noteMapper.toDto(note));
    }

    public ResponseEntity<Void> deleteNote(Long id){
        var note =  noteRepository.findById(id).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        noteRepository.delete(note);
        return ResponseEntity.noContent().build();
    }


}
