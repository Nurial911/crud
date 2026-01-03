package com.example.crud.service;

import com.example.crud.repositories.NoteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NoteService {
    private final NoteRepository noteRepository;


}
