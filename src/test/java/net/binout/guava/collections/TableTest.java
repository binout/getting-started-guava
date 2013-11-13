package net.binout.guava.collections;

import com.google.common.collect.HashBasedTable;
import org.assertj.core.data.MapEntry;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    @Test
    public void hash_based_table() {
        HashBasedTable<Integer, Integer, String> matrix = HashBasedTable.create();
        matrix.put(1,1,"A1");
        matrix.put(1,2,"A2");
        matrix.put(2,1,"B1");
        matrix.put(2,2,"B2");

        assertThat(matrix.contains(1, 1)).isTrue();
        assertThat(matrix.containsRow(2)).isTrue();
        assertThat(matrix.containsColumn(1)).isTrue();
        assertThat(matrix.containsValue("A2")).isTrue();

        assertThat(matrix.row(1)).hasSize(2).contains(MapEntry.entry(1,"A1")).contains(MapEntry.entry(2, "A2"));
        assertThat(matrix.column(2)).hasSize(2).contains(MapEntry.entry(1,"A2")).contains(MapEntry.entry(2, "B2"));

    }
}
