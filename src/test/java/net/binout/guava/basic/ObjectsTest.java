package net.binout.guava.basic;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import net.binout.guava.Player;
import net.binout.guava.Players;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectsTest {

    @Test
    public void to_String() {
        Player p = Players.olivierAtton();
        assertThat(p.toString()).isEqualTo("Player{firstName=Olivier, lastName=Atton}");
    }

    @Test
    public void first_non_null() {
        assertThat(Objects.firstNonNull(null, "default")).isEqualTo("default");
    }

    @Test
    public void hash_code() {
        Player p = Players.olivierAtton();
        assertThat(p.hashCode()).isEqualTo(491078325);
    }

    @Test
    public void commpareTo() {
        Set<Player> set = Sets.newTreeSet();
        set.add(Players.jamesDerrick());
        set.add(Players.jasonDerrick());
        set.add(Players.jamesDerrick());

        assertThat(set).hasSize(2);
    }


}
