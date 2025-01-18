package com.example.demo.repository;

import com.example.demo.src_gen.diagrammi_uml.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends JpaRepository<Sistema, Integer> {
}
