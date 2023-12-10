package game;

import card.CharacterCard.BaseCharacterCard;

import java.util.ArrayList;

public class CarryOnDamage { //DAMAGE FROM FLAME ARCHER
    private int rounds;
    private int damage;
    private boolean attackAll;
    public CarryOnDamage(int rounds, int damage, boolean attackAll){
        this.rounds = rounds;
        this.damage = damage;
        this.attackAll = attackAll;
    }
    public void decrementRounds(){
        if (rounds > 0) --rounds;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setAttackAll(boolean attackAll) {
        this.attackAll = attackAll;
    }

    public int getDamage() {
        return damage;
    }

    public int getRounds() {
        return rounds;
    }
    public boolean getAttackAll(){
        return attackAll;
    }
}
