/*
 * 182. Duplicate Emails  [Easy]
 * https://leetcode.com/problems/duplicate-emails/
 * Topics: Database
 *
 * Problem:     Report every email that appears more than once in the Person table.
 * Example:     a@b.com appears twice -> a@b.com
 * Constraints: -
 *
 * Key idea:    GROUP BY email HAVING COUNT(*) > 1. (HAVING filters groups; WHERE filters
 *              rows.)
 *
 * Approach:    GROUP BY + HAVING
 * Submitted:   2023-10-01 (submission 1063926367, AC)
 */

# Write your MySQL query statement below
select email from person group by email having count(email)>1;