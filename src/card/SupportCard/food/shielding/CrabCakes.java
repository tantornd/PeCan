package card.SupportCard.food.shielding;

import javafx.scene.image.Image;

public class CrabCakes extends ShieldingFood {
    public CrabCakes(){
        super(2, 3);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("CrabCakes.png").toString());
    }
}
