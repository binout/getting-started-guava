package net.binout.guava.collections;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetsTest {
    
    @Test
    public void difference() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3, 4);
        assertThat(Sets.difference(s1, s2)).hasSize(1).contains(1);
        assertThat(Sets.difference(s2, s1)).hasSize(1).contains(4);
    }

    @Test
    public void symetric_difference() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3, 4);
        assertThat(Sets.symmetricDifference(s1, s2)).hasSize(2).contains(1).contains(4);
    }

    @Test
    public void intersection() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3, 4);
        assertThat(Sets.intersection(s1, s2)).hasSize(2).contains(2).contains(3);
    }

    @Test
    public void union() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3, 4);
        assertThat(Sets.union(s1, s2)).hasSize(4).contains(1).contains(2).contains(3).contains(4);
    }
}
