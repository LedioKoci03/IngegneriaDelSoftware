package com.example.demo.repository;

import com.example.demo.src_gen.diagrammi_uml.Sensore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensore, String> {
}
