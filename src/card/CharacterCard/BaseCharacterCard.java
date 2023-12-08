package card.CharacterCard;

import game.WeaponType;

public abstract class BaseCharacterCard {
    public WeaponType weaponType;
    public String name;
    public int energy;
    public int shield;
    public int hp;
    public int baseAttack;

    public BaseCharacterCard(String name, WeaponType weaponType, int baseAttack){
        setName(name);
        setWeaponType(weaponType);
        setBaseAttack(baseAttack);
        setEnergy(0);
        setShield(0);
        setHp(10);
    }
    public abstract void attack();
    public abstract void takeDamage();
    public void setWeaponType(WeaponType weaponType){
        this.weaponType = weaponType;
    }
    public void setName(String name){
        this.name = name;
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
    public String getName(){
        return name;
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
}
