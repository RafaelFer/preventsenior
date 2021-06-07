package br.com.preventesenior.desafio.logManager.controller.form;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


class LogFormTest {

    @Test
    void convertStringToLog() {
        String line = "2021-01-01 23:59:59.608|192.168.122.135|\"GET / HTTP/1.1\"|200|\"Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0";
        String[] split = line.split("\\|");
        assertEquals(split.length, 5);
        assertEquals(split[0], "2021-01-01 23:59:59.608");
        assertEquals(split[1], "192.168.122.135");
        assertEquals(split[2].replace("\"",""), "GET / HTTP/1.1");
        assertEquals(split[3].replace("\"",""), "200");
        assertEquals(split[4].replace("\"",""), "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");
    }

    @Test
    void convertStringToLogLineNUll() {

        String line = null;
        if(line != null){
            String[] split = line.split("\\|");
            assertEquals(split.length, 5);
            assertEquals(split[0], "2021-01-01 23:59:59.608");
            assertEquals(split[1], "192.168.122.135");
            assertEquals(split[2].replace("\"",""), "GET / HTTP/1.1");
            assertEquals(split[3].replace("\"",""), "200");
            assertEquals(split[4].replace("\"",""), "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");
        }
        assertTrue(line == null);
    }

    @Test
    void convertStringToLogLineIsEmpty() {
        String line = "";
        if(!line.isEmpty()){
            String[] split = line.split("\\|");
            assertEquals(split.length, 5);
            assertEquals(split[0], "2021-01-01 23:59:59.608");
            assertEquals(split[1], "192.168.122.135");
            assertEquals(split[2].replace("\"",""), "GET / HTTP/1.1");
            assertEquals(split[3].replace("\"",""), "200");
            assertEquals(split[4].replace("\"",""), "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");
        }
        assertTrue(line.isEmpty());
    }

    @Test
    void convertStringToLocalDateTime(){
        String str = "2021-01-01 23:59:59.608";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        assertEquals(dateTime.getDayOfMonth(),01);

    }
}