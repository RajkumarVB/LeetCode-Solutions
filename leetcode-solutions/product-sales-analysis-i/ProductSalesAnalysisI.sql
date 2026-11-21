/*
 * 1068. Product Sales Analysis I  [Easy]
 * https://leetcode.com/problems/product-sales-analysis-i/
 * Topics: Database
 *
 * Problem:     For each sale, report the product name, year and price.
 * Example:     join Sales with Product on product_id
 * Constraints: -
 *
 * Key idea:    INNER JOIN Sales and Product on product_id, then select the needed columns.
 *
 * Approach:    INNER JOIN
 * Submitted:   2023-12-15 (submission 1120276738, AC)
 */

# Write your MySQL query statement below
select p.product_name, s.year, s.price from sales as s  inner join product as p on s.product_id = p.product_id; 