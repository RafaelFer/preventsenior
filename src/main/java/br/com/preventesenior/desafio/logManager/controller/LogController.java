package br.com.preventesenior.desafio.logManager.controller;

import br.com.preventesenior.desafio.logManager.controller.dto.LogDTO;
import br.com.preventesenior.desafio.logManager.controller.form.LogForm;
import br.com.preventesenior.desafio.logManager.model.Log;
import br.com.preventesenior.desafio.logManager.service.LogService;
import br.com.preventesenior.desafio.logManager.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/")
    @Cacheable(value = "allLogs")
    public ResponseEntity findAll(){
        List<Log> all = logService.findAll();
        if(all != null){
            LogDTO dto = new LogDTO();
            return ResponseEntity.ok(dto.convertList(all));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Log log = logService.findById(id);
        if(log != null){
            return ResponseEntity.ok(new LogDTO(log));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "allLogs", allEntries = true)
    public ResponseEntity deleteById(@PathVariable Long id){
        if(logService.deleteById(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "allLogs", allEntries = true)
    public ResponseEntity update(@RequestBody @Valid LogForm logForm, @PathVariable Long id){
        if(logService.update(id, logForm.convertToLog())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @CacheEvict(value = "allLogs", allEntries = true)
    public ResponseEntity create(@RequestBody @Valid LogForm logForm){
        Log log = logService.create(logForm.convertToLog());
        return ResponseEntity.status(201).body(new LogDTO(log));
    }

    @PostMapping("/upload")
    @CacheEvict(value = "allLogs", allEntries = true)
    public ResponseEntity upload(@RequestParam("file") MultipartFile file ){
        List<Log> logs = readFileLineByLine(file, new LogForm());
        logs.forEach( l -> logService.create(l));
        return ResponseEntity.status(201).build();
    }

    private List<Log> readFileLineByLine(MultipartFile file, LogForm logForm) {
        List<Log> convertidos = new ArrayList<>();
            if(!file.isEmpty()){
                List<String> strings = new FileUtil().readFileLineByLine(file);
                strings.forEach(f -> {
                    try {
                        convertidos.add(logForm.convertStringToLog(f));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                });
            }
        return  convertidos;
    }

}
