package gameScene;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import game.GameLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class Battle extends BorderPane {
    public HBox playerChara, botChara, playerSupport;

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
        playerSupport = new HBox();
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

        VBox middle = new VBox();
        middle.setPrefHeight(900);
        middle.setPrefWidth(720);
        middle.getChildren().add(playerSupport);
        middle.getChildren().add(playerChara);
        middle.getChildren().add(botChara);

        VBox left = new VBox();
        HBox leftBottomPane = new HBox();
        Button atkBtn = new Button("ATK");
        atkBtn.setPrefHeight(150);
        atkBtn.setPrefWidth(150);
        Button skillBtn = new Button("SKILL");
        skillBtn.setPrefWidth(150);
        skillBtn.setPrefHeight(150);
        Button ultiBtn = new Button("ULTI");
        ultiBtn.setPrefHeight(150);
        ultiBtn.setPrefWidth(150);
        Text dice = new Text();
        leftBottomPane.getChildren().add(atkBtn);
        leftBottomPane.getChildren().add(skillBtn);
        leftBottomPane.getChildren().add(ultiBtn);
        leftBottomPane.getChildren().add(dice);

    }

}
