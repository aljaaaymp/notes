package com.ota.exam.note.core.note.service;

import com.ota.exam.note.core.note.dto.NoteDTO;
import com.ota.exam.note.core.note.dto.NoteRequestDTO;
import com.ota.exam.note.core.note.dto.NoteResponseDTO;

import java.util.Map;

public interface NoteService {
    void saveNewNote(NoteRequestDTO noteRequestDTO);

    Map<Long, NoteDTO> getAllNotes();

    NoteResponseDTO getNote(Long noteID);

    void updateNote(Long noteID, NoteRequestDTO noteRequestDTO);

    void deleteNote(Long noteID);

}
