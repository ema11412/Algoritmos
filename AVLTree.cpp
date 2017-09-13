#include "AVLTree.h"

template <class T>
Node<T>* AVLTree<T>::insert(Node<T> *node, T key)
{
    if(node == nullptr)
    {
        node = (Node<T>*) malloc(sizeof(Node<T>));
        node->value = key;
        node->left = nullptr;
        node->right = nullptr;
    }
    else
    if(key > node->value)
    {
        node->right = insert(node->right, key);
        if(BF(node) == -2)
            if(key > node->right->value)
                node = rigthright(node);
            else
                node = rightleft(node);
    }
    else
    if(key < node->value)
    {
        node->left = insert(node->left, key);
        if(BF(node) == 2)
            if(key < node->left->value)
                node = leftleft(node);
            else
                node = leftright(node);
    }

    node->height = height(node);

    return(node);
}

template <class T>
Node<T>* AVLTree<T>::deleteNode(Node<T> * node, T key)
{
    Node<T> *p;

    if(node == nullptr)
    {
        return nullptr;
    }
    else
    if(key > node->value)
    {
        node->right = deleteNode(node->right, key);
        if(BF(node) == 2)
            if(BF(node->left) >= 0)
                node = leftleft(node);
            else
                node = leftright(node);
    }
    else
    if(key < node->value)
    {
        node->left = deleteNode(node->left,key);
        if(BF(node) == -2)
            if(BF(node->right)<=0)
                node = rigthright(node);
            else
                node = rightleft(node);
    }
    else
    {
        if(node->right!=NULL)
        {
            p = node->right;

            while(p->left!= NULL)
                p = p->left;

            node->value = p->value;
            node->right = deleteNode(node->right, p->value);

            if(BF(node) == 2)
                if(BF(node->left) >= 0)
                    node = leftleft(node);
                else
                    node = leftright(node);
                }
        else
            return(node->left);
    }

    node->height = height(node);
    return(node);
}

template <class T>
bool AVLTree<T>::search(Node<T> *node, T key)
{
    if(node == nullptr)
    {
        return false;
    }
    else if(key < node->value)
    {
        return search(node->left, key);
    }
    else if(node->value < key)
    {
        return search(node->right, key);
    }
}

template <class T>
void AVLTree<T>::preorder(Node<T> *node)
{
    if(node != nullptr)
    {
        printf("%d(Bf=%d)", node->value, BF(node));
        preorder(node->left);
        preorder(node->right);
    }
}

template <class T>
void AVLTree<T>::inorder(Node<T> *node)
{
    if(node != NULL)
    {
        inorder(node->left);
        printf("%d(Bf=%d)", node->value, BF(node));
        inorder(node->right);
    }
}

template <class T>
int AVLTree<T>::height(Node<T> * node)
{
    int lh,rh;
    if(node == nullptr)
        return(0);

    if(node->left == nullptr)
        lh = 0;
    else
        lh = 1 + node->left->height;

    if(node->right == nullptr)
        rh = 0;
    else
        rh = 1 + node->right->height;

    if(lh > rh)
        return(lh);

    return(rh);

}

template <class T>
Node<T>* AVLTree<T>::rotateright(Node<T> *node)
{
    Node<T> *auxNode;
    auxNode = node->left;
    node->left = auxNode->right;
    auxNode->right = node;
    node->height = height(node);
    auxNode->height = height(auxNode);

    return(auxNode);

}

template <class T>
Node<T>* AVLTree<T>::rotateleft(Node<T> *node)
{
    Node<T> *auxNode;
    auxNode= node->right;
    node->right = auxNode->left;
    auxNode->left = node;
    node->height = height(node);
    auxNode->height = height(auxNode);

    return(auxNode);
}

template <class T>
Node<T>* AVLTree<T>::rigthright(Node<T> *node)
{
    node = rotateleft(node);
    return(node);
}

template <class T>
Node<T>* AVLTree<T>::leftleft(Node<T> *node)
{
    node = rotateright(node);
    return(node);
}

template <class T>
Node<T>* AVLTree<T>::leftright(Node<T> *node)
{
    node->left = rotateleft(node->left);
    node = rotateright(node);

    return(node);
}

template <class T>
Node<T>* AVLTree<T>::rightleft(Node<T> *node)
{
    node->right = rotateright(node->right);
    node = rotateleft(node);

    return(node);
}

template <class T>
int AVLTree<T>::BF(Node<T> *node)
{
    int lh, rh;
    if( node == nullptr)
        return(0);

    if(node->left ==  nullptr)
        lh = 0;
    else
        lh = 1 + node->left->height;

    if(node->right == nullptr)
        rh = 0;
    else
        rh = 1 + node->right->height;

    return(lh - rh);
}

int main(){
return 0;
}

