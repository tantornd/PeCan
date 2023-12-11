package gameScene;

import card.CharacterCard.BaseCharacterCard;
import game.GameLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

public class Battle extends GridPane {
    public HBox playerChara, botChara;

    public Battle(){
        setPrefHeight(900);
        setPrefWidth(1440);
        setMinSize(360,450);
        Image bg = new Image(ClassLoader.getSystemResource("battleBG.png").toString());
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));

        playerChara = new HBox();
        playerChara.setPrefWidth(720);
        playerChara.setPrefHeight(270);
        for (BaseCharacterCard bcc: GameLogic.getInstance().getCharacterCards().get(0)){
            HBox hb = new HBox();
            hb.setPrefHeight(270);
            if (bcc.getActive()) {
                hb.getChildren().add(bcc);
                hb.setAlignment(Pos.TOP_CENTER);
            } else {
                hb.getChildren().add(bcc);
                hb.setAlignment(Pos.CENTER);
            }
            playerChara.getChildren().add(hb);
        }


    }

}
