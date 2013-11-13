package net.binout.guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest {

    @Test
    public void apply() {
        String formatDate = new Function<Date, String>() {
            @Override
            public String apply(Date date) {
                return new SimpleDateFormat("dd/MM/yyyy").format(date);
            }
        }.apply(new Date(0));
        assertThat(formatDate).isEqualTo("01/01/1970");
    }

    @Test
    public void forMap() {
        Map<Integer, String> map = Maps.newLinkedHashMap();
        map.put(10, "Olivier Atton");
        map.put(1, "Thomas Price");
        assertThat(Functions.forMap(map).apply(1)).isEqualTo("Thomas Price");
    }

    @Test
    public void compose() {
        Map<String, Integer> players = Maps.newLinkedHashMap();
        players.put( "Olivier Atton", 10);
        players.put("Ed Warner", 1);
        Function<String, Integer> playersFunction = Functions.forMap(players);

        Map<String, String> teams = Maps.newLinkedHashMap();
        teams.put("New Team", "Olivier Atton");
        teams.put("Muppet", "Ed Warner");
        Function<String, String> teamsFunction = Functions.forMap(teams);

        assertThat(Functions.compose(playersFunction, teamsFunction).apply("New Team")).isEqualTo(10);
    }
}
