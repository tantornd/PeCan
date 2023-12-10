package card.SupportCard.weapons;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import card.SupportCard.TargetSelectable;
import game.GameLogic;

public abstract class WeaponCard extends BaseSupportCard implements TargetSelectable {
    public WeaponCard() {
        super(2);
    }
    @Override
    public abstract void play();

    @Override
    public abstract boolean isPlayable();

    @Override
    public void selectTarget() {

    }
}
