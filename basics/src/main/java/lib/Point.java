package lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static List<Point> fromArray(int... arr) {
    assert arr.length % 2 == 0;

    List<Point> list = new LinkedList<>();
    for (int i = 0; i + 1 < arr.length; i += 2) list.add(new Point(arr[i], arr[i + 1]));
    return list;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
