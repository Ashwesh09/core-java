#include<stdio.h>
#include<stdlib.h>

struct node
{
    int info;
    struct node *link;

};

struct node *first = NULL;

//typedef struct node NODE;

void insert_front(int item)
{
    struct node *newnode;
    newnode = malloc(sizeof(struct node));
    newnode->info=item;
    newnode->link=first;
    first = newnode;
}
 int display()
 {
     if(first == NULL)
     {
         printf("Empty");
         return 0;
     }
     struct node *temp;
     temp=first;
     while(temp!=NULL)
     {
         printf("%d\n",temp->info);
         temp=temp->link;
     }
 }

void main()
{
    int input,item;
    for(;;)
    {
        printf("\n1 to insert rear");
        printf("\n2 to delete front");
        printf("\n3 to display the content");
        printf("\n4 to exit");
        printf("\n enter the choice:");
        scanf("%d",&input);
        switch(input)
        {
            case 1: 
                    printf("\nEnter the item:");
                    scanf("%d",&item);
                    insert_front(item);
                    display(first);
                    break;
            case 2: 
                    display(first);
                    break;
            case 3: 
                    display(first);
                    break;
            case 4: 
                    exit(0);
                    break;
            default: 
                    printf("\nInvalid choice.Try again!");
                    continue;                      
        }
    }
}