package com.ota.exam.note.infrastructure.note;

import com.ota.exam.note.core.note.dto.NoteDTO;
import com.ota.exam.note.core.note.dto.NoteRequestDTO;
import com.ota.exam.note.core.note.dto.NoteResponseDTO;
import com.ota.exam.note.core.note.repository.NoteRepository;
import com.ota.exam.note.infrastructure.note.entity.NoteEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DefaultNoteRepository implements NoteRepository {

    private final Map<Long, NoteEntity> notesMap = new HashMap<>();
    private Long id = 1L;

    @Override
    public void saveNewNote(NoteRequestDTO noteRequestDTO) {
        NoteEntity noteEntity = buildNoteEntity(noteRequestDTO);
        notesMap.put(noteEntity.getId(), noteEntity);
    }

    @Override
    public Map<Long, NoteDTO> getAllNotes() {
        Map<Long, NoteDTO> noteDTOMap = new HashMap<>();
        for (Map.Entry<Long, NoteEntity> entry : this.notesMap.entrySet()) {
            NoteEntity noteEntity = entry.getValue();
            NoteDTO noteDTO = buildNoteDTO(noteEntity);
            noteDTOMap.put(noteEntity.getId(), noteDTO);
        }
        return noteDTOMap;
    }

    @Override
    public NoteResponseDTO getNote(Long noteID) {
        NoteEntity noteEntity = notesMap.get(noteID);
        if (noteEntity == null){
            throw new NullPointerException(String.format("No note found with Note ID: %o", noteID));
        }
        return buildNoteResponseDTO(noteEntity);
    }

    @Override
    public void updateNote(Long id, NoteRequestDTO noteRequestDTO) {
        NoteEntity noteEntity = notesMap.get(id);
        if (noteEntity == null){
            throw new NullPointerException(String.format("No note found with Note ID: %o", id));
        }
        noteEntity.setBody(noteRequestDTO.getBody());
        noteEntity.setTitle(noteRequestDTO.getTitle());
    }

    @Override
    public void deleteNote(Long id) {
        log.info("Deleting note with note ID: {}", id);
        notesMap.remove(id);
    }

    private NoteResponseDTO buildNoteResponseDTO(NoteEntity noteEntity) {
        return NoteResponseDTO
                .builder()
                .id(noteEntity.getId())
                .body(noteEntity.getBody())
                .title(noteEntity.getTitle())
                .build();
    }

    private NoteDTO buildNoteDTO(NoteEntity noteEntity) {
        return NoteDTO
                .builder()
                .id(noteEntity.getId())
                .body(noteEntity.getBody())
                .title(noteEntity.getTitle())
                .build();
    }

    private NoteEntity buildNoteEntity(NoteRequestDTO noteRequestDTO) {
        return NoteEntity
                .builder()
                .id(generateId())
                .body(noteRequestDTO.getBody())
                .title(noteRequestDTO.getTitle())
                .build();
    }

    private Long generateId() {
        return id++;
    }
}
