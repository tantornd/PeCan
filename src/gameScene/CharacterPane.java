package gameScene;

import card.CharacterCard.BaseCharacterCard;
import game.GameLogic;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharacterPane extends VBox {
    private HBox playerChara, botChara;
    public static Thread characterT;

    public CharacterPane() {
        setPrefHeight(900);
        setPrefWidth(720);

        playerChara = new HBox();
        playerChara.setPrefWidth(720);
        playerChara.setPrefHeight(270);

        botChara = new HBox();
        botChara.setPrefHeight(720);
        botChara.setPrefWidth(270);

        characterT = new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
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
                });
            }
        });
        characterT.start();
        getChildren().add(playerChara);
        getChildren().add(botChara);
    }

    public static Thread getThread() {
        return characterT;
    }
}
