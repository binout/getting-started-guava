package net.binout.guava.collections;

import com.google.common.base.Function;
import com.google.common.collect.*;
import net.binout.guava.Player;
import net.binout.guava.Players;
import org.assertj.core.data.MapEntry;
import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MapsTest {

    @Test
    public void unique_index() {
        Player ed = Players.edWarner();
        List<Player> muppetPlayers = Lists.newArrayList(ed, Players.markLanders(), Players.jamesDerrick(), Players.jasonDerrick());
        ImmutableMap<Integer,Player> playersByNumber = Maps.uniqueIndex(muppetPlayers, new Function<Player, Integer>() {
            @Override
            public Integer apply(Player player) {
                return player.getNumber();
            }
        });
        assertThat(playersByNumber).hasSize(4).contains(MapEntry.entry(1, ed));
    }

    @Test
    public void as_map() {
        Set<Integer> numbers = Sets.newLinkedHashSet(1,2,3,4,5,6,7,8,9,10,11);
        Map<Integer,String> positions = Maps.asMap(numbers, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                if (integer == 1) return "GoalKeeper";
                if (integer >= 2 && integer <= 5) return "Defender";
                if (integer >= 6 && integer <= 8) return "Midfield";
                if (integer == 10) return "Midfield";
                if (integer == 9 || integer == 11) return "Forward";
                return null;
            }
        });
        assertThat(positions).hasSize(11);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void to_map() {
        Set<Integer> numbers = Sets.newLinkedHashSet(1,2,3,4,5,6,7,8,9,10,11);
        Map<Integer,String> immutablePositions = Maps.toMap(numbers, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                if (integer == 1) return "GoalKeeper";
                if (integer >= 2 && integer <= 5) return "Defender";
                if (integer >= 6 && integer <= 8) return "Midfield";
                if (integer == 10) return "Midfield";
                if (integer == 9 || integer == 11) return "Forward";
                return null;
            }
        });
        immutablePositions.put(0, "Referee");
    }

    @Test
    public void multimap() {
        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        multimap.put(1, "Foo");
        multimap.put(1, "Bar");
        multimap.put(1, "Qiz");
        multimap.put(2, "Fez");

        assertThat(multimap.get(1)).hasSize(3).contains("Foo").contains("Bar").contains("Qiz");
        assertThat(multimap.size()).isEqualTo(4);
        assertThat(multimap.values()).hasSize(4).contains("Foo").contains("Bar").contains("Qiz").contains("Fez");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bimap() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "Foo");
        biMap.put(2, "Foo");
    }

    @Test
    public void bimap_forcePut() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "Foo");
        biMap.forcePut(2, "Foo");
        assertThat(biMap).hasSize(1).contains(MapEntry.entry(2, "Foo"));
    }

    @Test
    public void bimap_inverse() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "Foo");
        biMap.put(2, "Bar");
        assertThat(biMap.inverse()).hasSize(2).contains(MapEntry.entry("Foo", 1)).contains(MapEntry.entry("Bar", 2));
    }
}
