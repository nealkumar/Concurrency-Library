#include <stdio.h>
#include <stdlib.h>

#define getchar() getc(stdin)
#define putchar(x) putc((x), stdout)

int cat(int, char**);

int
main(int argc, char** argv){
	if(cat(argc, argv)) return 0;
	return 1;
}

int cat(int argc, char** argv){
	FILE* fp;
	void filecopy(FILE*, FILE*);
	char* prog = argv[0];

	if(argc == 1) filecopy(stdin, stdout);
	else {
		while(--argc > 0){
			if((fp = fopen(*++argv, "r")) == NULL){
				fprintf(stderr, "%s: can't open %s", 
						prog, *argv);
				exit(1);
			} else{
				filecopy(fp, stdout);
				fclose(fp);
			}
		}
		if(ferror(stdout)){
			fprintf(stderr, "%s: error writing stdout\n", prog);
			exit(2);
		}
	}
	return 1;
}

void filecopy(FILE* ifp, FILE* ofp){
	int c;
	while((c = getc(ifp)) != EOF) putc(c, ofp);
}
