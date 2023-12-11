package card.SupportCard.event;

import card.SupportCard.BaseSupportCard;
import game.GameLogic;

public abstract class EventCard extends BaseSupportCard {
    private int rounds;

    public EventCard(int cost, int rounds) {
        super(cost);
        setRounds(rounds);
    }
    public abstract void performEffect(int player);
    public void decrementRounds(){
        if (rounds > 0){
            setRounds(rounds - 1);
        }
    }
    @Override
    public void play() {
        GameLogic game = GameLogic.getInstance();
        game.setEventCards(this);
        game.getPlayerHands().get(game.getCurrentPlayer()).remove(this);

        //TODO: ADD JAVA FX FOR SETTING EVENT CARD IN SUPPORT SKILL ZONE

    }
    @Override
    public boolean isPlayable() {
        GameLogic game = GameLogic.getInstance();
        return game.getDice().get(game.getCurrentPlayer()) > getCost();
    }

    public void setRounds(int rounds) {
        if (rounds < 0) rounds = 0;
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }
}
