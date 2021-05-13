#include <vector>
#include <iostream>

using namespace std;

class Edge{
public:
int v = 0;
int w = 0; // weight

Edge(int v,int w){
    this->v = v;
    this->w = w;
}
};



//addition of bidirectional edge in graph
void addEdge(vector<vector<Edge>> &graph,int u,int v,int w){
graph[u].push_back(Edge(v,w));
graph[v].push_back(Edge(u,w));
}

void display(vector<vector<Edge>> &graph){
 //for displaying the graph
 for(int i=0;i<graph.size();i++){
     cout<<i<<"--> ";
     for(Edge e:graph[i]){
          cout << "(" + to_string(e.v) + ", " + to_string(e.w) + ") ";
        }

        cout << endl;
    }
 }

void constructGraph(){
    int N = 9;
    vector<vector<Edge>> graph(N,vector<Edge>());

    addEdge(graph, 0, 1, 10);
    addEdge(graph,0, 3, 10);
    addEdge(graph,1, 2, 10);
    addEdge(graph,2, 3, 40);
    addEdge(graph,3, 4, 2);
    addEdge(graph,4, 5, 2);
    addEdge(graph,4, 6, 8);
    addEdge(graph,5, 6, 3);
    addEdge(graph,2,5,1);
    display();
}

void solve()
{
     constructGraph();
}

int main(){
    solve();
    return 0;
}