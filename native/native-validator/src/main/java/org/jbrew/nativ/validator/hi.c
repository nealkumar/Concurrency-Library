#include <stdio.h>
#include <jni.h>
#include "org_jbrew_jni_validator_SayHi.h"

/*
 * Class:     org_jbrew_jni_validator_SayHi
 * Method:    sayHi
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jbrew_jni_validator_SayHi_sayHi (JNIEnv *env, jobject obj){
	printf("hElLo 0uT tHeRe! fRoM ~C~!");
}
