package com.example.demo.src_gen.diagrammi_uml;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "abbonamento")
public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "tipoAbb")
    public String tipoAbb;

    @Column(name = "durata")
    public String durata;

}
