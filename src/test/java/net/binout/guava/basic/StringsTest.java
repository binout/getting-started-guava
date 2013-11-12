package net.binout.guava.basic;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsTest {

    @Test
    public void charset() {
        String name = "つばさ";
        assertThat(name.getBytes(Charsets.UTF_16)).isNotEqualTo(name.getBytes());
    }

    @Test
    public void pad() {
        assertThat(Strings.padEnd("goal", 10, '!')).isEqualTo("goal!!!!!!");
    }

    @Test
    public void charmatcher() {
        assertThat(CharMatcher.WHITESPACE.collapseFrom("There is some      space", ' ')).isEqualTo("There is some space");
    }
}
