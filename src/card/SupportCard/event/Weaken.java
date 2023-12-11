package card.SupportCard.event;

import game.GameLogic;
import javafx.scene.image.Image;

public class Weaken extends EventCard{

    public Weaken() {
        super(3, 1);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.getActiveCharaOpponent(player).setBaseAttack(game.getActiveCharaOpponent(player).getBaseAttack() - 1);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Weaken.png").toString());
    }
}
