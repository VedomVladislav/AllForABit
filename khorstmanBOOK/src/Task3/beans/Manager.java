package Task3.beans;

import java.util.Objects;

public class Manager extends  Employee {

    private int bonus;

    public Manager(String name, int age, String address) {
        super(name, age, address);
        bonus = 0;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return bonus == manager.bonus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonus=" + bonus +
                '}';
    }

}
