package card.SupportCard.event;

import game.GameLogic;

public class DoubleDraw extends EventCard{
    public DoubleDraw() {
        super(2, 1);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.draw(player, 2);
    }
}
