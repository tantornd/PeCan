package card.SupportCard.weapons;

import card.CharacterCard.BaseCharacterCard;
import game.GameLogic;
import game.WeaponType;
import javafx.scene.image.Image;

public class GrimoireCard extends WeaponCard{
    public GrimoireCard() {super();}

    @Override
    public void play() {
        GameLogic game = GameLogic.getInstance();
        if (isPlayable()) {
            for (BaseCharacterCard e : game.getCharacterCards().get(game.getCurrentPlayer())) {
                if (e.getWeaponType() == WeaponType.GRIMOIRE) {
                    e.setBaseAttack(e.getBaseAttack() + 1);
                    game.getPlayerHands().get(game.getCurrentPlayer()).remove(this);
                    game.useDice(getCost());
                    return;
                }
            }
        }
    }

    @Override
    public boolean isPlayable() {
        GameLogic game = GameLogic.getInstance();
        if (game.getDice().get(game.getCurrentPlayer()) < getCost()) return false;
        for (BaseCharacterCard e: game.getCharacterCards().get(game.getCurrentPlayer())){
            if (e.getWeaponType() == WeaponType.GRIMOIRE) return true;
        }
        return false;
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Grimoire.png").toString());
    }
}
