# Scalable Priority System

Maintaining a set of prioritized jobs in a distributed system can be tricky.
Applications include a serach engine crawling web pages in some prioritized order.
The number of jobs is in the billions and each has its own priority.

Design a system for maintaining a set of prioritized jobs that implements the following API:

    1. insert a new job with a given priority
    2. delete a job
    3. find the highest priority job

Each job has a unique ID, assume that the set cannot fit into a single machine's memory.

Hint: How would you partition jobs across machines? Is it always essential to operate on the highest priority job?

## Solution

If we have enough RAM on a single machine, the most simple solution would be to maintain a min-heap where 
entries are ordered by their priority. An additional hash table can be used to map jobs to their corresponding
entry in the min-heap to make deletions fast.

A more scalable solution entails partitioning the problem across multiple machines. One approach is to apply
a hash function to the job ids and partition the resulting hash codes into ranges, one per machine.
Insert as well as delete require communication with just one server, to do extract-min, we send a lookup
minimum message to all the machines, infer the minimum from their responses, and then delete it.

At a given time many clients may be interested in the highest priority event, and it is challenging to 
distribute this problem well. If many clients are trying to do this operation at the same time, we may
run into a situation where most clients will find that the min event they are trying to extract has already been
deleted.

If the throughput of this service can be handled by a single machine, we can make one server solely responsible
for responding to all the requests. This server can prefetch the top hundred or so events from each of the machines and keep them in a heap.

In many applications, we do not need strong consistency guarantees. We want to spend most of the resource taking
care of the highest priority jobs. In such setting, a client could pick one of the machines at random, 
and requests the highest priority job. This would work well for the distributed crawler application, but not
suited to event-driven simulation because of dependencies.

Another issue is resiliency: if a node fails, all list of work on that node fails as well. It is better to
have nodes to contain overlapped lists and the dispatching node in this case will handle duplicates. The lost of
a node should not result in full re-hashing - the replacement node should handle only new jobs. Consistent
hashing can be used.

A front-end caching server can become a bottleneck. This can be avoided by using replication, i.e, multiple 
servers which duplicate each other. There could be possible several ways to coordinate them:
use non-overlapping lists, keep a blocked job list, return a random job from the jobs with highest priority.

