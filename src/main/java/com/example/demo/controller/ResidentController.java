package com.example.demo.controller;

import com.example.demo.service.ResidentService;
import com.example.demo.src_gen.diagrammi_uml.Residente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Resident")
public class ResidentController {

    @Autowired
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping("/registraResidente")
    public ResponseEntity<?> registraUtente(@RequestBody Residente residente){

        residentService.registraResidente(residente);

        return (ResponseEntity<?>) ResponseEntity.ok("Residente registrato!");
    }

    @GetMapping("/selezionaResidente/{id}")
    public ResponseEntity<Optional<Residente>> getById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Residente>>(residentService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/eliminaResidente/{id}")
    public ResponseEntity<?> eliminaUtente(@PathVariable("id") Integer id){

        residentService.eliminaResidente(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Residente eliminato!");
    }

}
