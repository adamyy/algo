package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NextPermutationTest {

  @Test
  public void nextPermutation() {
    NextPermutation solution = new NextPermutation();
    assertThat(solution.nextPermutation(new int[]{1,2,3})).isEqualTo(new int[]{1,3,2});
    assertThat(solution.nextPermutation(new int[]{3,2,1})).isEqualTo(new int[]{1,2,3});
    assertThat(solution.nextPermutation(new int[]{1,3,2})).isEqualTo(new int[]{2,1,3});
    assertThat(solution.nextPermutation(new int[]{1,1,5})).isEqualTo(new int[]{1,5,1});
    assertThat(solution.nextPermutation(new int[]{1,2,3,4})).isEqualTo(new int[]{1,2,4,3});
    assertThat(solution.nextPermutation(new int[]{4,3,2,1})).isEqualTo(new int[]{1,2,3,4});
  }
}