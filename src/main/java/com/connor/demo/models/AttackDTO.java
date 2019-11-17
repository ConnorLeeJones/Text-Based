package com.connor.demo.models;

public class AttackDTO {

    private Long attackerId;
    private String choice;
    private Long opponentId;
    private Long battleId;

    public AttackDTO(Long attackerId, String choice, Long opponentId, Long battleId) {
        this.attackerId = attackerId;
        this.choice = choice;
        this.opponentId = opponentId;
        this.battleId = battleId;
    }


    public Long getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Long getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Long opponentId) {
        this.opponentId = opponentId;
    }

    public Long getBattleId() {
        return battleId;
    }

    public void setBattleId(Long battleId) {
        this.battleId = battleId;
    }
}
