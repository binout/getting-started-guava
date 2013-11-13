package net.binout.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Player implements Comparable<Player> {

    String firstName;
    String lastName;
    int age;
    int number;

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Player setAge(int age) {
        this.age = age;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Player setNumber(int number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("firstName", firstName)
                .add("lastName", lastName).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName);
    }

    @Override
    public int compareTo(Player p) {
        return ComparisonChain.start()
                .compare(firstName, p.getFirstName())
                .compare(lastName, p.getLastName())
                .result();
    }
}
