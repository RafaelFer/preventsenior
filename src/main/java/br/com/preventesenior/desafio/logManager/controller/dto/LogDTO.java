package br.com.preventesenior.desafio.logManager.controller.dto;

import br.com.preventesenior.desafio.logManager.model.Log;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LogDTO {

    private Long id;
    private LocalDateTime date;
    private String ip;
    private String request;
    private String userAgent;
    private String status;

    public LogDTO() {
    }

    public LogDTO(Log log) {
        this.id = log.getId();
        this.date = log.getDate();
        this.request = log.getRequest();
        this.ip = log.getIp();
        this.status = log.getStatus();
        this.userAgent = log.getUserAgent();
    }

    public List<LogDTO> convertList(List<Log> logs){
        List<LogDTO> dtos = logs.stream().map(log -> new LogDTO(log)).collect(Collectors.toList());
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


}
