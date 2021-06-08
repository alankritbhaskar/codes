import java.util.ArrayList;
public class gtree{

    public static class Node{
        int data = 0;
        ArrayList<Node> childs;

        Node(int data){
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int size(Node node){
        if(node == null) // if node is passed as null
        return 0;

        int sz = 0;
        for(Node child: node.childs)
            sz += size(child);
        return sz+1;
    }

    public int height(Node node){
        int h = -1;
        for(Node child: node.childs)
         h = Math.max(h,height(child));
         
        return h+1;
    }

    public int maximum(Node node){
        int maxEle = node.data;
        for(Node child: node.childs)
            maxEle = Math.max(maxEle,maximum(child));

        return maxEle;
    }

    public int find(Node node){
        if(node.data == data)
        return true;

        for(Node child: node.childs){
            if(find(child,data))
            return true;
        }

        return false;
    }

    public static void main(){

    }

}