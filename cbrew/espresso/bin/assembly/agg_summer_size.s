	.file	"agg_summer.c"
	.text
	.globl	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential
	.type	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential, @function
Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential:
.LFB0:
	.cfi_startproc
	movq	(%rdi), %rax
	pushq	%rbx
	.cfi_def_cfa_offset 16
	.cfi_offset 3, -16
	movq	%rcx, %rsi
	movslq	%edx, %rbx
	xorl	%edx, %edx
	call	*1496(%rax)
	movq	%rax, %rcx
	leaq	(%rax,%rbx,4), %rdx
	xorl	%eax, %eax
.L2:
	cmpq	%rcx, %rdx
	jbe	.L6
	addl	(%rcx), %eax
	addq	$4, %rcx
	jmp	.L2
.L6:
	popq	%rbx
	.cfi_def_cfa_offset 8
	ret
	.cfi_endproc
.LFE0:
	.size	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential, .-Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential
	.globl	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel
	.type	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel, @function
Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel:
.LFB1:
	.cfi_startproc
	movl	$70, %eax
	ret
	.cfi_endproc
.LFE1:
	.size	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel, .-Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel
	.ident	"GCC: (GNU) 8.3.1 20190507 (Red Hat 8.3.1-4)"
	.section	.note.GNU-stack,"",@progbits
