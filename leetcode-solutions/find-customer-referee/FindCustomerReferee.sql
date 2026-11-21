/*
 * 584. Find Customer Referee  [Easy]
 * https://leetcode.com/problems/find-customer-referee/
 * Topics: Database
 *
 * Problem:     Return names of customers who were not referred by the customer with id 2
 *              (including those not referred by anyone).
 * Example:     referee_id NULL or 1 -> included; 2 -> excluded
 * Constraints: -
 *
 * Key idea:    NULL != 2 evaluates to UNKNOWN, not TRUE, so you must add 'OR referee_id IS
 *              NULL' explicitly.
 *
 * Approach:    WHERE IS NULL OR != 2
 * Submitted:   2024-07-15 (submission 1322024272, AC)
 */

# Write your MySQL query statement below

select name from customer 
where referee_id is null or referee_id != 2; 