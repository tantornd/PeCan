package card.SupportCard.food;

import card.SupportCard.BaseSupportCard;
import javafx.scene.image.Image;

public abstract class FoodCard extends BaseSupportCard {
    public FoodCard(int cost) {
        super(cost);
    }

    @Override
    public abstract void play();

    @Override
    public boolean isPlayable() {
        return false; //WE DO NOT NEED TO PLAY FOOD CARD IF WE DON'T WANT TO
    }

    public abstract Image getImage();
}
