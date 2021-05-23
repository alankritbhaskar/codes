import java.util.*;

public class greedy{

// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // Create an array of {st,et}
        if(n == 0)
            return 0;
            
        int meet[][] = new int[n][2];
        for(int i = 0;i < n;i++){
            meet[i][0] = start[i];
            meet[i][1] = end[i];
        }
        
        Arrays.sort(meet,(a,b)->{
            return a[1]-b[1]; // this - other -> default:- ascending            
        });
        
        int c = 1;
        int endTime = meet[0][1];
        
        for(int i = 1;i < n;i++){
            if(endTime < meet[i][0]){
                c++;
                endTime = meet[i][1];
            }
            else
                continue;
        }
        return c;
    }


    public static void main(String args[]){

    }

    
}