#include <pthread.h>
#include <unistd.h>
#include <jni.h>
#include "org_jbrew_cbrew_validator_Validator_PThreadValidator.h"

void* func1(void*);
void* func2(void*);

typedef struct{
	void* arg1;
	void* arg2;
} mystruct;

/*
 * Class:     org_jbrew_cbrew_validator_Validator_PThreadValidator
 * Method:    pthreadTest
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_jbrew_cbrew_validator_Validator_00024PThreadValidator_pthreadTest (JNIEnv *env, jobject this){
	pthread_t t1, t2;
	pthread_create(&t1, NULL, func2, NULL);
	pthread_join(t1, NULL);
	return 1;
}

void* func1(void* args){
	sleep(1);
	return (void*)69;
}

void* func2(void* args){
	return NULL;
}
