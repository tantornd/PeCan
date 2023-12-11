package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;

public class KnightCard extends BaseCharacterCard {
    public KnightCard() {
        super(WeaponType.SWORD, 3);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()) {
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(getEnergy() + 1);
            game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack+1);
            game.nextPlayerTurn();
        }
    }

    @Override
    public void useUltimate() {
        if (canUseUltimate()) {
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(0);
            game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack + 4);
            game.nextPlayerTurn();
        }
    }
}