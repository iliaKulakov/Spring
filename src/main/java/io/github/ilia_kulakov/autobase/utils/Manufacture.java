package io.github.ilia_kulakov.autobase.utils;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "manufacture")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacture")
    @Column(name = "ID_MODEL")
    private List<CarModel> carModels;

    @Column(name = "manufacturer_name")
    private String name;

    public Manufacture() {
    }

    public Manufacture(List<CarModel> carModels, String name) {
        this.carModels = carModels;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
