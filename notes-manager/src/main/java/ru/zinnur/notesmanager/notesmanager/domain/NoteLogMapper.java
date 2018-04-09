package ru.zinnur.notesmanager.notesmanager.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class NoteLogMapper implements RowMapper<NoteLog> {

    @Override
    public NoteLog mapRow(ResultSet resultSet, int i) throws SQLException {
        NoteLog noteLog = new NoteLog();
        noteLog.setId(resultSet.getInt("ID"));
        noteLog.setTitle(resultSet.getString("TITLE"));
        noteLog.setBody(resultSet.getString("BODY"));
        noteLog.setFavourite(resultSet.getBoolean("ISFAVOURITE"));
        noteLog.setCreatedAt(resultSet.getObject("CREATED_AT", LocalDateTime.class));
        return noteLog;
    }
}