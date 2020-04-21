#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void* allocateRaw(size_t);
int* convertToInt(void* raw);
void Spin(void);

int main(int argc, char** argv){
	void* raw = allocateRaw(sizeof(int));
	int* intp = convertToInt(raw);
	printf("The pointer points to adress %p\n", intp);
	*intp = 69;
	printf("The value of the pointer has been set to: %d\n", *intp);
	/* char* charp = realloc((void*)*intp, sizeof(char)); */
	/* *charp = 69; */
	/* printf("The char value of the pointer is %c\n", *charp); */
	int* p = malloc(sizeof(int));
	if(p == NULL) return 1;
	*p = 0;
	while(1){
		Spin();
		*p += 1;
		printf("(%d) p: %d\n", getpid(), *p);
		if(*p >= 100) 
			goto exit;
	}
exit:
	puts("PRORGAM TERMINATING");	
	return 0;
}

void* allocateRaw(size_t bytes){
	return malloc(bytes);
}

int* convertToInt(void* raw){
	return (int*) raw;
}

void Spin(){
	for(int index=0; index<1; index++){}
}
