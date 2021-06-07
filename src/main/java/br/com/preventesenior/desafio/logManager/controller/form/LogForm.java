package br.com.preventesenior.desafio.logManager.controller.form;

import br.com.preventesenior.desafio.logManager.model.Log;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;

public class LogForm {

    @NotNull
    private LocalDateTime date;
    @NotNull @NotEmpty
    private String ip;
    @NotNull @NotEmpty
    private String request;
    @NotNull @NotEmpty
    private String userAgent;
    @NotNull @NotEmpty
    private String status;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Log convertToLog() {
        Log log = new Log();
        log.setId(null);
        log.setRequest(this.request);
        log.setDate(this.date);
        log.setUserAgent(this.userAgent);
        log.setStatus(this.status);
        log.setIp(this.ip);
        return log;
    }

    public Log convertStringToLog(String line) throws Exception {
        if(!line.isEmpty()){
            String[] split = line.split("\\|");
            Log log = new Log();
            log.setDate(convertStringToLocalDateTime(split[0]));
            log.setIp(split[1]);
            log.setRequest(split[2].replace("\"",""));
            log.setStatus(split[3].replace("\"",""));
            log.setUserAgent(split[4].replace("\"",""));
            return log;
        }else{
            throw new Exception("Error in line!");
        }
    }

    static LocalDateTime convertStringToLocalDateTime(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(stringDate, formatter);
        return dateTime;
    }

}
