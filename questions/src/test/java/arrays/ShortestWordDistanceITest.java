package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ShortestWordDistanceITest {

  @Test
  public void shortestWordDistance() {
    String[] words = { "practice", "makes", "perfect", "coding", "makes"};
    assertThat(ShortestWordDistanceI.shortestWordDistanceI(words, "coding", "practice")).isEqualTo(3);
    assertThat(ShortestWordDistanceI.shortestWordDistanceI(words, "makes", "coding")).isEqualTo(1);
  }
}