package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SearchRotatedSortedArrayTest {

  @Test
  public void search() {
    assertThat(SearchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0))
        .isEqualTo(4);
    assertThat(SearchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3))
        .isEqualTo(-1);
    assertThat(SearchRotatedSortedArray.search(new int[]{3, 5, 1}, 3))
        .isEqualTo(0);
    assertThat(SearchRotatedSortedArray.search(new int[]{1, 3}, 0))
        .isEqualTo(-1);
    assertThat(SearchRotatedSortedArray.search(new int[]{1, 3}, 3))
        .isEqualTo(1);
    assertThat(SearchRotatedSortedArray.search(new int[]{}, 5))
        .isEqualTo(-1);
  }
}