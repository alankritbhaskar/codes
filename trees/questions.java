import java.util.List;

public class question {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int size(TreeNode node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    // Edges, for Nodes : return node == null ? 0
    public int height(TreeNode node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }

    public int maximum(TreeNode node) {
        if (node == null)
            return -(int) 1e9;
        int lmv = maximum(node.left); // left maximum value
        int rmv = maximum(node.right); // right maximum value

        return Math.max(Math.max(lmv, rmv), node.val);
    }

    public boolean find(TreeNode node, int data){
        if(node == null)
        return false;

        if(node.val == data)
        return true;
        
        return find(node.left, data) || find(node.right, data);
    }

// Root to node path 

     public boolean rootToNodePath(TreeNode node, TreeNode data, ArrayList<TreeNode> ans) {
         if(node == null)
         return false;

         if(node == data){
             ans.add(node);
             return true;
         }

         boolean res = false;
         res = rootToNodePath(node.left,data,ans) || rootToNodePath(node.right,data,ans);

         if(res)
         ans.add(node);

         return res;
     }

     public ArrayList<TreeNode> rootToNodePath(TreeNode node, TreeNode data) {
         if(node == null)
         return new ArrayList<>();

         if(node == data){
             ArrayList<TreeNode> base = new ArrayList<>();
             base.add(node);
             return base;
         }

         ArrayList<TreeNode> left = rootToNodePath(node.left,data);
         if(left.size() > 0){
             left.add(node);
             return left;
         }

         ArrayList<TreeNode> right = rootToNodePath(node.right,data);
        if(right.size() > 0){
            right.add(node);
            return right;
        }

        return new ArrayList<>(); // return blank arraylist in case no root to node path found
     }

// Leetcode 236. Lowest Common Ancestor of a binary tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> firstPath = new ArrayList<>();
        ArrayList<TreeNode> secondPath = new ArrayList<>();
        
        rootToNodePath(root,p,firstPath);
        rootToNodePath(root,q,secondPath);
        
        int i = firstPath.size()-1;
        int j = secondPath.size()-1;
        TreeNode LCA = null;
        
        while(i>=0 && j>=0){
            if(firstPath.get(i) != secondPath.get(j))
                break;
            
            LCA = firstPath.get(i);
            i--;
            j--;
        }
        return LCA;
    }

// K nodes down

    public void printKDown(TreeNode node, TreeNode block, int depth, List<Integer> ans) {
        if(node == null || node == block || depth<0)
        return;

        if(depth == 0){
            ans.add(node.val);
            return;
        }

        printKDown(node.left,block,depth-1,ans);
        printKDown(node.right,block,depth-1,ans);
    }

// Leetcode 863. All Nodes Distance K in Binary Tree

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

    }







// https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

// Leetcode 543. Diameter of a tree
// O(N^2)

    public int diameter1(TreeNode root){
        if(root == null)
        return 0;

        int leftTreeDia = diameter1(root.left);
        int rightTreeDia = diameter1(root.right);
        int leftTreeHeight = height(root.left);
        int rightTreeHeight = height(root.right);

        return Math.max(leftTreeDia,Math.max(rightTreeDia,leftTreeHeight+rightTreeHeight+2));

    }

// O(N)

    // {dia,height}
    public int[] diameter2(TreeNode root){
        if(root == null)
        return new int[] {-1,-1};

        int leftAns [] = diameter2(root.left);
        int rightAns [] = diameter2(root.right);

        int ans [] = new int[2];
        ans[0] = Math.max(leftAns[0],Math.max(rightAns[0],leftAns[1]+rightAns[1]+2));
        ans[1] = Math.max(leftAns[1],rightAns[1])+1;

        return ans;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
    int ans [] = diameter2(root);
    return ans[0] == -1 ? 0 : ans[0];
    }

// Using static or reference variable
// O(N)

    int maxDia = 0;
    public int diameter3(TreeNode root){
        if(root == null)
        return -1;

        int lh = diameter3(root.left);
        int rh = diameter3(root.right);

        maxDia = Math.max(maxDia,lh+rh+2);

        return Math.max(lh,rh)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
    int ht = diameter3(root);
    return maxDia;
    }

// 112. Path Sum

   public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        boolean res = false;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0)
                res = true;
        }
      
        res = res || hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
        
        return res;
    }

// 113. Path Sum - II

    public void pathSum(TreeNode root,int tar,List<List<Integer>> res,ArrayList<Integer> smallAns){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            if(tar - root.val == 0){
                ArrayList<Integer> base = new ArrayList<>(smallAns); // deep copy required
                base.add(root.val);
                res.add(base);
            }
            return;
        }
        
        smallAns.add(root.val);
        pathSum(root.left,tar-root.val,res,smallAns);
        pathSum(root.right,tar-root.val,res,smallAns);
        smallAns.remove(smallAns.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root,targetSum,ans,new ArrayList<Integer>());
        return ans;
    }

// Here each time copy constructor is fired

    // void pathSum(TreeNode* root,int tar,vector<vector<int>> &ans,vector<int> smallAns){
    //     if(root == nullptr)
    //         return;
        
    //     if(root->left == nullptr && root->right == nullptr){
    //         if(tar - root->val == 0){
    //             // In cpp, each time copy-constructor is fired
    //             smallAns.push_back(root->val);
    //             ans.push_back(smallAns);
    //         }
    //         return;
    //     }
        
    //     smallAns.push_back(root->val);
    //     pathSum(root->left,tar-root->val,ans,smallAns);
    //     pathSum(root->right,tar-root->val,ans,smallAns);
    //     smallAns.pop_back();
    // }
    
// Here, each time only a reference is passed so similar to the way we do in java
// Much faster as each time copy is not made


    // vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
    // vector<vector<int>> ans;
    // vector<int> smallAns;
    // pathSum(root,targetSum,ans,smallAns);
    // return ans;
    // }

    //     void pathSum(TreeNode* root,int tar,vector<vector<int>> &ans,vector<int> &smallAns){
    //     if(root == nullptr)
    //         return;
        
    //     if(root->left == nullptr && root->right == nullptr){
    //         if(tar - root->val == 0){
    //             // In cpp, each time copy-constructor is fired
    //             smallAns.push_back(root->val);
    //             ans.push_back(smallAns);
    //             smallAns.pop_back();
    //         }
    //         return;
    //     }
        
    //     smallAns.push_back(root->val);
    //     pathSum(root->left,tar-root->val,ans,smallAns);
    //     pathSum(root->right,tar-root->val,ans,smallAns);
    //     smallAns.pop_back();
    // }
    
    // vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
    // vector<vector<int>> ans;
    // vector<int> smallAns;
    // pathSum(root,targetSum,ans,smallAns);
    // return ans;
    // }

// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1 ..... Max path sum bw two leaf

    int maxPathSumLeafToLeaf = -(int)1e9; // max path sum between two leaves
    
    int maxPathSum_(Node root){
        if(root == null)
        return -(int)1e9;
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int lMax = maxPathSum_(root.left);
        int rMax = maxPathSum_(root.right);
        
        if(root.left != null && root.right != null){ // it ensures that it is leaf to leaf
            maxPathSumLeafToLeaf = Math.max(maxPathSumLeafToLeaf,lMax+rMax+root.data);
        }
        
        return Math.max(lMax,rMax)+root.data;
    }
    
    int maxPathSum(Node root)
    { 
        int ans = maxPathSum_(root);
        return maxPathSumLeafToLeaf;
    } 

// In case there is a restriction of not using static variable then use a single sized array as it is made on heap memory

 int maxPathSum_(Node root,int m[]){
        if(root == null)
        return -(int)1e9;
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int lMax = maxPathSum_(root.left,m);
        int rMax = maxPathSum_(root.right,m);
        
        if(root.left != null && root.right != null){ // it ensures that it is leaf to leaf
            m[0] = Math.max(m[0],lMax+rMax+root.data);
        }
        
        return Math.max(lMax,rMax)+root.data;
    }
    
    int maxPathSum(Node root)
    { 
        int m[] = new int[1];
        m[0] = -(int)1e9;
        int ans = maxPathSum_(root,m);
        return m[0];
    } 

// Leetcode 98. Validate BST

// Method 1:- Using pair class

    public static class BSTPair{
        long Max = -(long)1e15;
        long Min = (long)1e15;
        boolean isBST = true;
        
        BSTPair(long Max,long Min,boolean isBST){
            this.Max = Max;
            this.Min = Min;
            this.isBST = isBST;
        }
        
        BSTPair(){
            
        }
    }
    
    public BSTPair isBST(TreeNode root){
        if(root == null)
            return new BSTPair();
        
        BSTPair left = isBST(root.left);
        BSTPair right = isBST(root.right);
        
        BSTPair myAns = new BSTPair();
        
        myAns.isBST = (left.isBST && right.isBST && (left.Max < root.val && root.val < right.Min));
        myAns.Max = Math.max(Math.max(left.Max,root.val),right.Max);
        myAns.Min = Math.min(Math.min(left.Min,root.val),right.Min);
        
        return myAns;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        else{
            BSTPair ans= isBST(root);
            return ans.isBST;
        }
    }

// Method 2:- Using the concept, for a BST inorder traversal gives a sorted order


}