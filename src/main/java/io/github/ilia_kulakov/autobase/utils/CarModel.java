package io.github.ilia_kulakov.autobase.utils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "models")
public class CarModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer modelID;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MODEL")
    private Manufacture manufacture;

    public CarModel() {
    }

    public CarModel(String name) {
        this.name = name;
    }

    public CarModel(Integer modelID, String name) {
        this.modelID = modelID;
        this.name = name;
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public void setName(String name) {
        this.name = name;
    }
}