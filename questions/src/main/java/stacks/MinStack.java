package stacks;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

  private StackNode topNode;

  static class StackNode {
    int val;
    int currentMin;
    StackNode next;

    public StackNode(int val, int currentMin, StackNode next) {
      this.val = val;
      this.currentMin = currentMin;
      this.next = next;
    }
  }

  public MinStack() {

  }

  public void push(int x) {
    int currentMin = topNode != null ? topNode.currentMin : Integer.MAX_VALUE;
    int newMin = Math.min(x, currentMin);
    topNode = new StackNode(x, newMin, topNode);
  }

  public void pop() {
    topNode = topNode.next;
  }

  public int top() {
    return topNode.val;
  }

  public int getMin() {
    return topNode.currentMin;
  }
}
