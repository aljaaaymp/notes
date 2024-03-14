package com.ota.exam.note.core.note.service;

import com.ota.exam.note.core.exception.GeneralServiceException;
import com.ota.exam.note.core.note.dto.NoteDTO;
import com.ota.exam.note.core.note.dto.NoteRequestDTO;
import com.ota.exam.note.core.note.dto.NoteResponseDTO;
import com.ota.exam.note.core.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class DefaultNoteService implements NoteService{

    private final NoteRepository  noteRepository;
    @Override
    public void saveNewNote(NoteRequestDTO noteRequestDTO) {
        try {
            log.info("[START] Saving new note");
            noteRepository.saveNewNote(noteRequestDTO);
            log.info("[END] Saved note");
        } catch (Exception exception){
            log.error("[ERROR] Failed to save new note due to: {}", exception.getMessage());
            throw new GeneralServiceException("Failed to save new note");
        }

    }

    @Override
    public Map<Long, NoteDTO> getAllNotes() {
        try {
            log.info("[START] Retrieving all notes");
            Map<Long, NoteDTO> noteDTOMap = noteRepository.getAllNotes();
            log.info("[END] Retrieved notes");
            return noteDTOMap;
        } catch (Exception exception){
            log.error("[ERROR] Failed to retrieve all notes due to: {}", exception.getMessage());
            throw new GeneralServiceException("Failed to retrieve all note");
        }
    }

    @Override
    public NoteResponseDTO getNote(Long noteID) {
        try {
            log.info("[START] Retrieving note by Note ID: {}", noteID);
            NoteResponseDTO noteResponseDTO = noteRepository.getNote(noteID);
            log.info("[END] Retrieved note");
            return noteResponseDTO;
        } catch (Exception exception){
            log.error("[ERROR] Failed to retrieve note due to: {}", exception.getMessage());
            throw new GeneralServiceException("Failed to retrieve note");
        }
    }

    @Override
    public void updateNote(Long noteID, NoteRequestDTO noteRequestDTO) {
        try {
            log.info("[START] Updating note by Note ID: {}", noteID);
            noteRepository.updateNote(noteID, noteRequestDTO);
            log.info("[END] Note updated");
        } catch (Exception exception){
            log.error("[ERROR] Failed to update note due to: {}", exception.getMessage());
            throw new GeneralServiceException("Failed to update note");
        }

    }

    @Override
    public void deleteNote(Long noteID) {
        try {
            log.info("[START] Deleting note by Note ID: {}", noteID);
            noteRepository.deleteNote(noteID);
            log.info("[END] Note deleted");
        } catch (Exception exception){
            log.error("[ERROR] Failed to delete note due to: {}", exception.getMessage());
            throw new GeneralServiceException("Failed to delete note");
        }
    }

}
