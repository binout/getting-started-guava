package net.binout.guava.basic;

import com.google.common.base.Splitter;
import org.assertj.core.data.MapEntry;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @Test
    public void splitter_with_trim() {
        List<String> results = Splitter.on(",").trimResults().splitToList("Muppet, New Team, Flynet");
        assertThat(results).hasSize(3).contains("Muppet", "New Team", "Flynet");
    }

    @Test
    public void splitter_omit_empty() {
        List<String> results = Splitter.on(",").omitEmptyStrings().splitToList("Muppet,New Team,,");
        assertThat(results).hasSize(2).contains("Muppet", "New Team");
    }

    @Test
    public void map_splitter() {
        Map<String,String> resultMap = Splitter.on(",").withKeyValueSeparator("#").split("MP#Muppet,NT#New Team,FL#Flynet");
        assertThat(resultMap).hasSize(3)
                .contains(MapEntry.entry("MP", "Muppet"))
                .contains(MapEntry.entry("NT", "New Team"))
                .contains(MapEntry.entry("FL", "Flynet"));
    }

}
