package daily_challenge;

import java.util.Iterator;

/**
 * This problem was asked by Google.
 *
 * Implement locking in a binary tree.
 * A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
 *
 * Design a binary tree node class with the following methods:
 *
 * is_locked, which returns whether the node is locked
 *
 * lock, which attempts to lock the node.
 *    If it cannot be locked, then it should return false.
 *    Otherwise, it should lock it and return true.
 *
 * unlock, which unlocks the node.
 *    If it cannot be unlocked, then it should return false.
 *    Otherwise, it should unlock it and return true.
 *
 * You may augment the node to add parent pointers or any other property you would like.
 * You may assume the class is used in a single-threaded program,
 * so there is no need for actual locks or mutexes.
 *
 * Each method should run in O(h), where h is the height of the tree.
 */
public class LockBinaryTree {
  int val;
  boolean isLocked;
  int lockedDescendantsCount;

  LockBinaryTree parent;
  LockBinaryTree left, right;

  public LockBinaryTree(int val, LockBinaryTree parent) {
    this.val = val;
    this.parent = parent;
  }

  public boolean isLocked() {
    return isLocked;
  }

  /**
   * @return true if locking is successful, false otherwise
   */
  public boolean lock() {
    if (!canLockOrUnlock()) return false;
    isLocked = true;
    LockBinaryTree ancestor = parent;
    while (ancestor != null) {
      ancestor.lockedDescendantsCount++;
      ancestor = ancestor.parent;
    }
    return true;
  }

  /**
   * @return true if unlocking is successful, false otherwise
   */
  public boolean unlock() {
    if (!canLockOrUnlock()) return false;
    isLocked = false;
    LockBinaryTree ancestor = parent;
    while (ancestor != null) {
      ancestor.lockedDescendantsCount--;
      ancestor = ancestor.parent;
    }
    return true;
  }

  private boolean canLockOrUnlock() {
    if (lockedDescendantsCount > 0) return false;
    LockBinaryTree ancestor = parent;
    while (ancestor != null) {
      if (ancestor.isLocked()) return false;
      ancestor = ancestor.parent;
    }
    return true;
  }
}
