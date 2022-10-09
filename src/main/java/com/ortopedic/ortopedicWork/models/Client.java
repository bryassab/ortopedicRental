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
    private Integer client_id;
    @Column(name = "client_name", nullable = false, length = 250)
    private String client_name;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    private Integer age;
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="idClients" )
    @JsonIgnoreProperties("idClients")
    private List<Message> messages;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="idClient" )
    @JsonIgnoreProperties("idClient")
    private List<Reservations> reservations;

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
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
}
