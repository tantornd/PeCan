package card.SupportCard.event;

import game.GameLogic;
import javafx.scene.image.Image;

public class DoubleDraw extends EventCard{
    public DoubleDraw() {
        super(2, 1);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        game.draw(player, 2);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("DoubleDraw.png").toString());
    }
}
