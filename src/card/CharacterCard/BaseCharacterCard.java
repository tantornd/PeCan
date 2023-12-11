package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public abstract class BaseCharacterCard extends StackPane {
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

        setPrefHeight(240);
        setPrefWidth(160);
        Image bg = getImage();
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));
        Circle circle1 = new Circle(50, Color.WHITE);
        Text Hp = new Text();
        Circle circle2 = new Circle(50, Color.WHITE);
        Text ener = new Text();
        getChildren().add(circle1);
        getChildren().add(circle2);
        getChildren().add(Hp);
        getChildren().add(ener);
        setAlignment(circle1, Pos.TOP_LEFT);
        setAlignment(Hp, Pos.TOP_LEFT);
        setAlignment(circle2, Pos.BOTTOM_RIGHT);
        setAlignment(ener, Pos.BOTTOM_RIGHT);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Hp.setText(String.valueOf(hp));
                        ener.setText(String.valueOf(energy));
                    }
                });
            }
        });
        t.start();
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!active) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "R U Sure?");
                    a.show();
                } // TODO active
            }
        });
    }

    public void setActive(boolean active){
        this.active = active;
    }
    public void switchActive(){
        GameLogic game = GameLogic.getInstance();
        if (game.getCharacterCards().get(game.getCurrentPlayer()).size() >= 2) {
            ArrayList<BaseCharacterCard> curChar = game.getCharacterCards().get(game.getCurrentPlayer());
            curChar.get(curChar.indexOf(this)).setActive(false);
            curChar.get((curChar.indexOf(this) + 1) % curChar.size()).setActive(true);
            game.useDice(1);

            //TODO: ADD JAVAFX!!!!!!!!!!! เวลาเปลี่ยนตัวที่ active ต้องมี ui ที่บอกว่าตัวนี้ active หรือเขียน class ใหม่เองละเรียกใช้ method นี้ก็ได้
        }

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
            game.getActiveCharaOpponent(game.getCurrentPlayer()).switchActive();
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


    public abstract Image getImage();
}