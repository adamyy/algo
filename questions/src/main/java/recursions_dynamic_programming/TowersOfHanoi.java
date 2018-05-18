package recursions_dynamic_programming;

import java.util.Stack;

/**
 * Towers of Hanoi: In the classic problem of the towers of Hanoi,
 * you have 3 towers and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one).
 *
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class TowersOfHanoi {
  class Tower {
    private Stack<Integer> disks;
    public int index;

    public void add(int disk) {
      if (!disks.empty() && disk >= disks.peek()) throw new IllegalArgumentException();
      disks.push(disk);
    }

    public void moveTopTo(Tower tower) {
      int top = disks.pop();
      tower.add(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
      if (n <= 0) return;
      moveDisks(n - 1, buffer, destination);
      moveTopTo(destination);
      buffer.moveDisks(n - 1, destination, this);
    }
  }
}
