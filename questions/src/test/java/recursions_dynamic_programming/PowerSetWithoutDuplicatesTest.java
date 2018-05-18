package recursions_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.*;

public class PowerSetWithoutDuplicatesTest {

  @Test
  public void getSubsets() {
    assertThat(PowerSetWithoutDuplicates.getSubsets(Arrays.asList(1, 2, 3))).containsExactly(
        Collections.emptyList(),
        Arrays.asList(1),
        Arrays.asList(2),
        Arrays.asList(3),
        Arrays.asList(1, 2),
        Arrays.asList(1, 3),
        Arrays.asList(2, 3),
        Arrays.asList(1, 2, 3)
    );
  }
}