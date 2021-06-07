package br.com.preventesenior.desafio.logManager.service;

import br.com.preventesenior.desafio.logManager.model.Log;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LogService {

    List<Log> findAll();

    Log findById(Long id);

    boolean deleteById(Long id);

    boolean update(Long id, Log log);

    Log create(Log log);




}
