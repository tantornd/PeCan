package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;

public class AssassinCard extends BaseCharacterCard {
    public AssassinCard() {
        super(WeaponType.SWORD, 2);
    }

    @Override
    public void useSkill() {
        GameLogic game = GameLogic.getInstance();
        if (canUseSkill()) {
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 3);
            setEnergy(getEnergy() + 1);
            if (game.getActiveChara(game.getOpponentChar()).getHp() <= 3) {
                game.getCharacterCards().get((game.getCurrentPlayer() + 1) % 2)
                        .remove(game.getActiveChara(game.getOpponentChar()));
            }
            else{
                game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack + 1);
                game.nextPlayerTurn();
            }
        }
    }

    @Override
    public void useUltimate() {
        GameLogic game = GameLogic.getInstance();
        if (canUseUltimate()) {
            game.setDice(game.getCurrentPlayer(), game.getDice().get(game.getCurrentPlayer()) - 3);
            setEnergy(0);
            for (BaseCharacterCard e : game.getOpponentChar()) {
                e.takeDamage(baseAttack + 1);
            }
            game.nextPlayerTurn();
        }
    }
}
