	.file	"agg_summer.c"
	.text
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential
	.type	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential, @function
Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential:
.LFB11:
	.cfi_startproc
	pushq	%rbx
	.cfi_def_cfa_offset 16
	.cfi_offset 3, -16
	movq	(%rdi), %rax
	movl	%edx, %ebx
	movq	%rcx, %rsi
	xorl	%edx, %edx
	call	*1496(%rax)
	movslq	%ebx, %rdx
	salq	$2, %rdx
	leaq	(%rax,%rdx), %rdi
	cmpq	%rdi, %rax
	jnb	.L7
	subq	$1, %rdx
	movq	%rax, %rcx
	movq	%rdx, %rsi
	shrq	$2, %rsi
	addq	$1, %rsi
	cmpq	$15, %rdx
	jbe	.L8
	movq	%rsi, %rdx
	pxor	%xmm0, %xmm0
	shrq	$2, %rdx
	salq	$4, %rdx
	addq	%rax, %rdx
	.p2align 4,,10
	.p2align 3
.L4:
	movdqu	(%rcx), %xmm2
	addq	$16, %rcx
	paddd	%xmm2, %xmm0
	cmpq	%rdx, %rcx
	jne	.L4
	movdqa	%xmm0, %xmm1
	movq	%rsi, %rcx
	psrldq	$8, %xmm1
	andq	$-4, %rcx
	paddd	%xmm1, %xmm0
	leaq	(%rax,%rcx,4), %rax
	movdqa	%xmm0, %xmm1
	psrldq	$4, %xmm1
	paddd	%xmm1, %xmm0
	movd	%xmm0, %edx
	cmpq	%rcx, %rsi
	je	.L1
.L3:
	leaq	4(%rax), %rcx
	addl	(%rax), %edx
	cmpq	%rcx, %rdi
	jbe	.L1
	leaq	8(%rax), %rcx
	addl	4(%rax), %edx
	cmpq	%rcx, %rdi
	jbe	.L1
	leaq	12(%rax), %rcx
	addl	8(%rax), %edx
	cmpq	%rcx, %rdi
	jbe	.L1
	addl	12(%rax), %edx
.L1:
	movl	%edx, %eax
	popq	%rbx
	.cfi_remember_state
	.cfi_def_cfa_offset 8
	ret
	.p2align 4,,10
	.p2align 3
.L7:
	.cfi_restore_state
	xorl	%edx, %edx
	popq	%rbx
	.cfi_remember_state
	.cfi_def_cfa_offset 8
	movl	%edx, %eax
	ret
.L8:
	.cfi_restore_state
	xorl	%edx, %edx
	jmp	.L3
	.cfi_endproc
.LFE11:
	.size	Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential, .-Java_org_jbrew_cbrew_espresso_SumOperation_sumSequential
	.p2align 4,,15
	.globl	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel
	.type	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel, @function
Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel:
.LFB12:
	.cfi_startproc
	movl	$70, %eax
	ret
	.cfi_endproc
.LFE12:
	.size	Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel, .-Java_org_jbrew_cbrew_espresso_SumOperation_sumParallel
	.ident	"GCC: (GNU) 8.3.1 20190507 (Red Hat 8.3.1-4)"
	.section	.note.GNU-stack,"",@progbits
