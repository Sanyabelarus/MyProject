package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trainingTypes_id", nullable = false)
    private TrainingTypes trainingTypes;

    @OneToMany(mappedBy = "trainer")
    private Set<Section> sections;

    public Trainer(Integer id, User user, TrainingTypes trainingTypes, Set<Section> sections) {
        this.id = id;
        this.user = user;
        this.trainingTypes = trainingTypes;
        this.sections = sections;
    }

    public Trainer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TrainingTypes getTrainingTypes() {
        return trainingTypes;
    }

    public void setTrainingTypes(TrainingTypes trainingTypes) {
        this.trainingTypes = trainingTypes;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

}