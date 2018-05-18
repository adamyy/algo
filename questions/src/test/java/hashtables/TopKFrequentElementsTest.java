package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TopKFrequentElementsTest {

  @Test
  public void topKFrequent() {
    assertThat(TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))
        .containsExactly(1, 2);
  }
}