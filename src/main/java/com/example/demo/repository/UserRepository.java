package com.example.demo.repository;

import com.example.demo.src_gen.diagrammi_uml.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utente, Integer> {

    Optional<Utente> findByNome(String nome);
}
