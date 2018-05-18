package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TripleStepTest {

  @Test
  public void tripleStep() {
    assertThat(TripleStep.tripleStep(3)).isEqualTo(4);
  }
}