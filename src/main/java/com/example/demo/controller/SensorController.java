package com.example.demo.controller;

import com.example.demo.service.SensorService;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping("/registraSensore")
    public ResponseEntity<?> registraSensore(@RequestBody Sensore sensore){

        SensorService.registraSensore(sensore);

        return (ResponseEntity<?>) ResponseEntity.ok("Sensore registrato!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sensore>> getById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<Sensore>>(SensorService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/accertaSensore/{id}")
    public ResponseEntity<?> accertaSensore(@PathVariable("id") Integer id){

        if(sensorService.accertaSensore(id)){
            return (ResponseEntity<?>) ResponseEntity.ok("Sensore presente!");
        }else{
            return (ResponseEntity<?>) ResponseEntity.ok("Sensore non presente!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminaSensore(@PathVariable("id") Integer id){

        SensorService.eliminaSensore(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Sensore eliminato!");
    }
}
