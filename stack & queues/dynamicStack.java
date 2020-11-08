// This particular implementation makes my code modular and reusable 
// as I have used my pre-existing code of static stack and made it dynamic by 
// over-riding the pre-existing push(int data) in my static stack class
// with the one as shown below so that each time my stack gets filled up during the runtime a new
// memory is allocated to it and it increases by its double of initial size....

                                                                                       //.... @kB

public class dynamicStack extends stack{

    dynamicStack(){
        super();
    }

    dynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int data){

        if(super.size()==super.capacity()){
            int cap=super.capacity();
            
            int tmp[]=new int[cap];
            int idx=cap-1;
            
            while(super.size() != 0) 
            tmp[idx--] = super.pop(); 

            super.intializeValues(cap*2);
            
            idx = 0;
            
            while(idx < cap) 
            super.push(temp[idx++]);
        }
            super.push(data);
    } 

}