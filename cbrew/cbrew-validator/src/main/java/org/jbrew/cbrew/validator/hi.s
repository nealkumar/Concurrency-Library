	.file	"hi.c"
	.text
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"hElLo 0uT tHeRe! fRoM ~C~!"
	.text
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi
	.type	Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi, @function
Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi:
.LFB11:
	.cfi_startproc
	movl	$.LC0, %edi
	xorl	%eax, %eax
	jmp	printf
	.cfi_endproc
.LFE11:
	.size	Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi, .-Java_org_jbrew_cbrew_validator_SayHiCBrew_sayHi
	.ident	"GCC: (GNU) 8.3.1 20190507 (Red Hat 8.3.1-4)"
	.section	.note.GNU-stack,"",@progbits
