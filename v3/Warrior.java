public class Warrior extends Protagonist {
    public Warrior() {
        super();
        _strength = _strength + 20;
        _defense = _defense + 20;
    }

    public Warrior(String name) {
        super(name);
        _strength = _strength + 20;
        _defense = _defense + 20;
    }

    public static String about() {
        return "the warrior has increased strength and defense";
    }
}
