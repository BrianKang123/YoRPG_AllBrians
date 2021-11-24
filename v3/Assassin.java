public class Assassin extends Monster {
    public Assassin() {
        super();
        _strength = _strength + 20;
        _hp = _hp - 20;
        _attack = _attack + 0.2;
    }

    public static String about() {
        return "the assassin class has high strength and high attack but low health";
    }
}
