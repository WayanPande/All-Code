#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <conio.h>

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

void deleteTree(struct node *tree)
{
    if (tree != NULL)
    {
        deleteTree(tree->left);
        deleteTree(tree->right);
        free(tree);
    }
}

void preorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        printf("%d   ", tree->data);
        preorderTraversal(tree->left);
        preorderTraversal(tree->right);
    }
}

void inorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        inorderTraversal(tree->left);
        printf("%d   ", tree->data);
        inorderTraversal(tree->right);
    }
}

void postorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        postorderTraversal(tree->left);
        postorderTraversal(tree->right);
        printf("%d   ", tree->data);
    }
}

struct node *insertNode(struct node *tree, int bil)
{
    if (tree == NULL)
    {
        tree = (struct node *)malloc(sizeof(struct node *));
        tree->data = bil;
        tree->left = NULL;
        tree->right = NULL;
    }
    else
    {
        if (tree->data > bil)
        {
            tree->left = insertNode(tree->left, bil);
        }
        else
        {
            tree->right = insertNode(tree->right, bil);
        }
    }
    return tree;
}

int main()
{
    int bil, jumlahBilangan, i, pilihan;
    struct node *tree;
    tree = NULL;
    do
    {
        printf("\nNama: Alim Ikegami\n");
        printf("NIM : 1908561046\n");
        printf("1. Buat binary search tree baru\n");
        printf("2. Exit\n");
        printf("Masukkan pilihan: ");
        scanf("%i", &pilihan);
        switch (pilihan)
        {
        case 1:
            printf("Masukkan jumlah simpul/node: ");
            scanf("%i", &jumlahBilangan);
            for (i = 0; i < jumlahBilangan; i++)
            {
                printf("Masukkan bilangan ke-%i: ", i + 1);
                scanf("%i", &bil);
                tree = insertNode(tree, bil);
            }
            printf("Preorder traversal : ");
            preorderTraversal(tree);
            printf("\n");
            printf("Inorder traversal  : ");
            inorderTraversal(tree);
            printf("\n");
            printf("Postorder traversal: ");
            postorderTraversal(tree);
            printf("\n");
            printf("Press any key to continue....\n");
            getch();
            break;
        default:
            if (pilihan != 2)
            {
                printf("Masukan anda tidak valid! Masukkan pilihan 1 atau 2!\n");
            }
            break;
        }
        deleteTree(tree);
        tree = NULL;
    } while (pilihan != 2);

    return 0;
}