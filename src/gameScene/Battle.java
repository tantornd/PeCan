package gameScene;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import game.GameLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

public class Battle extends BorderPane {
    public HBox playerChara, botChara;

    public Battle(){
        setPrefHeight(900);
        setPrefWidth(1440);

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
        HBox playerSupport = new HBox();
        playerSupport.setPrefWidth(720);
        playerSupport.setPrefHeight(270);
        for (BaseSupportCard bsc : GameLogic.getInstance().getPlayerHands().get(0)){
            HBox hb = new HBox();
            hb.setPrefHeight(240);
            hb.getChildren().add(bsc);
            playerSupport.getChildren().add(hb);
        }


        botChara = new HBox();
        botChara.setPrefHeight(720);
        botChara.setPrefWidth(270);
        for (BaseCharacterCard bcc: GameLogic.getInstance().getCharacterCards().get(1)){
            HBox hb = new HBox();
            hb.setPrefHeight(270);
            if (bcc.getActive()) {
                hb.getChildren().add(bcc);
                hb.setAlignment(Pos.TOP_CENTER);
            } else {
                hb.getChildren().add(bcc);
                hb.setAlignment(Pos.CENTER);
            }
            botChara.getChildren().add(hb);
        }
    }

}
