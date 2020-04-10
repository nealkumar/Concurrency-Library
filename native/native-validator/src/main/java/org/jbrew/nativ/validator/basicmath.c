#include <stdlib.h>
#include <stdio.h>
#include <jni.h>
#include "org_jbrew_jni_validator_BasicMathValidator.h"

/*
 * Class:     org_jbrew_jni_validator_BasicMathValidator
 * Method:    addNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_jni_validator_BasicMathValidator_addNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1+num2;
}

/*
 * Class:     org_jbrew_jni_validator_BasicMathValidator
 * Method:    subNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_jni_validator_BasicMathValidator_subNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1-num2;
}

/*
 * Class:     org_jbrew_jni_validator_BasicMathValidator
 * Method:    multNative
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_jbrew_jni_validator_BasicMathValidator_multNative (JNIEnv *env, jobject obj, jint num1, jint num2){
	return num1*num2;
}
