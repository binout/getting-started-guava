package net.binout.guava.collections;

import com.google.common.collect.Lists;
import net.binout.guava.Player;
import net.binout.guava.Players;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListsTest {

    @Test
    public void partitions() {
        Player olivier = Players.olivierAtton();
        Player ben = Players.benBecker();
        List<Player> players = Lists.newArrayList(
                olivier, ben,
                Players.jamesDerrick(), Players.jasonDerrick(),
                Players.edWarner(), Players.julianRoss(),
                Players.markLanders());
        List<List<Player>> partitions = Lists.partition(players, 2);
        assertThat(partitions.get(0)).contains(olivier).contains(ben);
    }
}
