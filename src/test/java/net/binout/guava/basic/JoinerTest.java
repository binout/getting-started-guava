package net.binout.guava.basic;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinerTest {
    
    @Test
    public void joiner_skipNulls() {
        String join = Joiner.on(";").skipNulls().join("Muppet", null, "New Team", "Flynet");
        assertThat(join).isEqualTo("Muppet;New Team;Flynet");
    }

    @Test
    public void joiner_useForNull() {
        String join = Joiner.on(";").useForNull("NONE").join("Muppet", null, "New Team", "Flynet");
        assertThat(join).isEqualTo("Muppet;NONE;New Team;Flynet");
    }

    @Test
    public void map_joiner() {
        Map map = Maps.newLinkedHashMap();
        map.put("MP", "Muppet");
        map.put("NT", "New Team");
        map.put("FL", "Flynet");
        String join = Joiner.on(";").withKeyValueSeparator("#").join(map);
        assertThat(join).isEqualTo("MP#Muppet;NT#New Team;FL#Flynet");
    }

    @Test
    public void join_appendable() throws IOException {
        Appendable writer = new StringWriter();
        Appendable appendable = Joiner.on(";").appendTo(writer, "Muppet", "New Team", "Flynet");
        assertThat(appendable.toString()).isEqualTo("Muppet;New Team;Flynet");
    }
}
