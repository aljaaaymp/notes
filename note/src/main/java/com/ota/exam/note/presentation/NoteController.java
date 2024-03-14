package com.ota.exam.note.presentation;

import com.ota.exam.note.core.note.dto.NoteDTO;
import com.ota.exam.note.core.note.dto.NoteRequestDTO;
import com.ota.exam.note.core.note.dto.NoteResponseDTO;
import com.ota.exam.note.core.note.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@Slf4j
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewNote(@Valid @RequestBody NoteRequestDTO noteRequestDTO){
        log.info("[START] Saving new note");
        noteService.saveNewNote(noteRequestDTO);
        return ResponseEntity.ok("Notes saved");
    }

    @GetMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, NoteDTO> getAllNotes(){
        log.info("[START] Retrieving all notes");
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/notes/{noteID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponseDTO getNote(@PathVariable Long noteID){
        log.info("[START] Retrieving note");
        return noteService.getNote(noteID);
    }

    @PutMapping(value = "/notes/{noteID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateNote(@Valid @PathVariable Long noteID, @RequestBody NoteRequestDTO noteRequestDTO){
        log.info("[START] Updating note");
        noteService.updateNote(noteID, noteRequestDTO);
        return ResponseEntity.ok("Note updated");
    }

    @DeleteMapping(value = "/notes/{noteID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteNote(@PathVariable Long noteID){
        log.info("[START] Deleting note");
        noteService.deleteNote(noteID);
        return ResponseEntity.ok("Note deleted");
    }

}
