package gameScene;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import game.GameLogic;
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


        VBox right = new VBox();
        HBox rightBottomPane = new HBox();

        Button atkBtn = new Button("ATK");
        atkBtn.setPrefHeight(150);
        atkBtn.setPrefWidth(150);
        atkBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            // TODO active chara
                if (GameLogic.getInstance().canAttack(0)) {
                    GameLogic.getInstance().getActiveChara(GameLogic.getInstance().getCharacterCards().get(0)).attack();
                }
            }
        });

        Button skillBtn = new Button("SKILL");
        skillBtn.setPrefWidth(150);
        skillBtn.setPrefHeight(150);
        skillBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // TODO active chara
                if (GameLogic.getInstance().canUseSkill(0)) {
                    GameLogic.getInstance().getActiveChara(GameLogic.getInstance().getCharacterCards().get(0)).useSkill();
                }
            }
        });

        Button ultiBtn = new Button("ULTI");
        ultiBtn.setPrefHeight(150);
        ultiBtn.setPrefWidth(150);
        ultiBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // TODO active chara
                if (GameLogic.getInstance().canUseUltimate(0)) {
                    GameLogic.getInstance().getActiveChara(GameLogic.getInstance().getCharacterCards().get(0)).useUltimate();
                }
            }
        });

        Text dice = new Text();
        dice.setText(Integer.toString(GameLogic.getInstance().getDice().get(0)));

        rightBottomPane.getChildren().add(atkBtn);
        rightBottomPane.getChildren().add(skillBtn);
        rightBottomPane.getChildren().add(ultiBtn);
        rightBottomPane.getChildren().add(dice);
        right.getChildren().add(rightBottomPane);


        VBox left = new VBox();
        left.setPrefWidth(360);
        supportPane = new SupportPane();

        Button info = new Button();
        info.setPrefWidth(150);
        info.setPrefHeight(100);
        info.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "There are 3 types of support card.\n"+"1. Weapon Card (increases your characters damage)\n" +
                        "2. Food Card (heals your character or gives your character shield)\n" +
                        "3. Event Card (takes effect at the start of every round, for a set amount of rounds)");
            }
        });
        left.setSpacing(200);
        left.getChildren().add(info);


        getChildren().addAll(middle, right, left);
        setAlignment(middle, Pos.CENTER);
        setAlignment(right, Pos.BOTTOM_RIGHT);
        setAlignment(left, Pos.BOTTOM_LEFT );


    }

    public static Thread getSupportT() {
        return supportT;
    }

}
