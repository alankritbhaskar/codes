//Program to return the (x,y) coordinate of an 
//element in 2-d row wise and column wise sorted array

import java.util.*;



class solution{
    
static ArrayList<Integer> index(int arr[][],int m,int n,int key){
    ArrayList<Integer> v=new ArrayList<>();
	int i=0;int j=n-1;
	while(i>=0 && i<m && j>=0 && j<n){
		if(arr[i][j]==key)
		 {
		 	v.add(i);
		 	v.add(j);
		 	return v;
		 }
		 else if(arr[i][j]>key)
		 	j--;
		 else
		 	i++;
	}
	v.add(-1);
	return v;
}

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            		
	    int m=sc.nextInt();
	    int n=sc.nextInt();

        int arr[][]=new int[m][n];
		ArrayList<Integer> v=new ArrayList<>();
		
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
			}
		}

		int key=sc.nextInt();
        
        v=index(arr,m,n,key);
        
        if(v.size()==2){
            int x=v.get(0)+1;
            int y=v.get(1)+1;
        System.out.println("x coordinate: "+x+" y coordinate: "+y);

}
        else
        System.out.println(v.get(0));

        }
    }
}