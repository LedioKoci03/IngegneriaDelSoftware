package com.example.demo.service;

import com.example.demo.repository.SystemRepository;
import com.example.demo.repository.VisitatoreRepository;
import com.example.demo.src_gen.diagrammi_uml.Sistema;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemService {

    @Autowired
    SystemRepository systemRepository;
    @Autowired
    UserService userService;

    public void registraSistema(Sistema s){

        systemRepository.save(s);
    }

    public Optional<Sistema> getById(Integer id){
        return systemRepository.findById(id);
    }

    public void eliminaSistema(Integer id){
        systemRepository.deleteById(id);
    }

    public boolean controllaAbbonamento(Integer id){

        Utente utente = userService.getById(id).get();

        if(utente.tipo == null){
            return false;
        }else{
            return true;
        }
    }

    public void addebitaMulta(Integer id){

        Utente utente = userService.getById(id).get();

        utente.multa = true;

        userService.registraUtente(utente);
    }
}
