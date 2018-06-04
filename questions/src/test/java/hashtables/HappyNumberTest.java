package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class HappyNumberTest {

  @Test
  public void isHappy() {
    assertThat(HappyNumber.isHappy(19)).isTrue();
  }

  @Test
  public void isHappyConstantSpace() {
    assertThat(HappyNumber.isHappyConstantSpace(19)).isTrue();
  }
}