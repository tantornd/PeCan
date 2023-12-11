package card.SupportCard.event;

import game.GameLogic;

public class AfterShock extends EventCard{

    public AfterShock() {
        super(3, 2);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.getActiveCharaOpponent(player).takeDamage(1);
    }
}
