package card.SupportCard.food;

public class HealingFood extends FoodCard{
    private int amount;
    public HealingFood(int cost, int amount) {
        super(cost);
        this.amount = amount;
    }
    @Override
    public void play() {
        //TODO: CHECK IF IS PLAYABLE
        //TODO: SELECT TARGET
        //TODO: INCREASE TARGET'S HP BY AMOUNT USING CHARACTERCARDS.GET(selected character) AND METHODS FROM CHARACTERCARD CLASS
        //TODO: USE DICE
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
