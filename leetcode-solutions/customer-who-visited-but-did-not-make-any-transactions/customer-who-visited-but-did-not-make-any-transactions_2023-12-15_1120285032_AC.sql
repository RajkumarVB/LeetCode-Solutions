# Write your MySQL query statement below
# select * from Visits as v inner join Transactions as t on v.visit_id = t.visit_id ; 


select customer_id, count(customer_id) as count_no_trans from visits where visit_id not in (select visit_id from Transactions) group by customer_id; 