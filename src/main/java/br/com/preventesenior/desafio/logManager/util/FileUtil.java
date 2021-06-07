package br.com.preventesenior.desafio.logManager.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    List<String> lines = new ArrayList<>();
    public  List<String> readFileLineByLine(MultipartFile file) {
        try {
            if(!file.isEmpty()){
                InputStream inputStream = file.getInputStream();
                new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().forEach(this::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void add(String linha){
        lines.add(linha);
    }

}
