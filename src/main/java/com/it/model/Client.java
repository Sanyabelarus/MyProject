package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "client_has_section",
            joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "section_id", referencedColumnName = "id")})
    private Set<Section> section;

    private Boolean haveclubcard;

    private Integer money;


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

    public Boolean getHaveclubcard() {
        return haveclubcard;
    }

    public void setHaveclubcard(Boolean haveclubcard) {
        this.haveclubcard = haveclubcard;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Set<Section> getSection() {
        return section;
    }

    public void setSection(Set<Section> section) {
        this.section = section;
    }
}