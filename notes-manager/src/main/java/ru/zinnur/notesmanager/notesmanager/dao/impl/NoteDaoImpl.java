package ru.zinnur.notesmanager.notesmanager.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zinnur.notesmanager.notesmanager.dao.NoteDao;
import ru.zinnur.notesmanager.notesmanager.domain.Note;
import ru.zinnur.notesmanager.notesmanager.domain.NoteLog;
import ru.zinnur.notesmanager.notesmanager.domain.NoteLogMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Repository
public class NoteDaoImpl implements NoteDao {

    private final static String SQL_SELECT_NOTE = "SELECT ID, TITLE, BODY, IS_FAVOURITE, CREATED_AT FROM app.notes " +
            "WHERE id = :id;";

    private final static String SQL_SELECT_ALL_NOTES = "SELECT ID, TITLE, BODY, IS_FAVOURITE, CREATED_AT   FROM app.notes ORDER BY id ASC";

    private final static String SQL_CREATE_NOTE = "INSERT INTO " +
            "app.notes(title, body, is_favourite, created_at) VALUES (:title, :body, :isFavourite, now())";

    private final static String SQL_UPDATE_NOTE = "UPDATE app.notes " +
            "SET title = :title, body = :body, is_favourite = :isFavourite WHERE id = :id";

    private final static String SQL_DELETE_NOTE = "DELETE FROM app.notes WHERE id = :id";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<NoteLog> getNotes() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_NOTES, new NoteLogMapper());
    }

    @Override
    public NoteLog getNote(Integer noteId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", noteId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_NOTE, paramMap, new NoteLogMapper());
    }

    @Override
    public Integer createNote(Note note) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("title", note.getTitle());
        namedParameters.addValue("body", note.getBody());
        namedParameters.addValue("isFavourite", note.getFavourite());
        namedParameterJdbcTemplate.update(SQL_CREATE_NOTE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    public void updateNote(Note note) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", note.getId());
        params.put("title", note.getTitle());
        params.put("body", note.getBody());
        params.put("isFavourite", note.getFavourite());
        namedParameterJdbcTemplate.update(SQL_UPDATE_NOTE, params);
    }

    @Override
    @Transactional
    public void deleteNote(Integer noteId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", noteId);
        namedParameterJdbcTemplate.update(SQL_DELETE_NOTE, params);
    }
}
