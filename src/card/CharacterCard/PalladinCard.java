package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;
import javafx.scene.image.Image;

public class PalladinCard extends BaseCharacterCard {
    public PalladinCard() {
        super(WeaponType.SWORD, 3);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()) {
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(getEnergy() + 1);
            setShield(3);
            game.nextPlayerTurn();
        }
    }

    @Override
    public void useUltimate() {
        if (canUseUltimate()){
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(0);
            for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
                e.setShield(e.getShield() + 3);
            }
            game.nextPlayerTurn();
        }
    }
    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("palladinCard.png").toString());
    }
}
