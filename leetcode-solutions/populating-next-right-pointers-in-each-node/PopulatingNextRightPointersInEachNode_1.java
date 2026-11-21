/*
 * 116. Populating Next Right Pointers in Each Node  [Medium]
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Topics: Linked List, Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     In a perfect binary tree, set every node's next pointer to the node on its
 *              right in the same level (null at the end of a level).
 * Example:     [1,2,3,4,5,6,7] -> 1->#, 2->3->#, 4->5->6->7->#
 * Constraints: <= 4095 nodes
 *
 * Key idea:    BFS by levels works with O(n) space. O(1) space: use the next pointers
 *              already set on the level above: left.next = right, and right.next =
 *              node.next.left.
 *
 * Approach:    Recursive, uses parent's next pointer
 * Complexity:  time O(n), space O(h)
 * Also see:    _2: Level-order BFS
 * Submitted:   2024-01-03 (submission 1135485345, AC)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        if(root.left != null) root.left.next = root.right; 
        if(root.right!= null && root.next != null) root.right.next = root.next.left; 
        connect(root.left); 
        connect(root.right); 
        return root; 
    }
}