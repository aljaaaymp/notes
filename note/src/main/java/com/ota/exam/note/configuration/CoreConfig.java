package com.ota.exam.note.configuration;

import com.ota.exam.note.core.note.repository.NoteRepository;
import com.ota.exam.note.core.note.service.DefaultNoteService;
import com.ota.exam.note.core.note.service.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    NoteService noteService(NoteRepository noteRepository){
        return new DefaultNoteService(noteRepository);
    }
}
