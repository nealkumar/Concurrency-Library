	.file	"basicmath.c"
	.text
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative
	.type	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative, @function
Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative:
.LFB22:
	.cfi_startproc
	leal	(%rdx,%rcx), %eax
	ret
	.cfi_endproc
.LFE22:
	.size	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative, .-Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_addNative
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative
	.type	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative, @function
Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative:
.LFB23:
	.cfi_startproc
	movl	%edx, %eax
	subl	%ecx, %eax
	ret
	.cfi_endproc
.LFE23:
	.size	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative, .-Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_subNative
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative
	.type	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative, @function
Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative:
.LFB24:
	.cfi_startproc
	movl	%edx, %eax
	imull	%ecx, %eax
	ret
	.cfi_endproc
.LFE24:
	.size	Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative, .-Java_org_jbrew_cbrew_validator_BasicMathValidatorCBrew_multNative
	.ident	"GCC: (GNU) 8.3.1 20190507 (Red Hat 8.3.1-4)"
	.section	.note.GNU-stack,"",@progbits
