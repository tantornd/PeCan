package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;

public class PalladinCard extends BaseCharacterCard {
    public PalladinCard() {
        super(WeaponType.SWORD, 3);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()) {
            GameLogic game = GameLogic.getInstance();
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 3);
            setEnergy(getEnergy() + 1);
            setShield(3);
            game.nextPlayerTurn();
        }
    }

    @Override
    public void useUltimate() {
        if (canUseUltimate()){
            GameLogic game = GameLogic.getInstance();
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 3);
            setEnergy(0);
            for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
                e.setShield(e.getShield() + 3);
            }
            game.nextPlayerTurn();
        }
    }
}
