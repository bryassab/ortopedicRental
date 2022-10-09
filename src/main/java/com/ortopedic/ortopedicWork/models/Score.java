package com.ortopedic.ortopedicWork.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="score")
public class Score implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer score_id;
    private Integer score;
    @Column(name = "message", nullable = false, length = 250)
    private String message;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "idScore")
    @JsonIgnoreProperties("idScore")
    private Reservations reservations;

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }
}
