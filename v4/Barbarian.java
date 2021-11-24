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

    public void specialize() {
        _attack = 0.7;
        _defense = 45;
    }

    public void normalize() {
        _attack = 0.55;
        _defense = 55;
    }

    public static String about() {
        return "the barbarian has increased strength and health but lowered attack";
    }
}
