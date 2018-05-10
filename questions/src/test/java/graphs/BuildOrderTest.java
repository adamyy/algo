package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BuildOrderTest {

  @Test
  public void buildOrder() {
    String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
    String[][] dependencies = new String[][] {
        new String[] {"a", "d"},
        new String[] {"f", "b"},
        new String[] {"b", "d"},
        new String[] {"f", "a"},
        new String[] {"d", "c"},
    };
    assertThat(BuildOrder.buildOrder(projects, dependencies))
        .asList()
        .containsExactly( "f", "e", "a", "b", "d", "c");
  }
}