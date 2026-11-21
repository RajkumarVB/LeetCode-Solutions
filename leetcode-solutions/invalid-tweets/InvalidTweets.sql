/*
 * 1683. Invalid Tweets  [Easy]
 * https://leetcode.com/problems/invalid-tweets/
 * Topics: Database
 *
 * Problem:     Return ids of tweets whose content is longer than 15 characters.
 * Example:     content 'Let us make America great again!' -> invalid
 * Constraints: -
 *
 * Key idea:    WHERE LENGTH(content) > 15. (CHAR_LENGTH counts characters; LENGTH counts
 *              bytes. They're the same here since content is ASCII.)
 *
 * Approach:    WHERE LENGTH > 15
 * Submitted:   2023-12-15 (submission 1120167579, AC)
 */

# Write your MySQL query statement below

select tweet_id from tweets where length(content) > 15 ; 