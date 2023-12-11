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

        //TODO: SELECT TARGETS THAT CAN EQUIP THIS WEAPON (ON CLICK EVENT)
        //TODO: HANDLE IF TARGET"S WEAPON TYPE DOESN'T MATCH

    }
}
