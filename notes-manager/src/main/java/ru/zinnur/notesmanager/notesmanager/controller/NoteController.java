package ru.zinnur.notesmanager.notesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.zinnur.notesmanager.notesmanager.domain.Note;
import ru.zinnur.notesmanager.notesmanager.domain.NoteLog;
import ru.zinnur.notesmanager.notesmanager.service.NoteService;

import java.util.List;

@Controller
@RequestMapping(value = "/notes", produces = "application/json;charset=UTF-8")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<NoteLog>> getNotes() {
        List<NoteLog> notes = noteService.getNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping(value = "/{noteId}")
    @ResponseBody
    public ResponseEntity<NoteLog> getNote(@PathVariable Integer noteId) {
        NoteLog note = noteService.getNote(noteId);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Integer noteId = noteService.createNote(note);
        note = noteService.getNote(noteId);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping(value = "/{noteId}")
    @ResponseBody
    public ResponseEntity<Note> updateNote(@PathVariable Integer noteId, @RequestBody Note note) {
        note.setId(noteId);
        noteService.updateNote(note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{noteId}")
    public ResponseEntity<Integer> deleteNote(@PathVariable Integer noteId) {
        noteService.deleteNote(noteId);
        return new ResponseEntity<>(noteId, HttpStatus.OK);
    }


}
