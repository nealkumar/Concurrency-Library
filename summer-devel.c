#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define THREADS 8

int part = 0;
int sum[THREADS] = { 0 };
int arr[] = {1, 2, 3, 1, 1, 6, 7, 8, 9, 20, 11, 12, 13, 14, 15, 16};

int* arrp;
int* sizep;

int sumSequential(int size, int arr[]){
	int accumulator=0;
	int *p;
	for(p=&arr[0]; p<&arr[size]; p++){
		accumulator += *p;
	}
	return accumulator;
}

void* helper(void *argv){
	int thread_part = part++;
	//each thread computes 1/4 of the 16 element array.
	for(int index=thread_part * (*sizep / THREADS); index < (thread_part+1) * (*sizep / THREADS); index++)
		sum[thread_part] += arrp[index];
	return NULL;
}

int sumParallel(int size, int arr[]){
	int* p = &arr[0];
	puts("BASIC:: Printing pointer array vals:");
	for(p; p<&arr[size]; p++){
		printf("%d\n", *p);
	}

	puts("");

	arrp = &arr[0];
	sizep = &size;
	puts("HARD:: Printing pointer array vals:");
	for(int index=0; index<size; index++){
		printf("%d\n", arrp[index]);
	}

	int total_sum=0;
	//int *p;
	pthread_t threads[THREADS];
	//spawn 4 threads
	for(int index=0; index<THREADS;index++)
		pthread_create(&threads[index], NULL, helper, (void*)NULL);
	//join the threads once they're done
	for(int index=0; index<THREADS; index++){
		pthread_join(threads[index], NULL);
	}

	//sum up the values placed in total_sum
	for(int index=0; index<THREADS; index++)
		total_sum += sum[index];

	//free(&arrp);
	//free(&sizep);
	return total_sum;
}

int main(int numArgs, char **argc){
	int sum1 = sumSequential(16, arr);
	int sum2 = sumParallel(16, arr);
	printf("Sum Sequential= %d\n", sum1);
	printf("Sum Parallel= %d\n", sum2);
	return 0;
}
