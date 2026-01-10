package com.example.crud.dto;

import lombok.Data;

@Data
public class CreateNoteRequest {
    private String title;
    private String content;
}
