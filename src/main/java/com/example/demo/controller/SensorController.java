package com.example.demo.controller;

import com.example.demo.service.SensorService;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Sensor")
public class SensorController {

    @Autowired
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/registraSensore")
    public ResponseEntity<?> registraSensore(@RequestBody Sensore sensore){

        sensorService.registraSensore(sensore);

        return (ResponseEntity<?>) ResponseEntity.ok("Sensore registrato!");

    }

    @GetMapping("/selezionaSensore/{id}")
    public ResponseEntity<Optional<Sensore>> getById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Sensore>>(sensorService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/sensoreRileva/{id}")
    public ResponseEntity<?> sensoreRileva(@PathVariable("id") Integer id){

        String messaggio = sensorService.sensoreRileva(id);

        return (ResponseEntity<?>) ResponseEntity.ok(messaggio);
    }

    @DeleteMapping("/eliminaSensore/{id}")
    public ResponseEntity<?> eliminaSensore(@PathVariable("id") Integer id){

        sensorService.eliminaSensore(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Sensore eliminato!");
    }

}
