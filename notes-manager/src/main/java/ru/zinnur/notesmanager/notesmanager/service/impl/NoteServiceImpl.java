package ru.zinnur.notesmanager.notesmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zinnur.notesmanager.notesmanager.dao.NoteDao;
import ru.zinnur.notesmanager.notesmanager.domain.Note;
import ru.zinnur.notesmanager.notesmanager.domain.NoteLog;
import ru.zinnur.notesmanager.notesmanager.service.NoteService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public List<NoteLog> getNotes() {
        return noteDao.getNotes();
    }

    @Override
    public NoteLog getNote(Integer noteId) {
        return noteDao.getNote(noteId);
    }

    @Override
    @Transactional
    public Integer createNote(Note note) {
        return noteDao.createNote(note);
    }

    @Override
    @Transactional
    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    @Override
    @Transactional
    public void deleteNote(Integer noteId) {
        noteDao.deleteNote(noteId);
    }
}
