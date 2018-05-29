package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PartialEqualSubsetSumTest {

  @Test
  public void canPartition() {
    assertThat(PartialEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5})).isTrue();
    assertThat(PartialEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5})).isFalse();
  }

  @Test
  public void canPartitionExplained() {
    assertThat(PartialEqualSubsetSum.canPartitionExplained(new int[]{1, 5, 11, 5})).isTrue();
    assertThat(PartialEqualSubsetSum.canPartitionExplained(new int[]{1, 2, 3, 5})).isFalse();
  }
}