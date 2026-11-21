/*
 * 1581. Customer Who Visited but Did Not Make Any Transactions  [Easy]
 * https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
 * Topics: Database
 *
 * Problem:     Find customers who visited without making a transaction and how many such
 *              visits each had.
 * Example:     customer 54 had 2 visits with no transaction -> (54, 2)
 * Constraints: -
 *
 * Key idea:    Keep visits whose visit_id is NOT IN the Transactions table (or LEFT JOIN
 *              and test for NULL), then GROUP BY customer.
 *
 * Approach:    NOT IN subquery + GROUP BY
 * Submitted:   2023-12-15 (submission 1120285032, AC)
 */

# Write your MySQL query statement below
# select * from Visits as v inner join Transactions as t on v.visit_id = t.visit_id ; 


select customer_id, count(customer_id) as count_no_trans from visits where visit_id not in (select visit_id from Transactions) group by customer_id; 