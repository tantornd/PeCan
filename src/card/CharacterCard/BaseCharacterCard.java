package card.CharacterCard;

import game.WeaponType;

public abstract class BaseCharacterCard {
    public WeaponType weaponType;
    public int energy;
    public int shield;
    public int hp;
    public int baseAttack;
    public boolean active;

    public BaseCharacterCard(WeaponType weaponType, int baseAttack){
        setWeaponType(weaponType);
        setBaseAttack(baseAttack);
        setEnergy(0);
        setShield(0);
        setHp(10);
        setActive(false);
    }
    public abstract void attack();
    public abstract void takeDamage(int damage);
    public abstract void useSkill();
    public abstract void useUltimate();
    public boolean isAlive(){
        return hp > 0;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public void setWeaponType(WeaponType weaponType){
        this.weaponType = weaponType;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public void setShield(int shield){
        this.shield = shield;
    }
    public void setHp(int hp){
        if (hp < 0) hp = 0;
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
}
