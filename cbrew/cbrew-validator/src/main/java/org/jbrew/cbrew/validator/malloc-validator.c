#include <stdlib.h>
#include <jni.h>
#include "org_jbrew_cbrew_validator_Validator_MallocValidator.h"

/*
 * Class:     org_jbrew_cbrew_validator_Validator_MallocValidator
 * Method:    mallocTest
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_jbrew_cbrew_validator_Validator_00024MallocValidator_mallocTest (JNIEnv *env, jobject this){
	void* raw = malloc(1000);
	if(raw != NULL) return 1;
	return 0;
	free(raw);
}
