package com.example.demo.service;

import com.example.demo.repository.SensorRepository;
import com.example.demo.src_gen.diagrammi_uml.Sensore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private static SensorRepository sensorRepository;

    public static void registraSensore(Sensore s){
        sensorRepository.save(s);
    }

    public static Optional<Sensore> getById(Integer id){
        return sensorRepository.findById(id);
    }

    public static void eliminaSensore(Integer id){
        sensorRepository.deleteById(id);
    }

    public boolean accertaSensore(Integer id){

        return sensorRepository.existsById(id);
    }
}
