/*
 * 1378. Replace Employee ID With The Unique Identifier  [Easy]
 * https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
 * Topics: Database
 *
 * Problem:     Show each employee's unique_id (NULL if missing) and name.
 * Example:     Alice has no unique id -> (NULL, Alice)
 * Constraints: -
 *
 * Key idea:    LEFT JOIN keeps every employee even when there's no matching EmployeeUNI
 *              row.
 *
 * Approach:    LEFT JOIN
 * Submitted:   2023-12-15 (submission 1120275006, AC)
 */

# Write your MySQL query statement below
select eu.unique_id, name from Employees as e left join EmployeeUNI as eu on e.id=eu.id; 