package card.CharacterCard;

import game.GameLogic;
import game.WeaponType;
import javafx.scene.image.Image;

public class AssassinCard extends BaseCharacterCard {
    public AssassinCard() {
        super(WeaponType.SWORD, 2);
    }

    @Override
    public void useSkill() {
        GameLogic game = GameLogic.getInstance();
        if (canUseSkill()) {
            game.useDice(3);
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
            game.useDice(3);
            setEnergy(0);
            for (BaseCharacterCard e : game.getOpponentChar()) {
                e.takeDamage(baseAttack + 1);
            }
            game.nextPlayerTurn();
        }
    }
    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("assasinCard.png").toString());
    }
}
