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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "cognome")
    public String cognome;

    @Column(name = "eta")
    public Integer eta;

    @Column(name = "tipo")
    public String tipo;

    @Column(name = "targa")
    public String targa;

    @Column(name = "multa")
    public boolean multa;

    public void registraVeicolo() {}

    public void richiediAbbonamento(){};

    public void richiediAccessoQR(){};
}
