package card.SupportCard.food;

import card.SupportCard.BaseSupportCard;
import card.SupportCard.TargetSelectable;
import game.GameLogic;

public abstract class FoodCard extends BaseSupportCard implements TargetSelectable {
    public FoodCard(int cost) {
        super(cost);
    }

    @Override
    public abstract void play();

    @Override
    public boolean isPlayable() {
        GameLogic game = GameLogic.getInstance();
        return game.getDice().get(game.getCurrentPlayer()) > getCost();
    }

    @Override
    public void selectTarget() {
        //TODO: SELECT TARGETS THAT CAN EQUIP THIS WEAPON (ON CLICK EVENT)
        //TODO: HANDLE IF TARGET"S WEAPON TYPE DOESN'T MATCH
    }
}
