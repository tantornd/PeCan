package card.CharacterCard;

import game.Buff;
import game.GameLogic;
import game.WeaponType;
import javafx.scene.image.Image;

public class BardCard extends BaseCharacterCard {
    public BardCard() {
        super(WeaponType.GRIMOIRE, 1);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()){
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(getEnergy() + 1);
            game.getBuff().set(game.getCurrentPlayer(), new Buff(2,1));
            game.nextPlayerTurn();
        }
    }

    @Override
    public void useUltimate() {
        if (canUseUltimate()){
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(0);
            game.getBuff().set(game.getCurrentPlayer(), new Buff(2,2));
            game.nextPlayerTurn();
        }
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("bardCard.png").toString());
    }
}
