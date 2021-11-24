public class Barbarian extends Protagonist {
    public Barbarian() {
        super();
        _strength = _strength + 20;
        _hp = _hp + 20;
        _attack = _attack - 0.2;
    }

    public Barbarian(String name) {
        super(name);
        _strength = _strength + 20;
        _hp = _hp + 20;
        _attack = _attack - 0.2;
    }

    public static String about() {
        return "the barbarian has increased strength and health but lowered attack";
    }
}
