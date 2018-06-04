package greedy;

/**
 * The activity selection problem is a combinatorial optimization problem
 * concerning the selection of non-conflicting activities to perform within a given time frame,
 * given a set of activities each marked by a start time (si) and finish time (fi).
 * The problem is to select the maximum number of activities that can be performed by a single person or machine,
 * assuming that a person can only work on a single activity at a time.
 *
 * A classic application of this problem is in scheduling a room for multiple competing events,
 * each having its own time requirements (start and end time),
 * and many more arise within the framework of operations research.
 *
 * Formal definition
 * Assume there exist n activities with each of them being represented by a start time si and finish time fi.
 * Two activities i and j are said to be non-conflicting if si ≥ fj or sj ≥ fi.
 * The activity selection problem consists in finding the maximal solution set (S) of non-conflicting activities,
 * or more precisely there must exist no solution set S' such that |S'| > |S| in the case that multiple maximal solutions have equal sizes.
 *
 * Optimal solution
 * The activity selection problem is notable in that using a greedy algorithm to
 * find a solution will always result in an optimal solution.
 *
 * Greedy-Iterative-Activity-Selector(A, s, f):
 *
 *     Sort A by finish times stored in f'
 *
 *     S = {A[1]}
 *     k = 1
 *
 *     n = A.length
 *
 *     for i = 2 to n:
 *        if s[i] ≥ f[k]:
 *            S = S U {A[i]}
 *            k = i
 *
 *     return S
 */
public class ActivitySelection {

}
