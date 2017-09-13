//#include "Insertion_sort.h"

template <class T>
void Insertion (T *Array, int size){
    T temp;
    int i;
    for(int j=1; j<size; j++){
        temp=Array[j];
        i=j-1;
        while(i>=0 && Array[i]>temp){
            Array[i+1]=Array[i];
            i=i-1;
        }
        Array[i+1]=temp;
    }

}
