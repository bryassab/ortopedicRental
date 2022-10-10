package com.ortopedic.ortopedicWork.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ortopedic")
public class Ortopedic implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;
    private Integer year;
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @OneToMany( mappedBy = "ortopedic")
    @JsonIgnoreProperties("ortopedic")
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("ortopedicList")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "messages")
    @JsonIgnoreProperties("ortopedic")
    private Message messages;

    @ManyToOne
    @JoinColumn(name = "reservations")
    @JsonIgnoreProperties("ortopedicList")
    private Reservations reservations;

    @OneToMany( mappedBy = "ortopedicC")
    @JsonIgnoreProperties("ortopedicC")
    private List<Client> clients;

    @OneToMany( mappedBy = "ortopedic")
    @JsonIgnoreProperties("ortopedic")
    private List<Reservations> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Reservations> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservations> reservation) {
        this.reservation = reservation;
    }
}
