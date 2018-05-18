package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MajorityElementTest {

  @Test
  public void majorityElement() {
    assertThat(MajorityElement.majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
    assertThat(MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
  }
}