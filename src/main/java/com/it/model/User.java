package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "user")
  private Set<Client> clients;

  @OneToMany(mappedBy = "user")
  private Set<Trainer> trainers;

  @ManyToOne
  @JoinColumn(name = "roles_id", nullable = false)
  private Roles roles;


  private String name;

  private String login;

  private String password;

  private String email;

  public User(Integer id, Set<Client> clients, Set<Trainer> trainers, Roles roles, String name, String login, String password, String email) {
    this.id = id;
    this.clients = clients;
    this.trainers = trainers;
    this.roles = roles;
    this.name = name;
    this.login = login;
    this.password = password;
    this.email = email;
  }

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<Client> getClients() {
    return clients;
  }

  public void setClients(Set<Client> clients) {
    this.clients = clients;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Roles getRoles() {
    return roles;
  }

  public void setRoles(Roles roles) {
    this.roles = roles;
  }

  public Set<Trainer> getTrainers() {
    return trainers;
  }

  public void setTrainers(Set<Trainer> trainers) {
    this.trainers = trainers;
  }

}
