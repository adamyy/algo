package array;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class HugeIntMultiplicationTest {

  @Test
  public void multiply() {
    List<Integer> x = Arrays.asList(1, 9, 3, 7, 0, 7, 7, 2, 1);
    List<Integer> y = Arrays.asList(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7);
    assertThat(HugeIntMultiplication.multiply(x, y))
        .containsExactlyElementsIn(
            Arrays.asList(-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7)
        );
  }
}