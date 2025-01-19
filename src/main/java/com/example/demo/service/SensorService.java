package com.example.demo.service;

import com.example.demo.repository.SensorRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public void registraSensore(Sensore s){
        sensorRepository.save(s);
    }

    public Optional<Sensore> getById(Integer id){

        return sensorRepository.findById(id);
    }

    public void eliminaSensore(Integer id){
        sensorRepository.deleteById(id);
    }
}
