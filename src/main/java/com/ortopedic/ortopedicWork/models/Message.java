package com.ortopedic.ortopedicWork.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer message_id;
    @Column(name = "text", nullable = false, length = 450)
    private String text;

    @ManyToOne
    @JoinColumn(name = "idOrtopedics")
    @JsonIgnoreProperties("messages")
    private Ortopedic idOrtopedics;

    @ManyToOne
    @JoinColumn(name = "idClients")
    @JsonIgnoreProperties("messages")
    private Client idClients;



    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Ortopedic getIdOrtopedics() {
        return idOrtopedics;
    }

    public void setIdOrtopedics(Ortopedic idOrtopedics) {
        this.idOrtopedics = idOrtopedics;
    }

    public Client getIdClients() {
        return idClients;
    }

    public void setIdClients(Client idClients) {
        this.idClients = idClients;
    }
}
