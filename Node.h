#ifndef AVLTREE_NODE_H
#define AVLTREE_NODE_H

#include <cstdlib>

template <class T>
class Node
{
public:
    Node<T>* left;
    Node<T>* right;
    T value;
    int height;

    Node(T _value);
    ~Node();

    bool operator ==(T key);
    bool operator !=(T key);
    Node<T>& operator =(T key);
};

#endif //AVLTREE_NODE_H
