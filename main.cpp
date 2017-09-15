#include <iostream>
#include <stdio.h>
#include "BubbleSort.cpp"
#include "SelectionSort.cpp"
#include "Insertion_sort.cpp"
#include "merge.cpp"
#include <ctime>

using namespace std;

void Llenado(int A[],int t);
void imprimir(int A[],int t);

int main()
{
    ///-------------------------BubbleSort-----------------------------------------------
    cout <<"---------------------BubbleSort-------------------"<< endl;
    cout <<""<< endl;
	cout <<"Mejor caso"<< endl;
	cout <<""<< endl;
    for(int t = 10;t<400;t+=40){
    	int a[t];
    	Llenado(a,t);
    	clock_t cl1 = clock();
    	BubbleSort(a, t);
    	clock_t t1 = clock();
    	cout <<"Elementos: "<<t<<" Tiempo : "<< clock()-t1 << " ms" << endl;
    	cout<<""<<endl;
    	
	}
	
    
    
    cout <<""<< endl;
    cout <<""<< endl;

    ///-------------------------SelectionSort-----------------------------------------------
    cout <<"---------------------SelectionSort-------------------"<< endl;
    cout <<""<< endl;

    
    //SelectionSort(b, 6);
    cout <<"Tiempo : "<< ""<< " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;




///------------------------------InsertionSort-----------------------------------------------
    cout <<"---------------------InsertionSort-------------------"<< endl;
    cout <<""<< endl;

    
    //Insertion(c, 6);
    cout <<"Tiempo : "<<  ""<< " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

   


///------------------------------MergeSort-----------------------------------------------
    cout <<"---------------------MergeSort-------------------"<< endl;
    cout <<""<< endl;

    
    //mergesort(d, d + 6, sorted);
    cout <<"Tiempo : "<<  ""<< " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

    


    return 0;
}
    
void Llenado (int A[],int t) 
{

for(int i = 0 ; i < t; i++)
	 A[i]=i;

}

void imprimir(int A[],int t){
	cout <<"Arreglo"<< endl;
	for (int i = 0 ; i <= t-1; i++)
        cout << A[i]<<" ";
    cout <<""<< endl;
    cout <<""<< endl;
}
