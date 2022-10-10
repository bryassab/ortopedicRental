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
    private Integer idMessage;

    @Column(name = "messageText", nullable = false, length = 450)
    private String messageText;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "messages")
    @JsonIgnoreProperties("messages")
    private List<Ortopedic> ortopedic;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "message")
    @JsonIgnoreProperties("message")
    private List<Client> client;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("messages")
    private Client clients;





    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<Ortopedic> getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(List<Ortopedic> ortopedic) {
        this.ortopedic = ortopedic;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }
}
