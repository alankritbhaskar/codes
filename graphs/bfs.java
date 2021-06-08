import java.util.*;

public class bfs{

    public static class Edge{
        int v=0;
        int w=0;
        public Edge(int v,int w){
        this.v=v;
        this.w=w;
        }
    }

  
    static int n=7;
    static ArrayList<Edge>[] graph=new ArrayList[n];
    
    //add an edge in bidirectional graph
    
    public static void addEdge(int u,int v,int w){
    graph[u].add(new Edge(v,w));
    graph[v].add(new Edge(u,w));
    }

     public static int searchEdge(int u,int v){
     
     for(int i=0;i<graph[u].size();i++){
         Edge e=graph[u].get(i);
         if(e.v==v)//check that for vertex u is there any edge which terminates at vertex v..... if yes then return the index of vertex u.
         return i;
     }

     return -1;
     }
    
     public static void removeEdge(int u,int v){
     
     int v1=searchEdge(u,v);//index of vertex u is stored here 
     graph[u].remove(v1);
     int v2=searchEdge(v,u);//index of vertex v is stored here
     graph[v].remove(v2);
     
     }

     public static void removeVertex(int a){
     
     //used from backward dirn bcoz harr time graph ke arraylist mein se edge remove krne pe usme reordering hojayegi so actually sare elements delete nhi honge
     for(int i=graph[a].size()-1;i>=0;i--){
         Edge e=graph[a].get(i);
         removeEdge(a,e.v);
     }
     }
 
    public static void display(){

        for(int i=0;i<n;i++){
            System.out.print(i+"-> ");
            for(Edge e: graph[i]){
            System.out.print("("+ e.v+", "+e.w+"), ");
            }
            System.out.println();
        }
    }

    public static void constructGraph(){

         for(int i = 0;i<n ;i++) 
        graph[i] = new ArrayList<Edge>();// to store a blank arraylist at each index in array i.e. a blank arraylist in array of arraylist 

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);
        addEdge(2,5,6);
    }
    
    //    BFS:-
    //    1. queue que
    //    2. que <- src
    //    3. while(que.size()!=0)
    //       3.1. vtx <- que
    //       3.2. mark vtx
    //       3.3. for all unvisited nbrs
    //            3.3.1 insert in que <- nbrs

    public static void BFS_01(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);

    boolean cycle=false;
    
    while(que.size()!=0){
        int vtx = que.removeFirst();

        //optimum pos. for cycle detection
        if(vis[vtx]){
        cycle = true;
        continue;//agar same vtx pehle se visited hai to to usme nbrs ko que me add nhi krenge
        }

        vis[vtx]=true;
        
        for(Edge e: graph[vtx]){
         if(!vis[e.v])
         que.addLast(e.v);
    }
    }
    }

    //Delimitter-- for finding shortest distance till destination
    public static void BFS_02(int src,int dest,boolean vis[]){
    
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);
    que.addLast(null);
    boolean cycle=false;
    int level=0;
    while(que.size()!=1){
        int vtx=que.removeFirst();
        if(vis[vtx]){
            cycle=true;
            continue;
        }
        if(vtx==dest){
            System.out.println(level);// level-- it gives the shortest distance of destination from source node  
        }
        vis[vtx]=true;
        for(Edge e: graph[vtx]){
            if(!vis[e.v]){
                que.addLast(e.v);
            }
        }
        if(que.getFirst()==null){
            level++;
            que.addLast(que.removeFirst());
        }
    }
    }

    //......Cycle Wala BFS........
    public static void BFS_03_WithCycle(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    int dest = 6;
    que.addLast(src);
    boolean cycle=false;
    boolean found = false;

    int level=0;
    int dis[]=new int[n];//stores min. dist. from src vtx to all vertex

    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int vtx = que.removeFirst();
            if(vis[vtx]){
                cycle=true;
                continue;
            }
            if(vtx == dest){
                found = true;
                continue;
            }
            dis[vtx]=level;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    que.addLast(e.v);
                }
            }
        }
    }
        level++;
    }

// BFS for shortest path
    public static void BFS_04_WithoutCycle(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);
    vis[src]=true;

    int level=0;
    int dis[]=new int[n];
    while(que.size()!=0){
        int size=que.size();
        while(size-- > 0){
            int vtx=que.removeFirst();
            dis[vtx]=level;
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    vis[e.v]=true;
                    que.addLast(e.v);
                }
            }
        }
        level++;
    }
    }

// BFS for shortestPath Print

public static void BFS_04_WithoutCycle(int src,int dest,boolean vis[]){
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);
    vis[src] = true;

    int atLevel = -1;
    int level = 0;
    int dis[] = new int[n];
    int parent[] = new int[n];
    Arrays.fill(parent,-1);

    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int vtx = que.removeFirst();
            dis[vtx] = level;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    vis[e.v] = true;
                    que.addLast(e.v);
                    parent[e.v] = vtx;
                }

                if(e.v == dest)
                    atLevel = level + 1;
            }
        }
        level++;
    }
    System.out.print(dest+"is present at distance:"+atLevel);
    int idx = dest;

    while(idx != -1){
        System.out.print(idx+"-> ");
        idx = parent[idx];
    }
    }

// If graphs are disconnected
    public static int BFS_GCC(int n){
        boolean vis[] = new boolean[n];

        int components = 0;
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                BFS_03_WithCycle(i,vis);
                components++;
            }
        }
        return components;
    }

// 1091. Shortest Path in a binary matrix

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        
        boolean vis[][] = new boolean[m][n];
        
        int ans = BFS(0,0,m-1,n-1,vis,grid);
        
        return ans;
    }

// BFS for shortest path
    public int BFS(int sr,int sc,int er,int ec,boolean vis[][],int grid[][]){
        LinkedList<int[]> que = new LinkedList<>();
        que.addLast(new int[]{sr,sc});
        vis[sr][sc] = true;
        
        int atLevel = -1;
        int level = 1;
        
        int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int vtx[] = que.removeFirst();
                int vtx_x = vtx[0];
                int vtx_y = vtx[1];
                
                if(vtx_x == er && vtx_y == ec)
                    return level;
                
                // explore all neighbours
                for(int d = 0;d < dir.length;d++){
                    int x = vtx_x + dir[d][0];
                    int y = vtx_y + dir[d][1];
                    
                    if(x >= 0 && x <= er && y >= 0 && y <= ec && grid[x][y] == 0 && vis[x][y] == false){
                        que.addLast(new int[]{x,y});
                        vis[x][y] = true;
                    }
                }
            }
            level++;
        }
        return atLevel;
    }

// Problem
// Garima mam and the Contest
// Medium
// Dificulty
// 100
// Max Points
// Status: Wrong Answer

// 0/100 Pts
// Problem
// Submissions
// Ms Garima is an Instructor at Coding Blocks. She is an Awesome Teacher with really cool Mentoring skills because of her hard work towards the Students of her class, they are doing really great and have submitted all the questions till now. So, she decided to light up their coding skills and announced a Coding Contest in her Batch of N students. As all of the students are not available at the same time for the test so, the arrival time of the students can be different. Let the Arrival time of the students be denoted by array A[0], A[1]…..A[N]. Depending on the type of Student she has prepared a Contest of different length for e.g., for a beginner level student, time can vary with the Advanced level student. Let the time of Departure of the students be denoted by D[0], D[1]…..D[N]. For the Contest She needs to Provide Laptop to each Student and She has talked to the manager about the contest and the development of the skills of the students and he is well Convinced about the idea. Ms Garima is very Smart Mentor so she planned to order a minimum number of laptops so that no laptop remain ideal between the Contest as it will be foolishness to order N number of laptops it will cost the company a lot and a Such number of laptops will be of no use. As she is busy Preparing the question for the Contests so she asked you to write a Program that can calculate the minimum number of laptops needed so that no laptop remains ideal throughout the Contest. On the behalf of her Apprentice, it is now your job to help her out ;)

// Input Format
// The first line contains a single integer denoting the number of test cases T. Next line contains a single integer N, denoting the number of Students. Next line contains N-space separated Integers denoting the time of arrival of the Students. Next line contains N-space separated Integers denoting the time of departure of the Students.

// Constraints
// 0 < A[i] <= 2400 A[i] < D[i]

// Output Format
// Display the minimum number of laptop required for each test case separated by a newline.

// Sample Input
// 1
// 6
// 900 940 950 1100 1500 1800
// 910 1200 1120 1130 1900 2000
// Sample Output
// 3
// Explanation
// Here, A[] = {900, 940, 950, 1100, 1500, 1800}, D[] = {910, 1200, 1120, 1130, 1900, 2000}
// There are at-most three laptops needed at a time (time between 11:00 to 11:20).


/*
Problem
Match TIE
Easy
Dificulty
100
Max Points
Status: Not Attempted

0/100 Pts
Problem
Submissions
The shortest format of cricket has been one of the most amazing formats as well. It’s short, it’s fast, it’s intriguing, and it’s entertaining. Taking the T20 format further is the IPL, which has taken this game to a whole new level. Cricket and talent can be seen at its best in IPL.
This format of the game is so involving and competitive that you cannot afford to relax even for a single delivery. The game changes every over and the teams that has played well for more over’s is the one that comes out on top. But there are instances when both teams end up with equal scores at the end of twenty over’s. Which takes the game further to super over, which is even more exciting as all you got is 6 deliveries and 2 wickets to make it count.

But this Year Bcci Decide to change the rule: when both teams end up with equal scores at the end of twenty over’s. Which not takes the game further to super over
Rule : on field umpire has a set of n Question , umpire picks 1 out of n question. And gives this Question to the bowling team. If the bowling team is able to solve this problem, then the winner of the match is the bowling team.
Let Assume final match of vivo IPL 2021 RCB vs Delhi .RCB Win the Toss and bat first and Scored 152 runs , Delhi Capital also Scored 152 runs at the end of twenty over’s.
Umpire just came up with a set N question and picked a random 1 Question. And gives this Question to the RCB Team. problem statement below

Consider a 2-D Coordinate with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates y1(1) … y1(n) and n cities on the northern bank with x-coordinates y2(1) … y2(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. When connecting cities, you can only connect city i on the northern bank to city i on the southern bank.
Maximum number of bridges that can be built to connect north-south pairs with the above-mentioned constraints. Can you help to Solve this Question Because you're fan of RCB

Input Format
Take a number n, representing the number of City.
next Line Contains n n pair of numbers, representing the x-coordinates north city and x-coordinates of south cities.

Constraints
0 <= n <= 1000

Output Format
A number representing the count of maximum number of non-overlapping bridges.

Sample Input
4
6 2 
4 3 
2 6
1 5
Sample Output
2
Explanation
For the north-south pairs(2, 6) and (1, 5) the bridges can be built. We can consider other pairs also, but then only one bridge can be built because more than one bridge built will then cross each other.
*/

// 785. Is Graph Bipartite

// Graph -> Array of array

// colouring algo.
    
    // -1 - unvisited, 0 - red, 1 - green
    public boolean isBipartite(int graph[][],int vis[],int src){
        int color = 0;
        boolean isCycle = false;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();
                
                if(vis[rvtx] != -1){// visited already
                    isCycle = true;
                    if(vis[rvtx] != color)
                        return false;
                    continue;
                }
                
                vis[rvtx] = color; // mark the neighbours visited
                
                // add unvisited neighbours in que
                for(int v: graph[rvtx]){
                    if(vis[v] == -1){
                        que.addLast(v);
                    }
                }
            }
            
            color = (color+1)%2; // it must be 0 or 1
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean ans = true;
        int vis[] = new int[n];
        Arrays.fill(vis,-1);
        
        for(int i = 0;i< n;i++){
            if(vis[i] == -1)
            ans = ans && isBipartite(graph,vis,i);
        }
        
        return ans;
    }

// 994. Rotting Oranges

// 2d array format of graph
// Non-cycle bfs
    
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
    
    int n = grid.length;
    int m = grid[0].length;
    
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    LinkedList<Integer> que = new LinkedList<>();
    int freshOranges = 0;

    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(grid[i][j] == 2) que.addLast(i*m+j);
            if(grid[i][j] == 1) freshOranges++;
        }
    }

    if(freshOranges == 0) return 0;
    int time = 0;
    while(que.size() != 0){
        int size = que.size();
        while(size-->0){
            int idx = que.removeFirst();
            int r = idx / m;
            int c = idx % m;

            for(int d = 0; d < 4; d++){
                int x = r + dir[d][0];
                int y = c + dir[d][1];

                if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1){
                    grid[x][y] = 2;
                    freshOranges--;
                    que.addLast(x * m + y);
                    if(freshOranges == 0) return time + 1;
                }
            }
        }
        time++;
    }

    return -1;
}

// 256. Walls and Gates -> https://www.lintcode.com/problem/walls-and-gates/

    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length)
            return;

        int m = rooms.length;
        int n = rooms[0].length;

        int dir[] = = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        LinkedList<Integer> que = new LinkedList<>();
        int dist = 0; int countEmptyRooms = 0;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(rooms[i][j] == 0) //gates
                    que.addLast(i*n+j); // 2d -> 1d
                if(rooms[i][j] == (int)Integer.MAX_VALUE - 1) // free room
                    countEmptyRooms++;
            }
        }

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();
                
                // 1d -> 2d
                int r = rvtx/n;
                int c = rvtx%n;

                for(int d = 0;d < dir.length;d++){
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                 if(x>=0 && y>=0 && x< n && y<m && rooms[x][y] == (int)Integer.MAX_VALUE - 1){
                    countEmptyRooms--;
                    rooms[x][y] = dist + 1; 
                    que.addLast(x*m+y);
                    if(countEmptyRooms == 0)
                        return;
                 }
                }
            }
            dist++;
        }
    }

    public static void main(String args[]){

        constructGraph();
        System.out.println(searchEdge(0,2));
        removeEdge(0,1);
        removeVertex(2);
        display();
    }
}