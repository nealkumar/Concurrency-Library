#include <stdio.h>
#include <jni.h>
#include "org_jbrew_jni_verifier_DoMath.h"

/*
 * Class:     org_jbrew_jni_verifier_DoMath
 * Method:    addNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_jni_verifier_DoMath_addNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1+num2;
}
