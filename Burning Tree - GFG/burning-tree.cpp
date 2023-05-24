//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};


Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
//User function Template for C++

/*
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution 
{
  public:
    int minTime(Node* root, int target) 
    {
        if(nullptr == root) return 0;
        unordered_map<Node*,Node*> mParent;
        unordered_set<Node*> mVisited;
        queue<Node*> q;
        q.push(root);
        //filling mParent
        Node* nodeTarget = nullptr;
        while(!q.empty())
        {
            int size =q.size();
            for(int i=0;i<size;i++)
            {
                Node* curr=q.front();
                if(curr->data == target) 
                    nodeTarget=curr;
                q.pop();
                if(curr->left)
                {
                    mParent.insert(make_pair(curr->left,curr));
                    q.push(curr->left);
                }
                if(curr->right)
                {
                    mParent.insert(make_pair(curr->right,curr));
                    q.push(curr->right);
                }
            }
        }

        //Traversing radially outward BFS from target till we reach k dist
        q.push(nodeTarget);
        int k=0;
        while(!q.empty())
        {
            k++;
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                Node* curr=q.front();
                q.pop();
                mVisited.insert(curr);
                if(mParent.find(curr)!=mParent.end()&& mVisited.find(mParent[curr])==mVisited.end())
                    q.push(mParent[curr]);
                if(curr->left && mVisited.find(curr->left)==mVisited.end())
                    q.push(curr->left);
                if(curr->right && mVisited.find(curr->right)==mVisited.end())
                    q.push(curr->right);
            }
        }

        return k-1;
    }
};

//{ Driver Code Starts.

int main() 
{
    int tc;
    scanf("%d ", &tc);
    while (tc--) 
    {    
        string treeString;
        getline(cin, treeString);
        // cout<<treeString<<"\n";
        int target;
        cin>>target;
        // cout<<target<<"\n";

        Node *root = buildTree(treeString);
        Solution obj;
        cout<<obj.minTime(root, target)<<"\n"; 

        cin.ignore();

    }


    return 0;
}

// } Driver Code Ends