#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

class Node
{
public:
    int data;
    Node *left = nullptr;
    Node *right = nullptr;
    Node(int data)
    {
        this->data = data;
    }
};

int idx = 0;
Node *constructTree(vector<int> &arr)
{

    if (idx == arr.size() || arr[idx] == -1)
    {
        idx++;
        return nullptr;
    }
    Node *node = new Node(arr[idx++]);
    node->left = constructTree(arr);
    node->right = constructTree(arr);
    return node;
}

void inOrder(Node *node)
{
    if (node == nullptr)
        return;

    inOrder(node->left);
    cout << node->data << " ";
    inOrder(node->right);
}

int size(Node *node)
{
    return node == nullptr ? 0 : size(node->left) + size(node->right) + 1;
}

int height(Node *node)
{
    return node == nullptr ? -1 : max(height(node->left), height(node->right)) + 1; // for no of edges: -1, and in terms of no of nodes return 0;
}

int maximum(Node *node)
{
    return node == nullptr ? -1e8 : max(max(maximum(node->left), maximum(node->right)), node->data);
}

int minimum(Node *node)
{
    return node == nullptr ? 1e8 : min(min(minimum(node->left), minimum(node->right)), node->data);
}

bool find(Node *node, int data)
{
    if (node == nullptr)
        return false;
    if (node->data == data)
        return true;
    return find(node->left, data) || find(node->right, data);
}

bool rootToNodePath(Node *node, int data, vector<Node *> &path)
{
    if (node == nullptr)
        return false;
    if (node->data == data)
    {
        path.push_back(node);
        return true;
    }
    bool res = rootToNodePath(node->left, data, path) || rootToNodePath(node->right, data, path);
    if (res)
        path.push_back(node);
    return res;
}

vector<Node*> rootToNodePath02(Node *node,int data){

    if(node==nullptr)
    return {};
    if(node->data==data){
        vector<Node*> ba;
        ba.push_back(node);
        return ba;
    }
    vector<Node*> la=rootToNodePath02(node->left,data);
    if(la.size()!=0){
        la.push_back(node);
        return la;
    }
    vector<Node*> ra=rootToNodePath02(node->right,data);
    if(ra.size()!=0){
        ra.push_back(node);
        return ra;
    }
    return {};
}

// LCA

Node* lowestCommonAncestor(Node *node, Node *p, Node *q) {
            vector <Node* > list1; 
            rootToNodePath(node,p->data,list1);
            vector <Node*> list2; 
            rootToNodePath(node,q->data,list2);

            int i = list1.size()-1;
            int j = list2.size()-1;

            Node* LCA = nullptr;
            while(i>=0 && j>=0){
            if(list1[i]==list2[j]) 
                LCA = list1[i];

            i--;
            j--;
           }
           return LCA;
    }
    

// Distance b/w two nodes in terms of edges

int distancebwNodes(Node *node,Node *p,Node *q){

            vector <Node* > list1,list2; 
            bool res=rootToNodePath(node,p->data,list1) && rootToNodePath(node,q->data,list2);
            if(!res)
            return 0;

            int i=list1.size()-1;int j=list2.size()-1;
            int LCA=0;
            while(i>=0 && j>=0){
                if(list1[i]==list2[i])
                LCA++;
            }

            int ans=list1.size()+list2.size()-2*LCA;

            return ans;
}

// Diameter

    pair<int,int> diameter(Node *root){
        if(root==nullptr){
            return make_pair(0,-1);
        }
        pair<int,int> la=diameter(root->left);
        pair<int,int> ra=diameter(root->right);
        
        int dia=max({la.first,ra.first,la.second+ra.second+2});
        int ht=max(la.second,ra.second)+1;
        
        return make_pair(dia,ht);
    }
    int diameterOfBinaryTree(Node* root){
        return diameter(root).first;
    }



void display(Node *node)
{
    if (node == nullptr)
        return;
    string str = "";
    str += node->left != nullptr ? to_string(node->left->data) : ".";
    str += " <- " + to_string(node->data) + " -> ";
    str += node->right != nullptr ? to_string(node->right->data) : ".";
    cout << str << endl;

    display(node->left);
    display(node->right);
}

void solve()
{
    vector<int> arr = {10, 20, 30, 40, -1, -1, 50, -1, -1, 60, 70, -1, 80, -1, -1, -1, 90, 100, -1, 120, -1, -1, 110, 130, -1, -1, -1};
    // vector<int> arr = {-15, 5, -8, 2, -1, -1, 6, -1, -1, 1, -1, -1, 6, 3, -1, -1, 9, -1, 0, 4, -1, -1, -2, 10, -1, -1, -1};

    Node *root = constructTree(arr);
    // inOrder(root);
    display(root);

}

int main()
{
    solve();
    return 0;
}
