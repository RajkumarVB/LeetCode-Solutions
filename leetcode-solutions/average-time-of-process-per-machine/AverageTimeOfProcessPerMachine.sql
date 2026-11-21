/*
 * 1661. Average Time of Process per Machine  [Easy]
 * https://leetcode.com/problems/average-time-of-process-per-machine/
 * Topics: Database
 *
 * Problem:     Each process on a machine has a 'start' and 'end' timestamp row. Report each
 *              machine's average processing time (end - start), rounded to 3 decimals.
 * Example:     machine 0: processes taking 0.894 and 1.112 -> 1.003
 * Constraints: (machine_id, process_id, activity_type) is unique
 *
 * Key idea:    Self-join the table: one alias for 'start' rows and one for 'end' rows on
 *              the same machine+process, then GROUP BY machine and AVG the difference.
 *
 * Approach:    Self-join start/end rows + AVG
 * Submitted:   2023-12-16 (submission 1120782309, AC)
 */

# Write your MySQL query statement below

select a1.machine_id, round(avg(a2.timestamp - a1.timestamp),3) as processing_time from Activity a1 inner join Activity a2 on a1.machine_id = a2.machine_id and a1.process_id =a2.process_id and a1.activity_type = 'start' and a2.activity_type = 'end' group by a1.machine_id;