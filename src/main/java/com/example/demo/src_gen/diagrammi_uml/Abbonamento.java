package com.example.demo.src_gen.diagrammi_uml;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"abbonamento\"")
public class Abbonamento {

    @Column(name = "tipoAbb")
    public String tipoAbb;

    @Column(name = "durata")
    public String durata;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public String id;

}
