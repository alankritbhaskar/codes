import java.util.ArrayList;

public class heap{

    public class MyHeap{
        ArrayList<Integer> arr=new ArrayList<>();

        private void constructHeap(int data[]){
        for(int d: data)
        arr.add(d);

        for(int i=arr.size()-1;i>=0;i--)
            downHeapify(i);
        }

        private void downHeapify(int pi){
        int maxIdx=pi;
        int lci=2*pi+1;
        int rci=2*pi+2;

        if(lci<arr.size() && arr.get(lci)>arr.get(maxIdx))
        maxIdx=lci;
        if(rci<arr.size() && arr.get(rci)>arr.get(maxIdx))
        maxIdx=rci;

        if(maxIdx!=pi){
            swap(pi,maxIdx);
            downHeapify(maxIdx);
        }

        }

        private void swap(int i,int j){
            int v1=arr.get(i);
            int v2=arr.get(j);

            arr.set(i,v2);
            arr.set(j,v1);
        }
    }
}