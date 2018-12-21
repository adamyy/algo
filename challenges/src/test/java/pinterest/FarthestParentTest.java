package pinterest;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import pinterest.FarthestParent.Pair;

import static com.google.common.truth.Truth.*;

public class FarthestParentTest {

  @Test
  public void earliestAncestor() {
    List<Pair> parentChildPairs = Arrays.asList(
        new Pair("1", "3"),
        new Pair("2", "3"),
        new Pair("3", "6"),
        new Pair("5", "6"),
        new Pair("5", "7"),
        new Pair("4", "5"),
        new Pair("4", "8"),
        new Pair("8", "9"),
        new Pair("11", "8"),
        new Pair("10", "1")
    );
    assertThat(FarthestParent.earliestAncestor("1", parentChildPairs)).isEqualTo("10");
    assertThat(FarthestParent.earliestAncestor("2", parentChildPairs)).isEqualTo("-1");
    assertThat(FarthestParent.earliestAncestor("3", parentChildPairs)).isEqualTo("10");
    assertThat(FarthestParent.earliestAncestor("4", parentChildPairs)).isEqualTo("-1");
    assertThat(FarthestParent.earliestAncestor("5", parentChildPairs)).isEqualTo("4");
    assertThat(FarthestParent.earliestAncestor("6", parentChildPairs)).isEqualTo("10");
    assertThat(FarthestParent.earliestAncestor("7", parentChildPairs)).isEqualTo("4");
    assertThat(FarthestParent.earliestAncestor("8", parentChildPairs)).isEqualTo("4");
    assertThat(FarthestParent.earliestAncestor("9", parentChildPairs)).isEqualTo("4");
    assertThat(FarthestParent.earliestAncestor("10", parentChildPairs)).isEqualTo("-1");
    assertThat(FarthestParent.earliestAncestor("11", parentChildPairs)).isEqualTo("-1");
  }
}