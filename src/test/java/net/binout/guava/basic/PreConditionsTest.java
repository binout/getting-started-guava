package net.binout.guava.basic;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreConditionsTest {

    @Test(expected = NullPointerException.class)
    public void checkNotNullOrEmpty() {
        Preconditions.checkNotNull(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkArgument() {
        Preconditions.checkArgument(3 > 10, "3 is superior to 10");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkPositionIndex() {
        Preconditions.checkPositionIndex(5, 3);
    }
}
