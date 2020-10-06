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
  return 0;
  }




