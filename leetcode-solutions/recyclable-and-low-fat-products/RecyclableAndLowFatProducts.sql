/*
 * 1757. Recyclable and Low Fat Products  [Easy]
 * https://leetcode.com/problems/recyclable-and-low-fat-products/
 * Topics: Database
 *
 * Problem:     Return ids of products that are both low fat and recyclable.
 * Example:     low_fats='Y' and recyclable='Y'
 * Constraints: -
 *
 * Key idea:    Simple WHERE with AND.
 *
 * Approach:    WHERE ... AND ...
 * Submitted:   2023-12-15 (submission 1120157418, AC)
 */

# Write your MySQL query statement below

select product_id from products where low_fats = 'Y' and recyclable = 'Y'; 