package card.SupportCard;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public abstract class BaseSupportCard extends StackPane {
    private int cost;
    public BaseSupportCard(int cost){
        setCost(cost);

        setPrefHeight(240);
        setPrefWidth(160);

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
