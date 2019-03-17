package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class TrainingTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "trainingTypes")
  private Set<Trainer> trainers;

  private String trainingName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

  public Set<Trainer> getTrainers() {
    return trainers;
  }

  public void setTrainers(Set<Trainer> trainers) {
    this.trainers = trainers;
  }


}
