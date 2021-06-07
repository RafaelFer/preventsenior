package br.com.preventesenior.desafio.logManager.repository;

import br.com.preventesenior.desafio.logManager.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Repository
public class LogRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Log> findAll(){
        try{
            String sql = "select * from log";
            return jdbcTemplate.query(sql, new LogRowMapper());
        }catch (EmptyResultDataAccessException e){
            System.out.println("Log não encontrado!");
            return  null;
        }
    }

    @Transactional(readOnly = true)
    public Log findById(Long id) {
        try{
            String sql = "select * from log where id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new LogRowMapper());
        }catch (EmptyResultDataAccessException e){
            System.out.println("Log não encontrado!");
            return  null;
        }
    }

    @Transactional
    public boolean deleteById(Long id){
        String sql = "delete from log where id = ?";
        return jdbcTemplate.update(sql, new Object[]{id}) == 1;
    }

    @Transactional
    public boolean update(Log log) {
        StringBuilder builder = new StringBuilder("UPDATE LOG SET DATA = ?");
        builder.append(",REQUEST = ?");
        builder.append(",IP = ?");
        builder.append(",STATUS = ?");
        builder.append(",USER_AGENT = ?");
        builder.append(" WHERE ID = ?");
        return jdbcTemplate.update(builder.toString(), log.getDate(), log.getRequest(), log.getIp(), log.getStatus(), log.getUserAgent(), log.getId()) == 1;
    }

    @Transactional
    public Log create(Log log) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into log(DATA, REQUEST, IP,STATUS,USER_AGENT) values(?,?,?,?,?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, log.getDate());
                ps.setString(2, log.getRequest());
                ps.setString(3, log.getIp());
                ps.setString(4, log.getStatus());
                ps.setString(5, log.getUserAgent());
                return ps;
            }
        }, keyHolder);
        Integer id = keyHolder.getKey().intValue();
        log.setId(id.longValue());
        return log;
    }
}
