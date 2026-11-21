/*
 * 197. Rising Temperature  [Easy]
 * https://leetcode.com/problems/rising-temperature/
 * Topics: Database
 *
 * Problem:     Return ids of days that were warmer than the previous calendar day.
 * Example:     2015-01-02 at 25 after 10 the day before -> included
 * Constraints: -
 *
 * Key idea:    Self-join Weather on DATEDIFF(w2.recordDate, w1.recordDate) = 1 and compare
 *              temperatures. Don't compare ids, since dates may not be consecutive ids.
 *              LAG() is another option.
 *
 * Approach:    Self-join with DATEDIFF = 1
 * Submitted:   2023-12-16 (submission 1120768494, AC)
 */

# Write your MySQL query statement below

select w2.id from Weather w1, Weather w2
where dateDiff(w2.recordDate,w1.recordDate) = 1 AND w2.temperature > w1.temperature;