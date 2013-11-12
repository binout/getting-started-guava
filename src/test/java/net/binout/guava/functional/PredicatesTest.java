package net.binout.guava.functional;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.binout.guava.Player;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicatesTest {

    Predicate<Player> isMinor = new Predicate<Player>() {
        @Override
        public boolean apply(Player player) {
            return player.getAge() < 18;
        }
    };
    Predicate<Player> isMidfield = new Predicate<Player>() {
        @Override
        public boolean apply(Player player) {
            int number = player.getNumber();
            return (number == 10) || (number == 7) || (number == 6) || (number == 8);
        }
    };

    @Test
    public void predicate() {
        Player p = new Player();
        p.setAge(16);

        assertThat(isMinor.apply(p)).isTrue();
    }

    @Test
    public void predicates() {
        Predicate<Player> minorAndMidfield = Predicates.and(isMinor, isMidfield);

        Player p = new Player();
        p.setAge(16);
        p.setNumber(10);

        assertThat(minorAndMidfield.apply(p)).isTrue();
    }
}
