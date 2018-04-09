package ru.zinnur.notesmanager.notesmanager.domain;


import java.time.LocalDateTime;

public class NoteLog extends Note {
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
