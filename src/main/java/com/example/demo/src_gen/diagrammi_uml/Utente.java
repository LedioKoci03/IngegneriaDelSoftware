package com.example.demo.src_gen.diagrammi_uml;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"user\"")
public class Utente {


    @Column(name = "nome")
    public String nome;

    @Column(name = "cognome")
    public String cognome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodFiscale")
    public String CodFiscale;

    @Column(name = "eta")
    public Integer eta;

    @Column(name = "tipo")
    public String tipo;

    public void registraVeicolo() {}

    public void richiediAbbonamento(){};

    public void richiediAccessoQR(){};
}
