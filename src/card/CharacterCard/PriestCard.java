package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;
import javafx.scene.image.Image;

public class PriestCard extends BaseCharacterCard {

    public PriestCard() {
        super(WeaponType.GRIMOIRE, 1);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()) {
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(getEnergy() + 1);
            BaseCharacterCard temp = game.getCharacterCards().get(game.getCurrentPlayer()).get(0);
            for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
                if (e.getHp() < temp.getHp()){
                    temp = e;
                }
            }
            temp.setHp(getHp() + 2);
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
                e.setHp(e.getHp() + 3);
            }
            game.nextPlayerTurn();
        }
    }
    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("priestCard.png").toString());
    }
}
