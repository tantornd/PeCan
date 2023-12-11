package card.SupportCard.event;

import card.CharacterCard.BaseCharacterCard;
import game.GameLogic;
import javafx.scene.image.Image;

public class Devour extends EventCard{
    public Devour() {
        super(2, 2);
    }

    @Override
    public void performEffect(int player) {
        GameLogic game = GameLogic.getInstance();
        if (game.getActiveCharaOpponent(player).getHp() > 1 ){
            game.getActiveCharaOpponent(player).takeDamage(1);
            BaseCharacterCard temp = game.getCharacterCards().get(player).get(0);
            for (BaseCharacterCard e: game.getCharacterCards().get(player)){
                if (e.getHp() < temp.getHp()){
                    temp = e;
                }
            }
            temp.setHp(temp.getHp() + 1);
        }
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Devour.png").toString());
    }
}
