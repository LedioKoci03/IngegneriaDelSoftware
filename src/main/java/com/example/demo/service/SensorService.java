package com.example.demo.service;

import com.example.demo.repository.SensorRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private VisitatoreService visitatoreService;

    public void registraSensore(Sensore s){
        sensorRepository.save(s);
    }

    public Optional<Sensore> getById(Integer id){

        return sensorRepository.findById(id);
    }

    public void eliminaSensore(Integer id){
        sensorRepository.deleteById(id);
    }

    public String sensoreRileva(Integer id){

        VisitatoreOccasionale visitatore = visitatoreService.getById(id).get();
        if(visitatore.tempo <= 200 && visitatore.tempo >= 0){
            return "Visitatore ancora ammesso";
        }else {
            visitatore.tempo = (visitatore.tempo+50);
            visitatoreService.registraVisitatore(visitatore);
            return "Visitatore da addebitare tariffa aggiuntiva!";
        }

    }
}
