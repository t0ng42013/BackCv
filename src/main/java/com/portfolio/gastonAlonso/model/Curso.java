package com.portfolio.gastonAlonso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(max = 50, message = "no cumple la longitud")
    private String instituto;
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String titulo;

    public Curso() {
    }

    public Curso( String instituto, Date inicio, Date fin, String titulo) {
        this.instituto = instituto;
        this.inicio = inicio;
        this.fin = fin;
        this.titulo = titulo;
    }

}
