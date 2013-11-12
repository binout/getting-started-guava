package net.binout.guava.functional;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import net.binout.guava.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuppliersTest {

    @Test
    public void suppplier() {
        Supplier<Predicate<Player>> isOffensiveSupplier = new Supplier<Predicate<Player>>() {
            @Override
            public Predicate<Player> get() {
                Predicate<Player> isForward = new Predicate<Player>() {
                    @Override
                    public boolean apply(Player player) {
                        int number = player.getNumber();
                        return (number == 11) || (number == 9);
                    }
                };
                Predicate<Player> isMidfield = new Predicate<Player>() {
                    @Override
                    public boolean apply(Player player) {
                        int number = player.getNumber();
                        return (number == 10) || (number == 7) || (number == 6) || (number == 8);
                    }
                };
                return Predicates.or(isMidfield, isForward);
            }
        };
        Player p = new Player();
        p.setNumber(2);
        assertThat(isOffensiveSupplier.get().apply(p)).isFalse();
    }
}
