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
}