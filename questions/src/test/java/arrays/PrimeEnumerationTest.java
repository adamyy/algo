package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PrimeEnumerationTest {

  @Test
  public void primes() {
    assertThat(PrimeEnumeration.primes(18))
        .containsExactly(2, 3, 5, 7, 11, 13, 17);
  }
}