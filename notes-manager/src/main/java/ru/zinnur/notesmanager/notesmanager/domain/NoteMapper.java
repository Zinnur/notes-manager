package ru.zinnur.notesmanager.notesmanager.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteMapper implements RowMapper<Note> {

    @Override
    public Note mapRow(ResultSet resultSet, int i) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getInt("ID"));
        note.setTitle(resultSet.getString("TITLE"));
        note.setBody(resultSet.getString("BODY"));
        note.setFavourite(resultSet.getBoolean("ISFAVOURITE"));
        return note;
    }
}