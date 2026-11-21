/*
 * 595. Big Countries  [Easy]
 * https://leetcode.com/problems/big-countries/
 * Topics: Database
 *
 * Problem:     A country is big if its area is at least 3,000,000 km^2 or its population is
 *              at least 25,000,000. Return name, population and area of big countries.
 * Example:     Afghanistan: area 652,230 km^2, population 25,500,100 -> big (by population)
 * Constraints: -
 *
 * Key idea:    Simple WHERE with OR. (A UNION of two queries can be faster on indexed
 *              columns.)
 *
 * Approach:    WHERE area OR population
 * Submitted:   2023-12-15 (submission 1120162121, AC)
 */

# Write your MySQL query statement below
SELECT name, population, area FROM World where area >= 3000000 or population >= 25000000; 