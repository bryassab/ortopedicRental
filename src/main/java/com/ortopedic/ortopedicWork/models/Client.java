package com.ortopedic.ortopedicWork.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(name = "name", nullable = false, length = 250)
    private String  name;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    private Integer age;
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @ManyToOne
    @JoinColumn(name = "messages")
    @JsonIgnoreProperties("client")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "reservations")
    @JsonIgnoreProperties("clients")
    private Reservations reservation;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clients")
    @JsonIgnoreProperties("message")
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "ortopedic")
    @JsonIgnoreProperties("clients")
    private Ortopedic ortopedicC;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservations> reservations;
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }


    public Ortopedic getOrtopedicC() {
        return ortopedicC;
    }

    public void setOrtopedicC(Ortopedic ortopedicC) {
        this.ortopedicC = ortopedicC;
    }

}
