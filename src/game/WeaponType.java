package game;

public enum WeaponType {
    BOW,
    SWORD,
    GRIMOIRE;

    @Overridetr
        public String toString() {
            return super.toSing();
    }
}
