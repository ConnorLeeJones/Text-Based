package com.connor.demo.models;

public class PlayerDTO {

    private String name;
    private User user;
    private Long gameId;

    public PlayerDTO() {}

    public PlayerDTO(String name, Long gameId) {
        this.name = name;
        //this.user = user;
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
