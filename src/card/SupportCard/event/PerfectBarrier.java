package card.SupportCard.event;

import game.GameLogic;

public class PerfectBarrier extends EventCard{
    public PerfectBarrier() {
        super(2, 2);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.getActiveChara(game.getCharacterCards().get(player)).setShield(
                game.getActiveChara(game.getCharacterCards().get(player)).getShield() + 1);
    }
}
