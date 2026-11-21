/*
 * 586. Customer Placing the Largest Number of Orders  [Easy]
 * https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
 * Topics: Database
 *
 * Problem:     From an Orders table, return the customer_number with the most orders
 *              (exactly one such customer).
 * Example:     customer 3 has 2 orders, others 1 -> 3
 * Constraints: -
 *
 * Key idea:    GROUP BY customer, ORDER BY COUNT(*) DESC, LIMIT 1.
 *
 * Approach:    GROUP BY + ORDER BY count + LIMIT
 * Submitted:   2024-04-13 (submission 1231467422, AC)
 */

# Write your MySQL query statement below
select customer_number from orders
group by customer_number
order by count(customer_number) desc
limit 1; 