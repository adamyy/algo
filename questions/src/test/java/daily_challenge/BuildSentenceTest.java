package daily_challenge;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class BuildSentenceTest {

  @Test
  public void build() {
    assertThat(BuildSentence.build(Arrays.asList(), "a")).isEmpty();
    assertThat(BuildSentence.build(Arrays.asList("quick", "brown", "the", "fox"), "thequickbrownfox"))
        .containsExactly("the", "quick", "brown", "fox");
    assertThat(BuildSentence.build(Arrays.asList("bed", "bath", "bedbath", "and", "beyond"), "bedbathandbeyond"))
        .containsExactly("bed", "bath", "and", "beyond");
    assertThat(BuildSentence.build(Arrays.asList("bed", "bedbath", "and", "beyond"), "bedbathandbeyond"))
        .containsExactly("bedbath", "and", "beyond");
  }
}