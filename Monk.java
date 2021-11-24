public class Monk extends Protagonist {
    public Monk() {
        super();
        _attack = _attack + .2;
        _hp = _hp - 30;
    }

    public Monk(String name) {
        super(name);
        _attack = _attack + .2;
        _hp = _hp - 30;
    }

    public static String about() {
        return "the monk has increased attack but lowered health";
    }
}
