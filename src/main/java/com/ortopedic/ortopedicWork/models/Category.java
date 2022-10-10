package com.ortopedic.ortopedicWork.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ortopedic")
    @JsonIgnoreProperties("categories")
    private Ortopedic ortopedic;

    @OneToMany( mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Ortopedic> ortopedicList;



    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }


}
