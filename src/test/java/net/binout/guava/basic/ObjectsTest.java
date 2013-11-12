package net.binout.guava.basic;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import net.binout.guava.Player;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectsTest {

    @Test
    public void to_String() {
        Player p = newPlayer("Olivier", "Atton");
        assertThat(p.toString()).isEqualTo("Player{firstName=Olivier, lastName=Atton}");
    }

    @Test
    public void first_non_null() {
        assertThat(Objects.firstNonNull(null, "default")).isEqualTo("default");
    }

    @Test
    public void hash_code() {
        Player p = newPlayer("Olivier", "Atton");
        assertThat(p.hashCode()).isEqualTo(491078325);
    }

    @Test
    public void commpareTo() {
        Set<Player> set = Sets.newTreeSet();
        set.add(newPlayer("James", "Derrick"));
        set.add(newPlayer("Jason", "Derrick"));
        set.add(newPlayer("James", "Derrick"));

        assertThat(set).hasSize(2);
    }

    private Player newPlayer(String firstName, String lastName) {
        Player p = new Player();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        return p;
    }
}
