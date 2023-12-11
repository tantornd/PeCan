package card.SupportCard.event;

import game.GameLogic;

public class DivineGrace extends EventCard{
    //ADDS 2 EXTRA DICE AT THE START OF THE ROUND
    public DivineGrace() {
        super(3,2);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.setDice(player, game.getDice().get(player) + 2);
    }
}
