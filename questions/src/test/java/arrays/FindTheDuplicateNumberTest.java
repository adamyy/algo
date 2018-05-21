package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FindTheDuplicateNumberTest {

  @Test
  public void findDuplicate() {
    assertThat(FindTheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
    assertThat(FindTheDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
  }
}