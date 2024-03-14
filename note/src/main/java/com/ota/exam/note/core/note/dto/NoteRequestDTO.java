package com.ota.exam.note.core.note.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Title is required")
    private String body;
}
