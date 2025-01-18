package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registraUtente(Utente u){
        userRepository.save(u);
    }

    public Optional<Utente> getById(Integer id){
        return userRepository.findById(id);
    }

    public void eliminaUtente(Integer id){
        userRepository.deleteById(id);
    }
}
