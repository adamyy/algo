package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We consider the problem of assigning tasks to workers. Each worker must be assigned exactly two tasks.
 * Each task takes a fixed amount of time. Tasks are independent,
 * i.e., there are no constraints of the form "Task 4 cannot start before Task 3 is completed."
 * Any task can be assigned to any worker.
 *
 * We want to assign tasks to workers so as to minimize how long it takes before all tasks are completed.
 * For example, if there are 6 tasks whose durations are 5, 2, 1, 6, 4, 4 hours,
 * then an optimum assignment is to give the first two tasks (i.e., the tasks with duration 5 and 2)
 * to one worker, the next two (1 and 6) to another worker, and the last two tasks (4 and 4) to the last worker.
 * For this assignment, all tasks will finish after max(5 + 2, 1 + 6, 4 + 4) = 8 hours.
 */
public class TaskAssignment {
  public static class Assignment {
    int first, second;

    public Assignment(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Assignment that = (Assignment) o;

      return first == that.first && second == that.second;
    }

    @Override
    public int hashCode() {
      return 31 * first + second;
    }
  }

  public static List<Assignment> optimumTaskAssignment(List<Integer> durations) {
    Collections.sort(durations);
    List<Assignment> optimumAssignments = new ArrayList<>();
    for (int i = 0, j = durations.size() - 1; i < j; i++, j--) {
      optimumAssignments.add(new Assignment(durations.get(i), durations.get(j)));
    }
    return optimumAssignments;
  }
}
