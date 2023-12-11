package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;

public abstract class BaseCharacterCard {
    public WeaponType weaponType;
    public int energy;
    public int shield;
    public int hp;
    public int baseAttack;
    public static boolean active;
    public boolean full;

    public BaseCharacterCard(WeaponType weaponType, int baseAttack){
        setWeaponType(weaponType);
        setBaseAttack(baseAttack);
        setEnergy(0);
        setShield(0);
        setHp(10);
        setActive(false);
    }

    public void setActive(boolean active){
        this.active = active;
        GameLogic.getInstance().useDice(1);

        //TODO: ADD JAVAFX!!!!!!!!!!! เวลาเปลี่ยนตัวที่ active ต้องเปลี่ยนช่องสกิลด้วย

        GameLogic.getInstance().nextPlayerTurn();
    }
    public void takeDamage(int damage){
        if (shield > 0){
            shield -= damage;
        }
        if (shield < 0){
            setHp(getHp() + shield);
            shield = 0;
        }
        if (!isAlive()){
            GameLogic game = GameLogic.getInstance();
            game.getCharacterCards().get((game.getCurrentPlayer() + 1) % 2).remove(this);
        }
    }
    public boolean canAttack(){
        GameLogic game = GameLogic.getInstance();
        return game.getDice().get(game.getCurrentPlayer()) > 2;
    }
    public boolean canUseSkill(){
        GameLogic game = GameLogic.getInstance();
        return game.getDice().get(game.getCurrentPlayer()) > 3;
    }
    public boolean canUseUltimate(){
        GameLogic game = GameLogic.getInstance();
        return game.getDice().get(game.getCurrentPlayer()) > 3 && energy == 3;
    }
    public void attack(){
        if (canAttack()) {
            GameLogic game = GameLogic.getInstance();
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 2);
            setEnergy(getEnergy() + 1);
            game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack);
            game.nextPlayerTurn();
        }
    }
    public abstract void useSkill();
    public abstract void useUltimate();
    public boolean isAlive(){
        return hp > 0;
    }
    public void setWeaponType(WeaponType weaponType){
        this.weaponType = weaponType;
    }
    public void setEnergy(int energy){
        if (energy >= 3){
            energy = 3;
        }
        this.energy = energy;
    }
    public void setShield(int shield){
        this.shield = shield;
    }
    public void setHp(int hp){
        if (hp < 0) hp = 0;
        if (hp > 10) hp = 10;
        this.hp = hp;
    }
    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }
    public WeaponType getWeaponType(){
        return weaponType;
    }
    public int getHp() {
        return hp;
    }
    public int getEnergy() {
        return energy;
    }
    public int getBaseAttack() {
        return baseAttack;
    }
    public int getShield(){
        return shield;
    }
    public boolean getActive(){
        return active;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return full;
    }
}
