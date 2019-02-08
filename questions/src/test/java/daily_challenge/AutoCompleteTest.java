package daily_challenge;

import com.google.common.collect.Sets;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class AutoCompleteTest {

  @Test
  public void queryTrie() {
    AutoComplete completeTrie = new AutoCompleteTrie(Sets.newHashSet("dog", "deer", "deal"));
    assertThat(completeTrie.query("de")).containsExactly("deer", "deal");
    assertThat(completeTrie.query("dog")).containsExactly("dog");
    assertThat(completeTrie.query("")).containsExactly("dog", "deer", "deal");
    assertThat(completeTrie.query("doggo")).isEmpty();
  }

  @Test
  public void queryBinaryTree() {
    AutoComplete completeBS = new AutoCompleteBinarySearch(Sets.newHashSet("dog", "deer", "deal"));
    assertThat(completeBS.query("de")).containsExactly("deer", "deal");
    assertThat(completeBS.query("dog")).containsExactly("dog");
    assertThat(completeBS.query("")).containsExactly("dog", "deer", "deal");
    assertThat(completeBS.query("doggo")).isEmpty();
  }
}