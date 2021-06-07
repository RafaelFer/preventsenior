package br.com.preventesenior.desafio.logManager.repository;

import br.com.preventesenior.desafio.logManager.model.Log;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet resultSet, int i) throws SQLException {
        Log log = new Log();
        log.setId(resultSet.getLong("id"));
        log.setDate(resultSet.getTimestamp("data").toLocalDateTime());
        log.setRequest(resultSet.getString("request"));
        log.setIp(resultSet.getString("ip"));
        log.setStatus(resultSet.getString("status"));
        log.setUserAgent(resultSet.getString("user_agent"));
        return log;
    }
}
