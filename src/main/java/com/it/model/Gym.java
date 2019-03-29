package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "gym")
    private Set<Section> sections;

    @OneToMany(mappedBy = "gym")
    private Set<DateTime> dateTimes;

    String address;

    public Gym(Integer id, Set<Section> sections, Set<DateTime> dateTimes, String address) {
        this.id = id;
        this.sections = sections;
        this.dateTimes = dateTimes;
        this.address = address;
    }

    public Gym() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<DateTime> getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(Set<DateTime> dateTimes) {
        this.dateTimes = dateTimes;
    }

}