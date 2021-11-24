public class Protagonist extends Character {
    private String _name;

    public Protagonist() {
        _hp = 125;
        _strength = 100;
        _defense = 40;
        _attack = .4;
    }

    public Protagonist(String name) {
        this();
        _name = name;
    }

    public void specialize() {
        _attack = .75;
        _defense = 20;
    }

    public void normalize() {
        _attack = .4;
        _defense = 40;
    }

    public String getName() {
        return _name;
    }
}
