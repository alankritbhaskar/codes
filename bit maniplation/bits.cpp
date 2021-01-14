#include <iostream>
using namespace std;

int offToON(int n, int k)
{
int mask= (1<<k);
int ans= (n | mask);
return ans;
}

int onToOff(int n, int k)
{
int mask= ~(1<<k);
int ans= (n & mask);
return ans;
}

bool isBitSet(int n, int k)
{
int mask= (1<<k);
int ans= (n & mask);
if(ans != 0)
return true;
return false;
}

// Leetcode 191

int hammingWeight1(uint32_t n)
{
int count= 0;
for(int i=0;i<32;i++){
    int mask= (1<<i);
    if((n & mask) !=0 )
    count++;
}
return count;
}

int hammingWeight2(uint32_t n)
{
    int count= 0;
    int bitsCount = 0;
    while (n != 0 && bitsCount < 32)
    {
        if ((n & 1) != 0) // LSB is checked each time and the number is then right shift by 1
            count++;
        n = (n>>1);
        bitsCount++;
    }

    return count;
}

int hammingWeight3(uint32_t n)
{
int count= 0;
while(n != 0){
    count++;
    n= (n & (n-1));
}
return count;
}

int main(){
    int n=7;

}