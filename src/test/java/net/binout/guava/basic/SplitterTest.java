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
        List<String> results = Splitter.on(",").trimResults().splitToList("PSG, OM, FCGB");
        assertThat(results).contains("PSG", "OM", "FCGB").hasSize(3);
    }

    @Test
    public void splitter_omit_empty() {
        List<String> results = Splitter.on(",").omitEmptyStrings().splitToList("PSG,OM,,");
        assertThat(results).contains("PSG", "OM").hasSize(2);
    }

    @Test
    public void map_splitter() {
        Map<String,String> resultMap = Splitter.on(".").withKeyValueSeparator("#").split("Paris#PSG.Marseille#OM.Bordeaux#FCGB");
        assertThat(resultMap).contains(MapEntry.entry("Paris", "PSG")).contains(MapEntry.entry("Marseille", "OM")).contains(MapEntry.entry("Bordeaux", "FCGB"));
    }

}
