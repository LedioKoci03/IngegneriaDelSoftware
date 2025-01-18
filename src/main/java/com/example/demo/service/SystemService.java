package com.example.demo.service;

import com.example.demo.repository.SystemRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemService {

    @Autowired
    private SystemRepository systemRepository;

    public static void registraSistema(Sistema s){
        SystemRepository.save(s);
    }

    public static Optional<Sistema> getById(Integer id){
        return SystemRepository.findById(id);
    }

    public static void eliminaSistema(Integer id){
        SystemRepository.deleteById(id);
    }
}
