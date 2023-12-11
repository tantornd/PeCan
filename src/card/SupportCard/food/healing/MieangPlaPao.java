package card.SupportCard.food.healing;

import card.SupportCard.food.healing.HealingFood;
import javafx.scene.image.Image;

public class MieangPlaPao extends HealingFood {
    public MieangPlaPao() {
        super(2, 3);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("MieangPlaPao.png").toString());
    }
}
