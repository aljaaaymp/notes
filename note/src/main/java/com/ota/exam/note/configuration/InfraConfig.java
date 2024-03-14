package com.ota.exam.note.configuration;

import com.ota.exam.note.core.note.repository.NoteRepository;
import com.ota.exam.note.infrastructure.note.DefaultNoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfig {

    @Bean
    NoteRepository noteRepository(){
        return new DefaultNoteRepository();
    }
}
