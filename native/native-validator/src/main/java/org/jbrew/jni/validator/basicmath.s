	.file	"basicmath.c"
	.text
	.p2align 4,,15
	.globl	Java_org_jbrew_jni_validator_BasicMathValidator_addNative
	.type	Java_org_jbrew_jni_validator_BasicMathValidator_addNative, @function
Java_org_jbrew_jni_validator_BasicMathValidator_addNative:
.LFB22:
	.cfi_startproc
	leal	(%rdx,%rcx), %eax
	ret
	.cfi_endproc
.LFE22:
	.size	Java_org_jbrew_jni_validator_BasicMathValidator_addNative, .-Java_org_jbrew_jni_validator_BasicMathValidator_addNative
	.p2align 4,,15
	.globl	Java_org_jbrew_jni_validator_BasicMathValidator_subNative
	.type	Java_org_jbrew_jni_validator_BasicMathValidator_subNative, @function
Java_org_jbrew_jni_validator_BasicMathValidator_subNative:
.LFB23:
	.cfi_startproc
	movl	%edx, %eax
	subl	%ecx, %eax
	ret
	.cfi_endproc
.LFE23:
	.size	Java_org_jbrew_jni_validator_BasicMathValidator_subNative, .-Java_org_jbrew_jni_validator_BasicMathValidator_subNative
	.p2align 4,,15
	.globl	Java_org_jbrew_jni_validator_BasicMathValidator_multNative
	.type	Java_org_jbrew_jni_validator_BasicMathValidator_multNative, @function
Java_org_jbrew_jni_validator_BasicMathValidator_multNative:
.LFB24:
	.cfi_startproc
	movl	%edx, %eax
	imull	%ecx, %eax
	ret
	.cfi_endproc
.LFE24:
	.size	Java_org_jbrew_jni_validator_BasicMathValidator_multNative, .-Java_org_jbrew_jni_validator_BasicMathValidator_multNative
	.ident	"GCC: (GNU) 8.3.1 20190507 (Red Hat 8.3.1-4)"
	.section	.note.GNU-stack,"",@progbits
