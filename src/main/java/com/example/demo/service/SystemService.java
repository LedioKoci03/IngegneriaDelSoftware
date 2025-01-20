package com.example.demo.service;

import com.example.demo.repository.SystemRepository;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemService {

    @Autowired
    SystemRepository systemRepository;

    public void registraSistema(Sistema s){

        systemRepository.save(s);
    }

    public Optional<Sistema> getById(Integer id){
        return systemRepository.findById(id);
    }

    public void eliminaSistema(Integer id){
        systemRepository.deleteById(id);
    }
}
