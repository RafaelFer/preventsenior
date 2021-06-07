package br.com.preventesenior.desafio.logManager.model;

import java.time.LocalDateTime;

public class Log {

    private Long id;
    private LocalDateTime date;
    private String request;
    private String ip;
    private String status;
    private String userAgent;

    public Log() {
    }

    public Log(Long id, LocalDateTime date, String request, String ip, String status, String userAgent) {
        this.id = id;
        this.date = date;
        this.request = request;
        this.ip = ip;
        this.status = status;
        this.userAgent = userAgent;
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
