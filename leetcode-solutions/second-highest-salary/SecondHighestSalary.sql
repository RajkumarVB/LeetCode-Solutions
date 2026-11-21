/*
 * 176. Second Highest Salary  [Medium]
 * https://leetcode.com/problems/second-highest-salary/
 * Topics: Database
 *
 * Problem:     Return the second highest distinct salary, or NULL if there isn't one.
 * Example:     salaries 100, 200, 300 -> 200
 * Constraints: -
 *
 * Key idea:    MAX(salary) WHERE salary < (SELECT MAX(salary)). An aggregate over zero rows
 *              returns NULL automatically.
 *
 * Approach:    MAX below the overall MAX
 * Submitted:   2024-02-10 (submission 1171276017, AC)
 */

# Write your MySQL query statement below
SELECT MAX(salary) as SecondHighestSalary FROM Employee 
WHERE salary != (SELECT MAX(salary) FROM Employee); 
