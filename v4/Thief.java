public class Thief extends Monster {
    public Thief() {
        super();
        _hp = _hp - 20;
        _attack = _attack + 0.2;
    }

    public static String about() {
        return "the thief has high attack but low health";
    }
}

