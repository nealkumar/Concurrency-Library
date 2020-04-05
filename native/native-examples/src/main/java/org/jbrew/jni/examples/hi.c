#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include "org_jbrew_jni_examples_SayHi.h"

/*
 * Class:     org_jbrew_jni_examples_SayHi
 * Method:    sayHi
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jbrew_jni_examples_SayHi_sayHi (JNIEnv *env, jobject sayhi){
	printf("Hello from C!");
	return;
}
