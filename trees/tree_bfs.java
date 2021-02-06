public class tree_bfs{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

// BFS or Level Order Traversal in a tree

// Remove --> Print --> Add

    public static void levelOrderSimple(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while(que.size() != 0){
            TreeNode rn = que.removeFirst(); // rn : removed node
            System.out.println(rn.val+" ");

            if(rn.left != null)
            que.addLast(rn.left);
            if(rn.right != null)
            que.addLast(rn.right);
        }
    }

// Linewise Level order print

// Method 1:- Using 2 queues

    public static void levelOrderLineWise01(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> childQueue = new LinkedList<>();

        que.addLast(root);
        int level = 0;
        System.out.print("Level "+level+" : ");
        while(que.size() != 0){
            TreeNode rn = que.removeFirst(); // rn : removed node
            System.out.print(rn.val+" ");

            if(rn.left != null)
            childQueue.addLast(rn.left);
            if(rn.right != null)
            childQueue.addLast(rn.right);

            if(que.size() == 0){
                System.out.println();
                if(childQueue.size() != 0)
                System.out.print("Level "+(++level)+" : ");

                LinkedList<TreeNode> temp = que;
                que = childQueue;
                childQueue = temp;
            }
        }
    }

// Method 2:- Using delimitter i.e. a value which cant be present in my tree

    public static void levelOrderLineWise02(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        que.addLast(null);

        int level = 0;
        System.out.print("Level "+level+" : ");
        while(que.size() != 1){
            TreeNode rn = que.removeFirst(); // rn : removed node
            System.out.println(rn.val+" ");

            if(rn.left != null)
            que.addLast(rn.left);
            if(rn.right != null)
            que.addLast(rn.right);

            if(que.getFirst() == null){
                System.out.println();
                System.out.print("Level "+level+" : ");
                que.removeFirst();
                que.addLast(null);
            }
        }
    }

// Method 3:- Using size variable at each state of loop

    public static void levelOrderLineWise03(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while(que.size() != 0){
            int size = que.size();
            System.out.print("Level "+level+" : ");
            while(size-- > 0){
            TreeNode rn = que.removeFirst(); // rn : removed node
            System.out.print(rn.val+" ");

            if(rn.left != null)
            que.addLast(rn.left);
            if(rn.right != null)
            que.addLast(rn.right);
            }
            level++;
            System.out.println();
        }
    }

// Leetcode 102. Level Order Traversal Linewise

    public List<List<Integer>> levelOrderLineWise(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() != 0){
            int size = que.size();
            
            List<Integer> s = new ArrayList<>();
            while(size-- > 0){
                TreeNode rn = que.removeFirst();
                s.add(rn.val);
                
                if(rn.left != null)
                    que.addLast(rn.left);
                if(rn.right != null)
                    que.addLast(rn.right);
            }
            ans.add(s);
        }
        return ans;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = levelOrderLineWise(root);
        return ans;
    }

// Leetcode 107. Level Order - II

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() != 0){
            int size = que.size();
            
            List<Integer> s = new ArrayList<>();
            while(size-- > 0){
                TreeNode rn = que.removeFirst();
                s.add(rn.val);
                
                if(rn.left != null)
                    que.addLast(rn.left);
                if(rn.right != null)
                    que.addLast(rn.right);
            }
            ans.add(0,s);
        }
        //Collections.reverse(ans);
        return ans;
    }

    

    public static void main(String args[]){

    }

}