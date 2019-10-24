package com.connor.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User user;
    @Email
    private String email;
    private String firstName;
    private String lastName;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
    private Game game;

    public UserProfile(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}