// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package com.example.demo.src_gen.diagrammi_uml;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"sistema\"")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "nome")
    public String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registraUtente(){}

    public void generaQR(){}

    public void verificaAccesso(){}

    public void notificaConducente(){}

    public void generaMulta(){}

    public void verificaStatoRegolarita(){}

    public void addebitaTariffaAggiuntiva(){}
}
