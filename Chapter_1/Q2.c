#include <stdio.h>

void reverse(char *str);
int main(int argc, char** argv){

  char* input = argv[1];
  reverse(input);

}

void reverse(char* str){

  int len  = 0;
  while(str[len]!='\0'){
    len ++;
  }

  int i = 0, j = len - 1;
  // To do in place, swap with the null terminator
  char tmp;
  while(i < j){

    tmp = str[i];
    str[i] = str[j];
    str[j] = tmp;
    i++,j--;

  }

  printf("%s\n", str);

}
