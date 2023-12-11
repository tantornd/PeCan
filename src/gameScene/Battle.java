package gameScene;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import game.GameLogic;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class Battle extends BorderPane {
    public CharacterPane characterPane;
    public SupportPane supportPane;
    public static Thread supportT;

    public Battle(){
        setPrefHeight(900);
        setPrefWidth(1440);

        Image bg = new Image(ClassLoader.getSystemResource("battleBG.png").toString());
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));

        this.characterPane = new CharacterPane();

        VBox middle = new VBox();
        middle.setPrefHeight(900);
        middle.setPrefWidth(720);

        HBox playerSupport = new HBox();
        playerSupport.setPrefHeight(270);
        playerSupport.setPrefWidth(720);

        supportT = new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (BaseSupportCard bsc : GameLogic.getInstance().getPlayerHands().get(0)) {
                            playerSupport.getChildren().add(bsc);
                        }
                    }
                });
            }
        });
        middle.getChildren().add(playerSupport);
        middle.getChildren().add(characterPane);

        VBox left = new VBox();
        HBox leftBottomPane = new HBox();

        Button atkBtn = new Button("ATK");
        atkBtn.setPrefHeight(150);
        atkBtn.setPrefWidth(150);
        atkBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            // TODO active chara
            }
        });

        Button skillBtn = new Button("SKILL");
        skillBtn.setPrefWidth(150);
        skillBtn.setPrefHeight(150);
        skillBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // TODO active chara
            }
        });

        Button ultiBtn = new Button("ULTI");
        ultiBtn.setPrefHeight(150);
        ultiBtn.setPrefWidth(150);
        ultiBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // TODO active chara
            }
        });

        Text dice = new Text();
        leftBottomPane.getChildren().add(atkBtn);
        leftBottomPane.getChildren().add(skillBtn);
        leftBottomPane.getChildren().add(ultiBtn);
        leftBottomPane.getChildren().add(dice);
        left.getChildren().add(leftBottomPane);

    }

    public static Thread getSupportT() {
        return supportT;
    }

}
