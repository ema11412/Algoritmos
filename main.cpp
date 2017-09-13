#include <iostream>
#include <stdio.h>
#include "BubbleSort.cpp"
#include "SelectionSort.cpp"
#include "Insertion_sort.cpp"
#include "merge.cpp"
#include <ctime>

using namespace std;




int main()
{
    ///-------------------------BubbleSort-----------------------------------------------
    cout <<"---------------------BubbleSort-------------------"<< endl;
    cout <<""<< endl;

    int a[] = {2,5,9,1,4,2};

    cout <<"original"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << a[i]<<" ";

    cout <<""<< endl;
    cout <<""<< endl;

    clock_t cl = clock();
    BubbleSort(a, 6);
    cout <<"Tiempo : "<< (clock()-cl) << " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

    cout <<"ordenado"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << a[i]<<" ";

    cout <<""<< endl;
    cout <<""<< endl;

    ///-------------------------SelectionSort-----------------------------------------------
    cout <<"---------------------SelectionSort-------------------"<< endl;
    cout <<""<< endl;

    int b[] = {2,5,9,1,4,2};

    cout <<"original"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << b[i]<<" ";

    cout <<""<< endl;
    cout <<""<< endl;

    clock_t cl1 = clock();
    SelectionSort(b, 6);
    cout <<"Tiempo : "<< (clock()-cl1)<< " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

    cout <<"ordenado"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << b[i]<<" ";
    cout <<""<< endl;
    cout <<""<< endl;


///------------------------------InsertionSort-----------------------------------------------
    cout <<"---------------------InsertionSort-------------------"<< endl;
    cout <<""<< endl;

    int c[] = {9,5,55,1,2,91};

    cout <<"original"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << c[i]<<" ";

    cout <<""<< endl;
    cout <<""<< endl;

    clock_t cl2 = clock();
    Insertion(c, 6);
    cout <<"Tiempo : "<< (clock()-cl2) << " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

    cout <<"ordenado"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << c[i]<<" ";
    cout <<""<< endl;
    cout <<""<< endl;


///------------------------------MergeSort-----------------------------------------------
    cout <<"---------------------MergeSort-------------------"<< endl;
    cout <<""<< endl;

    int d[] = {9,5,55,1,2,91};
    int sorted[6];
    cout <<"original"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << d[i]<<" ";

    cout <<""<< endl;
    cout <<""<< endl;

    clock_t cl3 = clock();
    mergesort(d, d + 6, sorted);
    cout <<"Tiempo : "<< (clock()-cl3) << " ms" << endl;

    cout <<""<< endl;
    cout <<""<< endl;

    cout <<"ordenado"<< endl;
    for (int i = 0 ; i <= 6-1; i++)
        cout << sorted[i]<<" ";
    cout <<""<< endl;
    cout <<""<< endl;


    return 0;
}
