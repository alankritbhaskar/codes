#include <bits/stdc++.h>
using namespace std;

class Edge{
    public:
    int v=0;
    int w=0;

    Edge(int v,int w){
        this->v=v;
        this->w=w;
    }
};

int N=7;
vector<vector<Edge>> graph(N,vector<Edge>());

//addition of bidirectional edge in graph
void addEdge(int u,int v,int w){
graph[u].push_back(Edge(v,w));
graph[v].push_back(Edge(u,w));
}

 void display(){
 //for displaying the graph
 for(int i=0;i<N;i++){
     cout<<i<<"--> ";
     for(Edge e:graph[i]){
         cout<<"("<<to_string(e.v)<<","<<to_string(e.w)<<") ";
     }
     cout<<"\n";
 }
 }

 int searchEdge(int u,int v){
 // returns the index of the vertex u i.e. the start vertex if the edge u->v is present int the graph
 for(int i=0;i<graph[u].size();i++){
     Edge e=graph[u][i];
     if(e.v==v)
     return i;
 }
 return -1;
 }

 void removeEdge(int u,int v){
 // removes the edge u->v from the graph if present
 int s1=searchEdge(u,v);// index of vertex u is stored here 
 graph[u].erase(graph[u].begin()+s1);
 int s2=searchEdge(v,u);// index of vertex  is stored here
 graph[v].erase(graph[u].begin()+s2);
 }

 void removeVertex(int a){
 // remove a vertex from the graph i.e. remove all the edges connecting this vertex to any other
 for(int i=graph[a].size()-1;i>=0;i--){
 Edge e=graph[a][i];
 removeEdge(a,e.v);
 } 
 }

// DFS......

// 1. Mark the src
// 2. For all unvisited neighbours
//    2.1. Call DFS for neighbours
// 3. Unmark (only for all paths)


 // Has path between src to dest

 bool hasPath(int src,int dest,vector<bool> &vis){
 if(src == dest)
 return true;

 vis[src]=true;// 1. Mark the src 
 bool res= false;

 for(Edge e: graph[src]){ // 2
     if(!vis[e.v]){
        res= res || hasPath(e.v,dest,vis);
     }
 }
 return res;
 }

 // All paths from src to dest

 int allPaths(int src,int dest,vector<bool> &vis,string path){
 if(src == dest)
 {
     cout<<path<<" "<<dest<<endl;
     return 1;
 }

 int count= 0;
 vis[src]= true;
 for(Edge e: graph[src]){
     if(!vis[e.v]){
         count += allPaths(e.v,dest,vis,path+to_string(src));
     }
 }
 vis[src]= false;
 return count;
 }

 // Smallest path wrt length

 pair<int,string> smallestPath(int src,int dest,vector<bool> &vis){
 if(src == dest){
     pair<int,string> base(0,to_string(src));
     return base;
 }

 vis[src]= true;
 pair<int,string> myAns(1e8,"");

 for(Edge e: graph[src]){
     if(!vis[e.v]){
         pair<int,string> recAns= smallestPath(e.v,dest,vis);
         if(recAns.first+1 < myAns.first){
             myAns.first= recAns.first+1;
             myAns.second= to_string(src)+recAns.second;
         }
     }
 }
 vis[src]= false;
 return myAns;
 }

// Smallest Path wrt weight
   // Pair -> (weight,path)

pair<int,string> smallestPathWeight(int src,int dest,vector<bool> &vis){
    if(src == dest){
        pair<int,string> base(0,to_string(src)+"");// jab src= dest then 0 wt. is employed to get to the destination
        return base;
    }

    vis[src]= true;
    pair<int,string> myAns(1e8,"");
    for(Edge e: graph[src]){
        if(!vis[e.v]){
            pair<int,string> recAns= smallestPathWeight(e.v,dest,vis);
            if(recAns.first+e.w < myAns.first){
                myAns.first= recAns.first+e.w;
                myAns.second= to_string(src)+recAns.second;
            }
        }
    }
    vis[src]= false;
    return myAns;
}


 
 void constructGraph(){
    addEdge(0, 1, 10);
    addEdge(0, 3, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);
    display();
 }


  int main(){ 

  constructGraph();
  vector<bool> vis(N,false);

  return 0;
  }




