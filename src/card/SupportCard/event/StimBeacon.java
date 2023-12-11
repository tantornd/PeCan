package card.SupportCard.event;

import card.CharacterCard.BaseCharacterCard;
import game.GameLogic;
import javafx.scene.image.Image;

public class StimBeacon extends EventCard{
    public StimBeacon() {
        super(3, 3);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        for (BaseCharacterCard e: game.getCharacterCards().get(player)){
            e.setBaseAttack(e.getBaseAttack() + 1);
        }
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("StimBeacon.png").toString());
    }
}
