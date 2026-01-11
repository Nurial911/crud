package com.example.crud.dto;

import lombok.Data;

@Data
public class UpdateNoteRequest {
    private String title;
    private String content;
}
