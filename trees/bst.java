import java.util.*;

public class bst{

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

// Size

    int size(TreeNode node){
        return node == null ? 0: size(node.left)+size(node.right)+1;
    }

// Height

    int height(TreeNode node){
        if(node == null)
            return -1;
        
        int lh = height(node.left);
        int rh = height(node.right);
        int mh = Math.max(lh,rh)+1;

        return mh;
    }

// Avoid recursion here
    public int maximumEle(TreeNode node){
        TreeNode curr = node;

        while(curr.right != null)
            curr = curr.right;
        
        return curr.val;
    }

    public int minimumEle(TreeNode node){
        TreeNode curr = node;

        while(curr.left != null)
            curr = curr.left;

        return curr.val;
    }

    public boolean findData(TreeNode node,int data){
        TreeNode curr = node;

        while(curr != null){
            if(curr.data == data)
                return true;
            else if(curr.val == data)
                curr = curr.left;
            else
                curr = curr.right;                
        }

        return false;        
    }

    public boolean findDataRec(TreeNode node,int data){
        if(node == null)
            return false;
        
        if(node.val == data)
            return true;
        
        if(node.val > data)
            return findDataRec(node.left,data);
        else
            return findDataRec(node.right,data);
    }

// 701. Insert data in bst
    public TreeNode insertIntoBST(TreeNode root,int val){
        if(root == null)
            return new TreeNode(val);
        
        if(node.val > val)
            root.left = insertIntoBST(root.left,val);
        else
            root.right = insertIntoBST(root.right,val);

        return root;
    }

// 450. Delete a node from BST

public int maximumEle(TreeNode root){
        TreeNode curr = root;
        
        while(curr.right != null)
            curr = curr.right;
        
        return curr.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(root.val > key)
            root.left = deleteNode(root.left,key);
        else if(root.val < key)
            root.right = deleteNode(root.right,key);
        else{
            // if found
            if(root.left == null || root.right == null)
                return root.left != null ? root.left : root.right;
            
            int maxValue = maximumEle(root.left);
            root.val = maxValue;
            root.left = deleteNode(root.left,maxValue);
        }
        return root;
    }

    // 235. LCA of BST

    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        TreeNode curr = root;

        while(curr != null){
            if(curr.val > p.val && curr.val > q.val)
                curr = curr.left;
            else if(curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else
                return curr;
        }

        return curr;
    }

// 108

    public TreeNode createBST(int arr[],int si,int ei){
        if(si > ei)
            return null;
        
        int mid = (si+ei)/2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = createBST(arr,si,mid-1);
        node.right = createBST(arr,mid+1,ei);

        return node;
    }





}