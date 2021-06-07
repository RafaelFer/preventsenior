package br.com.preventesenior.desafio.logManager.service.impl;

import br.com.preventesenior.desafio.logManager.model.Log;
import br.com.preventesenior.desafio.logManager.repository.LogRepository;
import br.com.preventesenior.desafio.logManager.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository logRepository;

    @Override
    public List<Log> findAll() {
        List<Log> all = logRepository.findAll();
        return all;
    }

    @Override
    public Log findById(Long id) {
        Log log = logRepository.findById(id);
        return log;
    }

    @Override
    public boolean deleteById(Long id) {
        return logRepository.deleteById(id);
    }

    @Override
    public boolean update(Long id, Log log) {
        Log byId = logRepository.findById(id);

        if(byId != null){
            log.setId(id);
            return logRepository.update(log);
        }
        return false;
    }

    @Override
    public Log create(Log log) {
        return logRepository.create(log);
    }
}
