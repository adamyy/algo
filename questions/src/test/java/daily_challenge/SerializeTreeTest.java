package daily_challenge;

import daily_challenge.SerializeTree.Node;
import org.junit.Test;

import static com.google.common.truth.Truth.*;
import static daily_challenge.SerializeTree.deserialize;
import static daily_challenge.SerializeTree.serialize;

public class SerializeTreeTest {

  @Test
  public void test() {
    Node node = new Node(
        "root",
        new Node(
            "left",
            new Node(
                "left.left"
            ),
            null
        ),
        new Node(
            "right"
        )
    );
    assertThat(deserialize(serialize(node)).left.left.value).isEqualTo("left.left");
  }
}