#include <stdio.h>
#include <pthread.h>

int god(void);
void sayHi(void);
void sayHello(void);
void sayBye(void);

static void (*p[4])(void);

int main(int args, char** argc){
	puts("Program starting...");
	p[0] = sayHi;
	p[1] = sayHello;
	p[2] = sayBye;
	int i = 2;//(int)getchar(); //god();
	p[i]();
	return 0;
}

int god(void){
	return 0;
}

void sayHi(){
	puts("Hi");
}

void sayHello(){
	puts("Hello");
}

void sayBye(){
	puts("bYTe");
}
