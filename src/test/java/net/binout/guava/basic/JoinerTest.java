package net.binout.guava.basic;

import com.google.common.base.Joiner;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinerTest {
    
    @Test
    public void joiner_skipNulls() {
        String join = Joiner.on(";").skipNulls().join("PSG", null, "OM", "FCGB");
        assertThat(join).isEqualTo("PSG;OM;FCGB");
    }

    @Test
    public void joiner_useForNull() {
        String join = Joiner.on(";").useForNull("NONE").join("PSG", null, "OM", "FCGB");
        assertThat(join).isEqualTo("PSG;NONE;OM;FCGB");
    }
}
