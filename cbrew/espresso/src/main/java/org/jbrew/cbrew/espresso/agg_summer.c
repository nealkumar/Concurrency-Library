#include <jni.h>
#include <stdio.h>
#include "org_jbrew_cbrew_espresso_SumOperation_NativeAdapter.h"

void print(void);

/*
 * Class:     org_jbrew_cbrew_espresso_SumOperation_NativeAdapter
 * Method:    sumSequential
 * Signature: (I[I)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_espresso_SumOperation_00024NativeAdapter_sumSequential
  (JNIEnv * env, jobject obj, jint jsize, jintArray jarr){
	//return 2772;
	int sum = 0;
//	jboolean *isCopy;
//	int size = (int)jsize;
//	jint* body = (*env)->GetIntArrayElements(jarr, 0, isCopy);
	int *p = NULL;
//	for(p=&body[0]; p<&body[dd3]; p++){
//		sum += *p;
//	}
	int *arr = (int*)jarr;
	for(p=&arr[0]; p<&arr[3]; p++){
		sum += (int)*p;
	}
//	(*env)->ReleaseIntArrayElements(env, jarr, body, (*print());
	return sum;
  }

void print(){
	puts("ERRRRRRRRR");
}

/*
 * Class:     org_jbrew_cbrew_espresso_SumOperation_NativeAdapter
 * Method:    sumParallel
 * Signature: (I[II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_espresso_SumOperation_00024NativeAdapter_sumParallel
  (JNIEnv *env, jobject obj, jint size, jintArray arr, jint n_threads){
	return 70;
  }
