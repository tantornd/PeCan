package card.SupportCard.food.shielding;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.food.FoodCard;
import game.GameLogic;
import javafx.scene.image.Image;

public abstract class ShieldingFood extends FoodCard {
    private int amount;
    public ShieldingFood(int cost, int amount) {
        super(cost);
        this.amount = amount;
    }
    @Override
    public void play() {
        GameLogic game = GameLogic.getInstance();
        int curPlayer = game.getCurrentPlayer();
        BaseCharacterCard temp = game.getCharacterCards().get(curPlayer).get(0);
        for (BaseCharacterCard e: game.getCharacterCards().get(curPlayer)){
            if (e.getHp() < temp.getHp()) temp = e;
        }
        temp.setShield(temp.getShield() + amount);
        game.getPlayerHands().get(game.getCurrentPlayer()).remove(this);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) amount = 0;
        this.amount = amount;
    }
    public abstract Image getImage();
}
