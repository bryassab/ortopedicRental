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
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservations")
    @JsonIgnoreProperties("reservations")
    private List<Ortopedic> ortopedicList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("reservations")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ortopedic")
    @JsonIgnoreProperties("reservation")
    private Ortopedic ortopedic;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "reservations")
    @JsonIgnoreProperties("reservations")
    private Score scores;

    @OneToOne
    @JoinColumn(name = "score")
    @JsonIgnoreProperties("reservation")
    private Score score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Ortopedic> getOrtopedicList() {
        return ortopedicList;
    }

    public void setOrtopedicList(List<Ortopedic> ortopedicList) {
        this.ortopedicList = ortopedicList;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Score getScores() {
        return scores;
    }

    public void setScores(Score scores) {
        this.scores = scores;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
