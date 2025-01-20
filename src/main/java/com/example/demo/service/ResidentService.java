package com.example.demo.service;

import com.example.demo.repository.ResidentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.src_gen.diagrammi_uml.Residente;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    private final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public void registraResidente(Residente r){
        residentRepository.save(r);
    }

    public Optional<Residente> getById(Integer id){
        return residentRepository.findById(id);
    }

    public void eliminaResidente(Integer id){
        residentRepository.deleteById(id);
    }
}
