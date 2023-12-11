package card.CharacterCard;

import game.Buff;
import game.CarryOnDamage;
import game.GameLogic;
import game.WeaponType;

public class FlameArcherCard extends BaseCharacterCard{
    public FlameArcherCard() {
        super(WeaponType.BOW, 2);
    }

    @Override
    public void useSkill() {
        if (canUseSkill()){
            GameLogic game = GameLogic.getInstance();
            game.useDice(3);
            setEnergy(getEnergy() + 1);
            game.getActiveChara(game.getOpponentChar()).takeDamage(baseAttack);
            game.getCarryOnDamage().set(game.getCurrentPlayer(), new CarryOnDamage(2, 1, false));
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
                e.takeDamage(baseAttack);
            }
            game.getCarryOnDamage().set(game.getCurrentPlayer(), new CarryOnDamage(2, 1, true));
            game.nextPlayerTurn();
        }
    }
}
