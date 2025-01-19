package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VisitatoreRepository;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitatoreService {

    @Autowired
    private final  VisitatoreRepository visitatoreRepository;

    public VisitatoreService(VisitatoreRepository visitatoreRepository) {
        this.visitatoreRepository = visitatoreRepository;
    }

    public void registraVisitatore(VisitatoreOccasionale v){
        visitatoreRepository.save(v);
    }

    public Optional<VisitatoreOccasionale> getById(Integer id){
        return visitatoreRepository.findById(id);
    }

    public void eliminaVisitatore(Integer id){
        visitatoreRepository.deleteById(id);
    }
}
