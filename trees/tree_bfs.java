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
                
                // Swap both the queues 
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
        que.addLast(null); // delimitter

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

// Benefits:- Simple code, can be written in less lines

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
        
        List<Integer> level = new ArrayList<>();
        while(size-- > 0){
            TreeNode rn = que.removeFirst();
            level.add(rn.val);
            
            if(rn.left != null)
                que.addLast(rn.left);
            if(rn.right != null)
                que.addLast(rn.right);
        }
        ans.add(level);
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

// Left view of binary tree
// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

    public static ArrayList<Integer> leftView(){
        if(root == null)
        return new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while(que.size() != 0){
            int size = que.size();
            // System.out.print("Level "+level+" : ");
            ans.add(que.getFirst().data);
            while(size-- > 0){
            Node rn = que.removeFirst(); // rn : removed node

            if(rn.left != null)
            que.addLast(rn.left);
            if(rn.right != null)
            que.addLast(rn.right);
            }
            level++;
        }
        return ans;
    }

// Leetcode 199. Right View of Binary Tree
// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
        return new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while(que.size() != 0){
            int size = que.size();

            //ans.add(que.getLast().val);
            ans.add(que.getFirst().val);
            while(size-- > 0){
            TreeNode rn = que.removeFirst(); // rn : removed node
            
            if(rn.right != null)
            que.addLast(rn.right);
            if(rn.left != null)
            que.addLast(rn.left);

            }
            level++;
        }
        return ans;
    }

// Vertical View of a binary tree

    public static class verticalPair{
        TreeNode node = null;
        int hl = 0;

        verticalPair(TreeNode node,int hl){
            this.node = node;
            this.hl = hl; 
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode node){
        LinkedList<verticalPair> que = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        que.add(new verticalPair(root,0));
        int level = 0;
        int minHl = (int)1e8;
        int maxHl = -(int)1e8;

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                verticalPair rp = que.removeFirst();
            
                if(!map.containsKey(rp.hl))
                map.put(rp.hl,new ArrayList<>());

                map.get(rp.hl).add(rp.node.val);
                minHl = Math.min(minHl,rp.hl);
                maxHl = Math.max(maxHl,rp.hl);

                if(rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left,rp.hl - 1));
                if(rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right,rp.hl + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(minHl <= maxHl){
            ans.add(map.get(minHl));
            minHl++;
        }
        return ans;
    }

    public List<List<Integer>> verticalView(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        HashMap<Integer,Integer> level = new HashMap<>();

        int disp = 0;
        que.addLast(root);
        int size = que.size();

        while(size-- > 0){
            TreeNode rn = que.removeFirst();

            if(rn.left != null)
            {
                

            }
        }
    }

    public static void main(String args[]){

    }

}