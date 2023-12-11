package card.SupportCard.food.shielding;

import card.SupportCard.food.FoodCard;

public class ShieldingFood extends FoodCard {
    private int amount;
    public ShieldingFood(int cost, int amount) {
        super(cost);
        this.amount = amount;
    }
    @Override
    public void play() {
        //TODO: SELECT TARGET
        //TODO: INCREASE TARGET'S SHIELD BY AMOUNT USING CHARACTERCARDS.GET(selected character) AND METHODS FROM CHARACTERCARD CLASS
        //TODO: USEDICE(COST)
        //NOTE: NO NEED TO NEXT PLAYER TURN, PLAYERS CAN KEEP USING SUPPORT CARDS
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) amount = 0;
        this.amount = amount;
    }
}
