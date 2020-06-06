#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define __DEFAULT __INT_MAX

typedef struct ListNode{
	int val;
	struct ListNode *next;
	struct ListNode *prev;
} ListNode;

typedef struct LinkedList{	//Singly-linked list
	ListNode *head;
	ListNode *tail;
} LinkedList;

LinkedList* createList();
bool offerHead(LinkedList*, int);//Adds an int element to the list.
bool popAll(LinkedList*, int);	//Removes all instances of the int from list.
bool popAll2(LinkedList*, int);	//Removes all instances of the int from list.
void printList(LinkedList*);	//Prints the linked list
int length(LinkedList*);	// Returns the size of the list, no head/tail.
bool updateListElements(LinkedList*, int);// Increments or decrements the list
					  // by the specified amount.
void deleteList(LinkedList**);	//Destructs a LinkedList				
					  
const ListNode* HEAD;
const ListNode* TAIL;

int
main(int argc, char** argv){
	ListNode* bhead = NULL; 
	ListNode *btail = NULL;
	bhead = (struct ListNode*) malloc(sizeof(struct ListNode));
	bhead->val = __DEFAULT;
	btail = (struct ListNode*) malloc(sizeof(struct ListNode));
	btail->val = __DEFAULT;
	//wire them together
	bhead->next = btail;
	btail->prev = bhead;
	ListNode* p = bhead;
	while(p != NULL){
		printf("%d\n", p->val);
		p = p->next;
	}
	puts("Attempting pointer to pointer iteration:");
	ListNode** pp = &bhead->next;
	while(*pp != NULL){
		printf("%d\n", (*pp)->val);
		pp = &(*pp)->next;
	}
	//////////////////////////
	puts("\n\nPart II: LL experimentation");
	LinkedList* list = createList();
	puts("***ORIGINAL LIST***");
	offerHead(list, 108);
	offerHead(list, 69);
	offerHead(list, 777);
	offerHead(list, 999);
	offerHead(list, 777);
	offerHead(list, 777);
	offerHead(list, 987);
	printList(list);
	puts("Removing all of the 777's");
	popAll2(list, 777);
	printList(list);
	printf("%s%d\n", "Size of LinkedList: ", length(list));
	puts("Incrementing all of the list elements:");
	updateListElements(list, 1);
	printList(list);
	deleteList(&list);
	length(list);
	puts("Deleted List!");
	/* free(&list); */
	/* if(list->head == NULL) puts("Successfully cleaned up enviornment."); */
	printf("New length = %d\n", length(list));
	return 0;	
}

LinkedList* createList(){
	LinkedList* _list = (LinkedList*) malloc(sizeof(struct LinkedList));
	ListNode* _head = (ListNode*) malloc(sizeof(struct ListNode));
	ListNode* _tail = (ListNode*) malloc(sizeof(struct ListNode));
	_head->val = __DEFAULT;
	_head->next = _tail;
	_head->prev = NULL;
	_tail->val = __DEFAULT;
	_tail->prev = _head;
	_tail->next = NULL;
	_list->head = _head;
	_list->tail = _tail;
	HEAD = _head;
	TAIL = _tail;
	return _list;
}

void deleteList(LinkedList **_list){
	free(&(*_list)->head);
	free(&(*_list)->tail);
	free(*_list);
	*_list = NULL;
}

bool offerHead(LinkedList *_list, int item){
	ListNode **headp = &(*_list).head;
	ListNode* new = (ListNode*) malloc(sizeof(struct ListNode));
	new->val = item;
	new->next = (*headp)->next;
	new->prev = *headp;
	(*headp)->next->prev = new;
	(*headp)->next = new;
	free(headp);	
	return (*headp)->next->val == item ? true : false;
}

bool popAll2(LinkedList* _list, int item){
	ListNode **ptr = &(_list)->head->next;
	while(*ptr != NULL && *ptr != TAIL){
		if((*ptr)->val == item){
			(*ptr)->prev->next = (*ptr)->next;
			(*ptr)->next->prev = (*ptr)->prev;
			free(*ptr);
		}
		ptr = &(*ptr)->next;
	}
	free(ptr);
	return true;
}

bool popAll(LinkedList* _list, int item){
	ListNode **_lp = &(_list)->head;
	while((*_lp)->next != NULL){
		if((*_lp)->next->val == item){	//If next.val == item...
			ListNode* temp = (*_lp)->next;
			temp = NULL;
			(*_lp)->next = (*_lp)->next->next;
			//free(temp);	// @todo Explore using a free 
						// queue to reduce per-op cost 
			// @todo memory leak??	// in conditional statement.
		}
		if((*_lp)->next->next == NULL && (*_lp)->next->val == item){
			/* ListNode* temp = (*_lp)->next; */
			
			free((*_lp)->next->next);
			free((*_lp)->next);
			(*_lp)->next = NULL;
			/* free(temp); */
			break;	
		}
		_lp = &(*_lp)->next;
	}
	free(_lp);
	return true;
}

void printList(LinkedList* _list){
	puts("PRINTING LIST");
	ListNode **headp = &(_list)->head->next;
	while(*headp != NULL && *headp != TAIL){
		printf("%d\n", (*headp)->val);
		headp = &(*headp)->next;
	}
}

int length(LinkedList* _list){
	if(_list == NULL || &(*_list) == NULL) return 0;
	int len = 0;
	ListNode **ptr = &(_list)->head->next;
	if(*ptr == NULL) return len;
	while(*ptr != NULL && *ptr != TAIL){
		++len;
		ptr = &(*ptr)->next;
	}
	return len;
}

bool updateListElements(LinkedList* _list, int _amt){
	if(_amt == 0) return 1;
	ListNode **dp = &_list->head->next;
	while(*dp != NULL){
		(*dp)->val += _amt;
		dp = &(*dp)->next;
	}
	return 0;
}
