package card.SupportCard.food;

import card.SupportCard.BaseSupportCard;
import card.SupportCard.TargetSelectable;
import game.GameLogic;
import javafx.scene.image.Image;

public abstract class FoodCard extends BaseSupportCard implements TargetSelectable {
    public FoodCard(int cost) {
        super(cost);
    }

    @Override
    public abstract void play();

    @Override
    public boolean isPlayable() {
        return false; //WE DO NOT NEED TO PLAY FOOD CARD IF WE DON'T WANT TO
    }

    @Override
    public void selectTarget() {
        //TODO: SELECT TARGETS THAT CAN EAT THIS FOOD (ON CLICK EVENT)
    }

    public abstract Image getImage();
}
