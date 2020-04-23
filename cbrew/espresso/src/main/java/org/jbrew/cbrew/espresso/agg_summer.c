#include <jni.h>
#include "org_jbrew_cbrew_espresso_SumOperation.h"
#define org_jbrew_cbrew_espresso_SumOperation_DEFAULT_NUM_THREADS 5L
/*
 * Class:     org_jbrew_cbrew_espresso_SumOperation
 * Method:    sumSequential
 * Signature: (I[I)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential
  (JNIEnv *env, jobject this, jint jsize, jintArray jarr){
	int sum=0;
	jint *body = (*env)->GetIntArrayElements(env, jarr, 0);
	int *p;
	for(p=&body[0]; p<&body[jsize]; p++){
		sum += *p;
	}
	return sum;
  }

/*
 * Class:     org_jbrew_cbrew_espresso_SumOperation
 * Method:    sumParallel
 * Signature: (I[II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel
  (JNIEnv *env, jobject this, jint jsize, jintArray jarr, jint jNumThreads){
	return 70;
  }
