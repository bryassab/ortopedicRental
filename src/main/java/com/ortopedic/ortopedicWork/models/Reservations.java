package com.ortopedic.ortopedicWork.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="reservations")
public class Reservations implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer reservation_id;
    private Date start_date;
    private Date devolution_date;
    private String status="creado";

    @ManyToOne
    @JoinColumn(name = "idOrtopedic")
    @JsonIgnoreProperties("reservations")
    private Ortopedic idOrtopedic;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("reservations")
    private Client idClient;

    @OneToOne
    @JoinColumn(name = "idScore")
    @JsonIgnoreProperties("reservations")
    private Score idScore;



 

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getDevolution_date() {
        return devolution_date;
    }

    public void setDevolution_date(Date devolution_date) {
        this.devolution_date = devolution_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Ortopedic getIdOrtopedic() {
        return idOrtopedic;
    }

    public void setIdOrtopedic(Ortopedic idOrtopedic) {
        this.idOrtopedic = idOrtopedic;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
    public Score getIdScore() {
        return idScore;
    }

    public void setIdScore(Score idScore) {
        this.idScore = idScore;
    }
}
