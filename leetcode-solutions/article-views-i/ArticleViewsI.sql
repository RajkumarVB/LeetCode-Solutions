/*
 * 1148. Article Views I  [Easy]
 * https://leetcode.com/problems/article-views-i/
 * Topics: Database
 *
 * Problem:     From a Views table (article_id, author_id, viewer_id, view_date), list the
 *              authors who viewed at least one of their own articles, sorted by id.
 * Example:     rows where author_id = viewer_id -> those author ids
 * Constraints: table may contain duplicates
 *
 * Key idea:    Filter author_id = viewer_id, use DISTINCT to remove duplicates, alias the
 *              column and ORDER BY.
 *
 * Approach:    WHERE + DISTINCT
 * Submitted:   2023-12-15 (submission 1120166524, AC)
 */

# Write your MySQL query statement below
SELECT DISTINCT author_id as id FROM Views where author_id = viewer_id ORDER BY id ; 