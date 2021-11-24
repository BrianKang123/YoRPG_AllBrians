public class Paladin extends Monster {
    public Paladin() {
        super();
        _attack = _attack + 0.15;
        _defense = _defense + 15;
    }

    public static String about() {
        return "the paladin has slightly increased attack and defense";
    }
}
