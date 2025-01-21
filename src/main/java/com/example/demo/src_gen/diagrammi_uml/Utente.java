package com.example.demo.src_gen.diagrammi_uml;

import jakarta.persistence.*;
import lombok.*;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setMulta(boolean multa) {
        this.multa = multa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isMulta() {
        return multa;
    }

    public String getTarga() {
        return targa;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getEta() {
        return eta;
    }

    public Integer getId(){
        return id;
    }

    public void registraVeicolo() {}

    public void richiediAbbonamento(){};

}
