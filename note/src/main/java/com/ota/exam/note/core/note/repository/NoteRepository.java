package com.ota.exam.note.core.note.repository;

import com.ota.exam.note.core.note.dto.NoteDTO;
import com.ota.exam.note.core.note.dto.NoteRequestDTO;
import com.ota.exam.note.core.note.dto.NoteResponseDTO;

import java.util.Map;

public interface NoteRepository {
    void saveNewNote(NoteRequestDTO noteRequestDTO);

    Map<Long, NoteDTO> getAllNotes();

    NoteResponseDTO getNote(Long noteID);

    void updateNote(Long id, NoteRequestDTO noteRequestDTO);

    void deleteNote(Long id);
}
