package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registraUtente")
    public ResponseEntity<?> registraUtente(@RequestBody Utente utente){

        userService.registraUtente(utente);

        return (ResponseEntity<?>) ResponseEntity.ok("Utente registrato!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Utente>> getUserById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Utente>>(userService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{id")
    public ResponseEntity<?> eliminaUtente(@PathVariable("id") Integer id){

        userService.eliminaUtente(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Utente eliminato!");
    }
}
