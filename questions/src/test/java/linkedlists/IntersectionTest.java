package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class IntersectionTest {

  @Test
  public void intersect() {
    ListNode intersection = ListNode.fromArray(new int[] { 1,2,3 });
    ListNode first = new ListNode(0, intersection);
    ListNode second = new ListNode(1, intersection);
    assertThat(Intersection.intersect(first, second)).isTrue();

    ListNode third = ListNode.fromArray(new int[] { 0,1,2,3 });
    assertThat(Intersection.intersect(first, third)).isFalse();
  }

  @Test
  public void intersection() {
    ListNode intersection = ListNode.fromArray(new int[] { 1,2,3 });
    ListNode first = new ListNode(0, intersection);
    ListNode second = new ListNode(1, intersection);
    assertThat(Intersection.intersection(first, second)).isEqualTo(intersection);

    ListNode third = ListNode.fromArray(new int[] { 0,1,2,3 });
    assertThat(Intersection.intersection(first, third)).isNull();
  }
}