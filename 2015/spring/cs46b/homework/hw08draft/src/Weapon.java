public class Weapon
{
    private double Damage;
    private double AttackSpeed;
    private double MissChance;

    public Weapon(double NewDamage, double NewAttackSpeed, double NewMissChance)
    {
        Damage = NewDamage;
        AttackSpeed = NewAttackSpeed;
        MissChance = NewMissChance;
    }

    public double getDamage() { return Damage; }
    public void setDamage(double damage) { Damage = damage; }
    public double getAttackSpeed() { return AttackSpeed; }
    public void setAttackSpeed(double attackSpeed) { AttackSpeed = attackSpeed; }
    public double getMissChance() { return MissChance; }
    public void setMissChance(double missChance) { MissChance = missChance; }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;

        result *= (getDamage() * prime);
        result *= (getAttackSpeed() * prime);
        result *= (getMissChance() * prime);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null) {
            // Testing for reflexive relation
            if (this == obj) return true;

            // Testing class symmetry
            if (this.getClass() != obj.getClass()) return false;

            Weapon other = (Weapon) obj;

            // Testing member relationships
            if (this.getAttackSpeed() == other.getAttackSpeed())
                if (this.getDamage() == other.getDamage())
                    if (this.getMissChance() == other.getMissChance())
                        return true;

        }

        return false;
    }
}
