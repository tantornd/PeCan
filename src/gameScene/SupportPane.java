package gameScene;

import card.SupportCard.event.EventCard;
import game.GameLogic;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SupportPane extends GridPane {
    private static Thread playerEventT;
    public SupportPane() {
        setMinSize(160, 240);
        setPrefWidth(320);
        setPrefHeight(480);
        playerEventT = new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (EventCard ec : GameLogic.getInstance().getEventCards().get(0)) {
                            getChildren().add(ec);
                        }
                    }
                });
            }
        });
        playerEventT.start();
    }

    public static Thread getPlayerEventT() {
        return playerEventT;
    }
}
