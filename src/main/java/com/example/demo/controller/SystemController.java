package com.example.demo.controller;

import com.example.demo.service.SystemService;
import com.example.demo.service.UserService;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/System")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @PostMapping("/registraSistema")
    public ResponseEntity<?> registraSistema(@RequestBody Sistema sistema){

        SystemService.registraSistema(sistema);

        return (ResponseEntity<?>) ResponseEntity.ok("Sistema registrato!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sistema>> getById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Sistema>>(SystemService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{id")
    public ResponseEntity<?> eliminaSistema(@PathVariable("id") Integer id){

        SystemService.eliminaSistema(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Sistema eliminato!");
    }
}
