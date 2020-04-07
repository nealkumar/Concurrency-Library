#include <stdlib.h>
#include <stdio.h>
#include <jni.h>
#include "org_jbrew_cbrew_validator_BasicMathValidatorCBrew.h"

/*
 * Class:     org_jbrew_cbrew_validator_BasicMathValidator
 * Method:    addNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1+num2;
}

/*
 * Class:     org_jbrew_cbrew_validator_BasicMathValidatorCBrew
 * Method:    subNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1-num2;
}

/*
 * Class:     org_jbrew_cbrew_validator_BasicMathValidatorCBrew
 * Method:    multNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1*num2;
}
