package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;

public class MageCard extends BaseCharacterCard{
    public MageCard() {
        super(WeaponType.GRIMOIRE, 2);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()){
            GameLogic game = GameLogic.getInstance();
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 3);
            setEnergy(getEnergy() + 1);
            for (BaseCharacterCard e : game.getOpponentChar()) {
                e.takeDamage(1);
            }
            game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack);
            game.nextPlayerTurn();
        }
    }

    @Override
    public void useUltimate() {
        GameLogic game = GameLogic.getInstance();
        if (canUseUltimate()) {
            game.useDice(3);
            setEnergy(0);
            for (BaseCharacterCard e : game.getOpponentChar()) {
                e.takeDamage(baseAttack + 1);
            }
            game.nextPlayerTurn();
        }
    }
}
