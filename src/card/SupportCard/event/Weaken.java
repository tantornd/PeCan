package card.SupportCard.event;

import game.GameLogic;

public class Weaken extends EventCard{

    public Weaken() {
        super(3, 1);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.getActiveCharaOpponent(player).setBaseAttack(game.getActiveCharaOpponent(player).getBaseAttack() - 1);
    }
}
