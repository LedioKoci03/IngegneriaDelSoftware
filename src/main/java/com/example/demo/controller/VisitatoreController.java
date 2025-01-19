package com.example.demo.controller;

import com.example.demo.service.VisitatoreService;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Visitatore")
public class VisitatoreController {

    @Autowired
    private final VisitatoreService visitatoreService;

    public VisitatoreController(VisitatoreService visitatoreService) {
        this.visitatoreService = visitatoreService;
    }

    @PostMapping("/registraVisitatore")
    public ResponseEntity<?> registraVisitatore(@RequestBody VisitatoreOccasionale visitatore){

        visitatoreService.registraVisitatore(visitatore);

        return (ResponseEntity<?>) ResponseEntity.ok("Visitatore registrato!");
    }

    @GetMapping("/selezionaVisitatore/{id}")
    public ResponseEntity<Optional<VisitatoreOccasionale>> getUserById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<Optional<VisitatoreOccasionale>>(visitatoreService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/eliminaVisitatore/{id}")
    public ResponseEntity<?> eliminaVisitatore(@PathVariable("id") Integer id){

        visitatoreService.eliminaVisitatore(id);

        return (ResponseEntity<?>) ResponseEntity.ok("Visitatore eliminato!");
    }
}
