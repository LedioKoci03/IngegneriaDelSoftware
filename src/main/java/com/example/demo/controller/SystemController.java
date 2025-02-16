package com.example.demo.controller;

import com.example.demo.service.SystemService;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/System")
public class SystemController {

    @Autowired
    public final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @PostMapping("/registraSistema")
    public ResponseEntity<?> registraSistema(@RequestBody Sistema s){

        systemService.registraSistema(s);

        return (ResponseEntity<?>) ResponseEntity.ok("Sistema registrato!");

    }

    @GetMapping("/selezionaSistema/{id}")
    public ResponseEntity<Optional<Sistema>> getUserById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Sistema>>(systemService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @DeleteMapping("/eliminaSistema/{id}")
    public ResponseEntity<?> eliminaSistema(@PathVariable("id") Integer id){

        systemService.eliminaSistema(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Sistema eliminato!");
    }

    @GetMapping("/controllaAbbonamento/{id}")
    public ResponseEntity<?> controllaAbbonamento(@PathVariable("id") Integer id){

        if(systemService.controllaAbbonamento(id)){
            return (ResponseEntity<?>) ResponseEntity.ok("Abbonamento presente!");
        }else{
            systemService.addebitaMulta(id);
            return(ResponseEntity<?>) ResponseEntity.ok("Abbonamento non presente, addebito multa!");
        }
    }

}
