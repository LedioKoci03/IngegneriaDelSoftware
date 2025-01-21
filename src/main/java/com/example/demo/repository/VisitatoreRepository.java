package com.example.demo.repository;

import com.example.demo.src_gen.diagrammi_uml.Utente;
import com.example.demo.src_gen.diagrammi_uml.VisitatoreOccasionale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitatoreRepository extends JpaRepository<VisitatoreOccasionale, Integer> {

    Optional<VisitatoreOccasionale> findBySpesa(Integer spesa);
}
