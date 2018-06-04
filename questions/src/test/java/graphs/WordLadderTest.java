package graphs;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class WordLadderTest {

  @Test
  public void ladderLengthBFS() {
    assertThat(
        WordLadder.ladderLengthBFS("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"))
    ).isEqualTo(5);
    assertThat(
        WordLadder.ladderLengthBFS("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))
    ).isEqualTo(0);
  }

  @Test
  public void ladderLengthDijkstra() {
    assertThat(
        WordLadder.ladderLengthDijkstra("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"))
    ).isEqualTo(5);
    assertThat(
        WordLadder.ladderLengthDijkstra("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))
    ).isEqualTo(0);
  }
}