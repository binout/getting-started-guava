package net.binout.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Player implements Comparable<Player> {

    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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