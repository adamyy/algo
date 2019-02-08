package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestAbsolutePathTest {

  @Test
  public void max() {
    assertThat(LongestAbsolutePath.max("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
        .isEqualTo(20);
    assertThat(LongestAbsolutePath.max("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
        .isEqualTo(32);
    assertThat(LongestAbsolutePath.max("file1.ext"))
        .isEqualTo(9);
    assertThat(LongestAbsolutePath.max("dir\n\tfile1.ext"))
        .isEqualTo(13);
    assertThat(LongestAbsolutePath.max("0\n\t23.567\n12345.789"))
        .isEqualTo(9);
    assertThat(LongestAbsolutePath.max("dir\n\tfile1.ext\n\tsubdir\n\t\tsubsubdir\n\t\t\ttsubsubsubdir"))
        .isEqualTo(13);
    assertThat(LongestAbsolutePath.max("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        + "\ndir2\n\tsubdir1\n\tsubdir2\n\t\tsubsubdir1\n\t\t\tsubsubsubdir3\n\t\t\t\tfile3.ext"))
        .isEqualTo(47);
  }
}