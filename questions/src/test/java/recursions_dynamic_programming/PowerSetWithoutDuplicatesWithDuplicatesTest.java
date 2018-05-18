package recursions_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class PowerSetWithoutDuplicatesWithDuplicatesTest {

  @Test
  public void subsetWithDup() {
    assertThat(PowerSetWithDuplicates.subsetWithDup(Arrays.asList(1, 2, 2)))
        .containsExactly(
            Arrays.asList(),
            Arrays.asList(2),
            Arrays.asList(1),
            Arrays.asList(1, 2, 2),
            Arrays.asList(2, 2),
            Arrays.asList(1, 2)
        );
  }
}