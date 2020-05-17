package Training.Tree.No_589_N叉树前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No_589 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.add(root);
            while (!nodeStack.empty()){
                Node node = nodeStack.pop();
                if(node==null){
                    break;
                }
                res.add(node.val);
                for (int i = node.children.size()-1;i>=0;i-- ){
                    nodeStack.add(node.children.get(i));
                }
            }
            return res;
        }
    }
}
