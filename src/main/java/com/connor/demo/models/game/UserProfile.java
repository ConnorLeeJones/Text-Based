//package com.connor.demo.models.game;
//
//import com.connor.demo.models.creatures.Player;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import java.util.ArrayList;
//
//@Entity
//public class UserProfile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @Email
//    private String email;
//    private String name;
//    //private ArrayList<Player> players;
//
//    public UserProfile(){}
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getEmail() { return email; }
//
//    public void setEmail(String email) { this.email = email; }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//}