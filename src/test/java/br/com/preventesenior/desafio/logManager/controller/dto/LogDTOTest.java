package br.com.preventesenior.desafio.logManager.controller.dto;

import br.com.preventesenior.desafio.logManager.model.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LogDTOTest {

    static List<Log> logs = new ArrayList<>();

    @BeforeAll
    public static void init(){
        logs.add(new Log());
        logs.add(new Log());
        logs.add(new Log());
        logs.add(new Log());
        logs.add(new Log());
    }

    @Test
    void convertList() {
        List<LogDTO> dtos = logs.stream().map(log -> new LogDTO(log)).collect(Collectors.toList());
        assertEquals(dtos.size(), 5);
    }
}