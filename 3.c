#include<stdio.h>
#define max 3

struct stack {
	int data[max];
	int top;
};

struct stack stack_a, stack_b, stack_c;

int isEmpty(int option) {
	if (option == 1) {
		if (stack_a.top==-1) {
			return 1;
		} else {
			return 0;
		}
	} else if (option == 2) {
		if (stack_b.top==-1) {
			return 1;
		} else {
			return 0;
		}
	} else {
		if (stack_c.top==-1) {
			return 1;
		} else {
			return 0;
		}
	}
}

void display() {
	int i;
	printf("\n\tStack A:\n");
	if (!isEmpty(1)) {
		for(i=stack_a.top; i>=0; i--) {
			printf("\t%i\n", stack_a.data[i]);
		}
	} else {
		printf("\tStack A kosong!\n");
	}
	
	printf("\tStack B:\n");
	if (!isEmpty(2)) {
		for(i=stack_b.top; i>=0; i--) {
			printf("\t%i\n", stack_b.data[i]);
		}
	} else {
		printf("\tStack B kosong!\n");
	}
	
	printf("\tStack c:\n");
	if (!isEmpty(3)) {
		for(i=stack_c.top; i>=0; i--) {
			printf("\t%i\n", stack_c.data[i]);
		}
	} else {
		printf("\tStack C kosong!\n");
	}
}

int isFull(int option) {
	if (option == 1) {
		if (stack_a.top==max-1) {
			return 1;
		} else {
			return 0;
		}
	} else if (option == 2) {
		if (stack_b.top==max-1) {
			return 1;
		} else {
			return 0;
		}
	} else {
		if (stack_c.top==max-1) {
			return 1;
		} else {
			return 0;
		}
	}
}

void push(int option, int nilai) {
	if (option == 1) {
		if (!isFull(1)) {
			stack_a.top++;
			stack_a.data[stack_a.top] = nilai;
		} else {
			printf("Stack A sudah penuh!!\n");
		}
	} else if (option == 2) {
		if (!isFull(2)) {
			stack_b.top++;
			stack_b.data[stack_b.top] = nilai;
		} else {
			printf("Stack B sudah penuh!!\n");
		}
	} else {
		if (!isFull(3)) {
			stack_c.top++;
			stack_c.data[stack_c.top] = nilai;
		} else {
			printf("Stack C sudah penuh!!\n");
		}
	}
}

void tambahData(int nilai) {
	if (!isFull(1) && nilai%2==0) {
		push(1, nilai);
	} else if (!isFull(2) && nilai%5==0) {
		push(2, nilai);
	} else if (!isFull(3)){
		push(3, nilai);
	} else {
		printf("Semua stack sudah penuh!\n");
	}
}

int main() {
	int pilihan, nilai;
	stack_a.top = stack_b.top = stack_c.top = -1;
	do {
		printf("\nNama  : Alim Ikegami\n");
		printf("NIM   : 1908561046\n");
		printf("1. Tambah Data\n");
		printf("2. Print\n");
		printf("3. Exit\n");
		printf("Pilihan: ");
		scanf("%i", &pilihan);
		switch (pilihan) {
			case 1:
				printf("Input data: ");
				scanf("%i", &nilai);
				tambahData(nilai);
				printf("........");
				getch();
				break;
			case 2:
				display();
				getch();
				break;
			default:
				if(pilihan!=3) {
					printf("Maaf masukan anda salah!\n");
				}
				break;
		}
	} while (pilihan!=3);
}
