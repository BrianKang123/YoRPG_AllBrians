public class Character{
  protected int _hp = 100;
  protected int _strength = 20;
  protected int _defense = 10;
  protected double _attack = 0.9;
  protected boolean _specialized = false;

  // public Character (int hp, int strength, int defense, double attack){
  //   _hp = hp;
  //   _strength = strength;
  //   _defense = defense;
  //   _attack = attack;
  // }

  public boolean isAlive() {
    return _hp > 0;
  }

  public int getDefense() {
    return _defense;
  }

  public boolean getSpecialized(){
    return _specialized;
  }

  public void lowerHP(int dmg) {
    _hp = _hp - dmg;
  }

  public int attack(Character enemy) {
    int damage = (int)((_strength * _attack) - enemy.getDefense());
    if(enemy.getSpecialized() == true){
      damage *= 2;
    }
    enemy.lowerHP(damage);
    return damage;
  }
}
