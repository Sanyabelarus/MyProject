package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "datetime_id", nullable = false)
    private DateTime dateTime;

    @OneToMany(mappedBy = "day")
    private Set<Time> times;

    public Day(Integer id, DateTime dateTime, Set<Time> times) {
        this.id = id;
        this.dateTime = dateTime;
        this.times = times;
    }

    public Day() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Time> getTimes() {
        return times;
    }

    public void setTimes(Set<Time> times) {
        this.times = times;
    }

}