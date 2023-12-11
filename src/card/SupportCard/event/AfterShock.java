package card.SupportCard.event;

import game.GameLogic;
import javafx.scene.image.Image;

public class AfterShock extends EventCard{

    public AfterShock() {
        super(3, 2);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.getActiveCharaOpponent(player).takeDamage(1);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("AfterShock.png").toString());
    }
}
