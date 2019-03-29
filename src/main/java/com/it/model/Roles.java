package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Roles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "roles")
  private Set<User> user;

  private String roleName;

  public Roles(Integer id, Set<User> user, String roleName) {
    this.id = id;
    this.user = user;
    this.roleName = roleName;
  }

  public Roles() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

}
