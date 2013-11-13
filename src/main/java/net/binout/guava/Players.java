package net.binout.guava;

public class Players {

    private static Player newPlayer(String firstName, String lastName) {
        Player p = new Player();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        return p;
    }

    public static Player olivierAtton() {
        return newPlayer("Olivier", "Atton").setNumber(10);
    }

    public static Player benBecker() {
        return newPlayer("Ben", "Becker").setNumber(7);
    }

    public static Player markLanders() {
        return newPlayer("Mark", "Landers").setNumber(10);
    }

    public static Player julianRoss() {
        return newPlayer("Julian", "Ross").setNumber(10);
    }

    public static Player jamesDerrick() {
        return newPlayer("James", "Derrick").setNumber(7);
    }

    public static Player jasonDerrick() {
        return newPlayer("Jason", "Derrick").setNumber(11);
    }

    public static Player edWarner() {
        return newPlayer("Ed", "Warner").setNumber(1);
    }
}
