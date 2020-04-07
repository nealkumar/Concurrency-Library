#include <stdio.h>
#include <jni.h>
#include "org_jbrew_cbrew_validator_SayHiCBrew.h"

/*
 * Class:     org_jbrew_cbrew_validator_SayHiCBrew
 * Method:    sayHi
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi (JNIEnv *env, jobject obj){
	printf("hElLo 0uT tHeRe! fRoM ~C~!");
}
