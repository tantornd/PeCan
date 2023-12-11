package card.SupportCard.food.shielding;

import card.SupportCard.food.shielding.ShieldingFood;
import javafx.scene.image.Image;

public class SpringRolls extends ShieldingFood {
    public SpringRolls(){
        super(0,1);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("SpringRolls.png").toString());
    }
}
