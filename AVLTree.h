#ifndef AVLTREE_AVLTREE_H
#define AVLTREE_AVLTREE_H

#include <cstdio>
#include "Node.h"

template <class T>
class AVLTree
{
public:

    Node<T> *insert(Node<T> *node, T key);
    Node<T> *deleteNode(Node<T> *node, T key);
    bool search(Node<T> *node, T key);
    void preorder(Node<T> *node);
    void inorder(Node<T> *node);
    int height( Node<T> *node);
    Node<T> *rotateright(Node<T> *node);
    Node<T> *rotateleft(Node<T> *node);
    Node<T> *rigthright(Node<T> *node);
    Node<T> *leftleft(Node<T> *node);
    Node<T> *leftright(Node<T> *node);
    Node<T> *rightleft(Node<T> *node);
    int BF(Node<T> *node);
};


#endif //AVLTREE_AVLTREE_H
