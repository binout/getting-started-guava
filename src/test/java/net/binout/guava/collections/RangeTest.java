package net.binout.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import net.binout.guava.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeTest {

    @Test
    public void open() {
        Range<Integer> range = Range.open(1,10);
        assertThat(range.contains(1)).isFalse();
        assertThat(range.contains(5)).isTrue();
        assertThat(range.contains(10)).isFalse();
    }

    @Test
    public void closed() {
        Range<Integer> range = Range.closed(1, 10);
        assertThat(range.contains(1)).isTrue();
        assertThat(range.contains(5)).isTrue();
        assertThat(range.contains(10)).isTrue();
    }

    @Test
    public void compose_range() {
        Player tit = new Player().setNumber(10);
        Player sub = new Player().setNumber(12);
        Predicate<Player> isTit = Predicates.compose(Range.closed(1, 11), new Function<Player, Integer>() {
            @Override
            public Integer apply(Player p) {
                return p.getNumber();
            }
        });
        Iterable<Player> titPlayers = FluentIterable.from(Lists.newArrayList(tit, sub)).filter(isTit);
        assertThat(titPlayers).hasSize(1).contains(tit);
    }
}
