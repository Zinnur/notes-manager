package ru.zinnur.notesmanager.notesmanager.service;

import ru.zinnur.notesmanager.notesmanager.domain.Note;
import ru.zinnur.notesmanager.notesmanager.domain.NoteLog;

import java.util.List;


public interface NoteService {

    /**
     * Получение списка заметок
     *
     * @return список заметок
     */
    List<NoteLog> getNotes();

    /**
     * Получение заметки по идентификатору
     *
     * @return заметку
     */
    NoteLog getNote(Integer noteId);

    /**
     * Создание заметки
     *
     * @param note параметры заметки
     * @return идентификатор созданной заметки
     */
    Integer createNote(Note note);

    /**
     * Обновление параметров заметки
     *
     * @param note параметры заметки
     */
    void updateNote(Note note);

    /**
     * Удаление заметки
     *
     * @param noteId идентификатор заметки
     */
    void deleteNote(Integer noteId);

}
