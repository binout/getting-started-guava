package net.binout.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.binout.guava.Player;
import net.binout.guava.Players;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentIterableTest {

    @Test
    public void filter() {
        Player edWarner = Players.edWarner();
        Iterable<Player> players = Lists.newArrayList(Players.olivierAtton(), Players.jamesDerrick(), edWarner);

        FluentIterable<Player> goalKeepers = FluentIterable.from(players).filter(new Predicate<Player>() {
            @Override
            public boolean apply(Player player) {
                return player.getNumber() == 1;
            }
        });
        assertThat(goalKeepers).hasSize(1).contains(edWarner);
    }

    @Test
    public void transform() {
        Iterable<Player> players = Lists.newArrayList(Players.olivierAtton(), Players.jamesDerrick(), Players.edWarner());
        ImmutableList<String> toStringList = FluentIterable.from(players).transform(new Function<Player, String>() {
            @Override
            public String apply(Player player) {
                return Joiner.on(";").join(player.getFirstName(), player.getLastName());
            }
        }).toList();
        assertThat(toStringList).hasSize(3).contains("Olivier;Atton").contains("James;Derrick").contains("Ed;Warner");
    }

}
