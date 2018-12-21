package arrays;

import java.util.ArrayList;
import java.util.List;

class HungryRabbit {
  static class Location {
    int x, y;
    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int carrotsEaten(int[][] garden) {
    // determine start locaion
    Location current = findStart(garden);

    boolean[][] eaten = new boolean[garden.length][garden[0].length];
    int carrotsEaten = garden[current.x][current.y];
    eaten[current.x][current.y] = true;

    // while has moves
    // move and eat
    while (true) {
      Location nextMove = nextMove(current, eaten, garden);
      if (nextMove == null) break;
      carrotsEaten += garden[nextMove.x][nextMove.y];
      eaten[nextMove.x][nextMove.y] = true;
      current = nextMove;
    }

    return carrotsEaten;
  }

  private final static int[][] moves = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

  private static Location nextMove(Location location, boolean[][] eaten, int[][] garden) {
    int x = location.x, y = location.y;
    int maxCarrots = 0;
    Location ret = null;
    for (int[] move: moves) {
      Location next = new Location(x + move[0], y + move[1]);
      if (inBound(next, garden) && !eaten[next.x][next.y] && garden[next.x][next.y] > maxCarrots) {
        ret = next;
        maxCarrots = garden[next.x][next.y];
      }
    }
    return ret;
  }

  private static boolean inBound(Location location, int[][] garden) {
    return location.x >= 0 && location.x < garden.length && location.y >= 0 && location.y < garden[0].length;
  }

  private static Location findStart(int[][] garden) {
    int gardenX = garden.length;
    List<Integer> availableStartXs = new ArrayList<>();
    if (gardenX % 2 == 1)
      availableStartXs.add(gardenX / 2);
    else {
      availableStartXs.add(gardenX / 2 - 1);
      availableStartXs.add(gardenX / 2);
    }

    int gardenY = garden[0].length;
    List<Integer> availableStartYs = new ArrayList<>();
    if (gardenY % 2 == 1) {
      availableStartYs.add(gardenY / 2);
    } else {
      availableStartYs.add(gardenY / 2 - 1);
      availableStartYs.add(gardenY / 2);
    }

    List<Location> availableLocations = new ArrayList<>();
    for (Integer x: availableStartXs) {
      for (Integer y: availableStartYs) {
        availableLocations.add(new Location(x, y));
      }
    }

    int maxCarrots = -1;
    Location locationWithMaxCarrot = null;
    for (Location location: availableLocations) {
      if (garden[location.x][location.y] > maxCarrots) {
        maxCarrots = garden[location.x][location.y];
        locationWithMaxCarrot = location;
      }
    }
    return locationWithMaxCarrot;
  }
}