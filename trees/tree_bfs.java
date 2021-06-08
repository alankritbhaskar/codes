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
        HashMap<Integer, List<Integer>> map = new HashMap<>();

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

        public static List<List<Integer>> verticalOrderTraversal2(TreeNode root) {
        LinkedList<verticalPair> que = new LinkedList<>();

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add(new ArrayList<>());

        que.addLast(new verticalPair(root, -minMax[0]));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                ans.get(rp.hl).add(rp.node.val);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        return ans;
    }

    public static void width(TreeNode root, int hl, int ans[]){
    if (root == nullptr)
        return;

    ans[0] = min(hl, ans[0]);
    ans[1] = max(hl, ans[1]);

    width(root.left, hl - 1, ans);
    width(root.right, hl + 1, ans);
    }

// Vertical Sum in a binary tree

    public static int[] verticalSum(TreeNode root){
    LinkedListList que <verticalPair> = new LinkedList<>();
    
    int[] minMax = new int[2];
    width(root, 0, minMax);
    
    int len = minMax[1] - minMax[0] + 1;
    int res[] = new int[len];

    que.addLast(new verticalPair(root, -minMax[0])); // start from negative of min width towards left

    while (que.size() != 0){
        int size = que.size();
        while (size-- > 0)
        {
            verticalPair rp = que.removeFirst();
            
            res[rp.hl] += rp.node.val;

            if (rp.node.left != null)
                que.addLast(verticalPair(rp.node.left, rp.hl - 1));
            if (rp.node.right != null)
                que.addLast(verticalPair(rp.node.right, rp.hl + 1));
        }
    }
        return res;
    }

// Bottom View of a binary tree

    public static int[] bottomView(TreeNode root){
    LinkedList<verticalPair> que = new LinkedList<>();

    int minMax[] = new int[2];
    width(root, 0, minMax);
    
    int len = minMax[1] - minMax[0] + 1;
    int res[] = new int[len];

    que.addLast(new verticalPair(root, -minMax[0])); // start from negative of min width towards left

    while (que.size() != 0)
    {
        int size = que.size();
        while (size-- > 0)
        {
            verticalPair rp = que.removeFirst();
            
            res[rp.hl] = rp.node.val; // each time it gets updated and sets to the last element in vertical order

            if (rp.node.left != null)
                que.addLast(new verticalPair(rp.node.left, rp.hl - 1));
            if (rp.node.right != null)
                que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
        }
    }

        return res;
    }

// Diagonal Order Traversal

      public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> ans = new ArrayList<>();
           LinkedList<Node> que = new LinkedList<>();
           que.addLast(root);
           
           while(que.size() > 0){
               Node rn = que.removeFirst();
               while(rn != null){
                   if(rn.left != null)
                       que.addLast(rn.left);
                       
                       ans.add(rn.data);
                       rn = rn.right;
                   }
               }
               
               return ans;
           }


// https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
   
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        
        que.addLast(node);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Node rn = que.removeFirst();
                ans.add(0,rn.data);
                
                if(rn.right != null)
                que.addLast(rn.right);                
                if(rn.left != null)
                que.addLast(rn.left);

            }
        }
        return ans;
    }

// Top view of Binary Tree

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

// {minHl,maxHl}
    public void width(Node node,int hl,int minMax[]){
        if(node == null)
            return;
        
        minMax[0] = Math.min(minMax[0],hl); // left mein min lao
        minMax[1] = Math.max(minMax[1],hl); // right mein max lao

        width(node.left,hl-1,minMax); // explore left subtree
        width(node.right,hl+1,minMax); // explore right subtree
    }

    public class verticalPair{
        int hl = 0;
        Node node = null;

        verticalPair(){

        }

        verticalPair(int hl,Node node){
            this.hl = hl;
            this.node = node;
        }
    }

    public ArrayList<Integer> topView(Node node){
        LinkedList<verticalPair> que = new LinkedList<>();

        int[] minMax = new int[2];
        width(node, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add((int) 1e9); // set as a mark

        que.addLast(new verticalPair(-minMax[0],node));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                if (ans.get(rp.hl) == (int) 1e9)
                    ans.set(rp.hl, rp.node.data);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.hl - 1,rp.node.left));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.hl + 1,rp.node.right));
            }
        }

        return ans;
    }

// 987. Vertical Order Traversal with (x,y)

    public class verticalPair{
        int x = 0; // horizontal level
        int y = 0; // vertical level
        TreeNode node = null;
        
        verticalPair(TreeNode node,int x,int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    
    public void width(TreeNode node,int hl,int minMax[]){
        if(node == null)
            return;
        
        minMax[0] = Math.min(minMax[0],hl);
        minMax[1] = Math.max(minMax[1],hl);
        
        width(node.left,hl-1,minMax);
        width(node.right,hl+1,minMax);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<verticalPair> que = new PriorityQueue<>((a,b)->{
             // comp to be done on basis of y
            if(a.y != b.y)
                return a.y-b.y;// agar y ki val diff hai then smaller y value comes first // this - other -> minPQ
            else
                return a.node.val - b.node.val; // this - other // default
        }); 
        
        int minMax[] = new int[2];
        width(root,0,minMax);
        int len = minMax[1]-minMax[0]+1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < len;i++)
            ans.add(new ArrayList<>());
        
        que.add(new verticalPair(root,-minMax[0],0)); // vertical level = 0 initially
        
        // RPA
        while(que.size() > 0){
            verticalPair rp = que.remove();
            
            ans.get(rp.x).add(rp.node.val);
            
            if(rp.node.left != null)
                que.add(new verticalPair(rp.node.left,rp.x-1,rp.y+1));
            if(rp.node.right != null)
                que.add(new verticalPair(rp.node.right,rp.x+1,rp.y+1));
        }
        
        return ans;
    }



    public static void main(String args[]){

    }

}