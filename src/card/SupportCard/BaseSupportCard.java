package card.SupportCard;

import card.SupportCard.event.EventCard;
import gameScene.Battle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;

public abstract class BaseSupportCard extends StackPane {
    private int cost;
    public BaseSupportCard(int cost){
        setCost(cost);

        setPrefHeight(240);
        setPrefWidth(160);
        Image bg = getImage();
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (isPlayable()) {
                    play();
                }
                Battle.getSupportT().start();

            }
        });

    }
    public void setCost(int cost){
        if (cost <= 0) cost = 0;
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public abstract void play();
    public abstract boolean isPlayable();
    public abstract Image getImage();
}
