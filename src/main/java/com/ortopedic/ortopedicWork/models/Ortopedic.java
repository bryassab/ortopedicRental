package com.ortopedic.ortopedicWork.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="ortopedic")
public class Ortopedic implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ortopedic_id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;
    private Integer year;
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("ortopedics")
    private Category idCategory;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="idOrtopedics" )
    @JsonIgnoreProperties("idOrtopedics")
    private List<Message> messages;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="idOrtopedic" )
    @JsonIgnoreProperties("idOrtopedic")
    private List<Reservations> reservations  ;

    public Integer getOrtopedic_id() {
        return ortopedic_id;
    }

    public void setOrtopedic_id(Integer ortopedic_id) {
        this.ortopedic_id = ortopedic_id;
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

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }
}
