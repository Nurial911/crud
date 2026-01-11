package com.example.crud.mappers;

import com.example.crud.dto.CreateNoteRequest;
import com.example.crud.dto.NoteDto;
import com.example.crud.dto.UpdateNoteRequest;
import com.example.crud.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto toDto(Note note);

    @Mapping(target = "id", ignore = true) // id is generated
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Note toNoteEntity(CreateNoteRequest createNoteRequest);

    void update(UpdateNoteRequest request, @MappingTarget Note note);
}
