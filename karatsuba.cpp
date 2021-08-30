/*
Below is my python implementation for the Karatsuba multiplication algorithm.
This code seems to work for most inputs, but starts failing after the digits grow too large. 
For example, with the 64 digit inputs x = 3141592653589793238462643383279502884197169399375105820974944592 
y = 2718281828459045235360287471352662497757247093699959574966967627 the algorithm fails. 
But when I use only the first 35 digits, the algorithm works. 

output: 8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184
*/
#include <iostream>
#include <algorithm>
#include <string.h>
#include<stdio.h>


const int MAX_LENGTH = 50000 * 2 + 1;

void add_leading_zeros(char* a, int n) {
  int lena = strlen(a);
  for (int i = lena - 1 + n; i >= n; --i) {
    a[i] = a[i - n];
  }
  a[lena + n] = 0;
  for (int i = 0; i < n; ++i) {
    a[i] = '0';
  }
}

void remove_leading_zeros(char* a) {
  int lena = strlen(a);
  int ind = 0;
  while (ind < lena && a[ind] == '0') {
    ++ind;
  }

  for (int i = ind; i < lena; ++i) {
    a[i - ind] = a[i];
  }
  a[lena - ind] = 0;
}

void sum(char* a, char* b, char* res) {
  int lena = strlen(a);
  int lenb = strlen(b);

  if (lena < lenb) {
    std::swap(a, b);
    std::swap(lena, lenb);
  }

  int toAdd = 0;
  for (int inda = lena - 1, indb = lenb - 1; inda >= 0; --inda, --indb) {
    int x = a[inda] - '0';
    int y = indb >= 0 ? b[indb] - '0' : 0;

    int cur = x + y + toAdd;

    if (cur >= 10) {
      toAdd = 1;
      cur -= 10;
    } else {
      toAdd = 0;
    }

    res[inda] = cur + '0';
  }

  if (toAdd == 1) {
    add_leading_zeros(res, 1);
    res[0] = '1';
  }
}

// assume that a > b
void sub(char* a, char* b, char* res) {
  int lena = strlen(a);
  int lenb = strlen(b);

  //assert(lena >= lenb);

  int toSub = 0;
  for (int inda = lena - 1, indb = lenb - 1; inda >= 0; --inda, --indb) {
    int x = a[inda] - '0';
    int y = indb >= 0 ? b[indb] - '0' : 0;

    if (toSub == 1) {
      x--;
    }
    int cur;
    if (x < y) {
      cur = x + 10 - y;
      toSub = 1;
    } else {
      cur = x - y;
      toSub = 0;
    }

    res[inda] = cur + '0';
  }
}

// returns a * 10^n
void mult10(char* a, int n) {
  int lena = strlen(a);

  if (lena == 1 && a[0] == '0') {
    return;
  }

  for (int i = lena; i < lena + n; ++i) {
    a[i] = '0';
  }
  a[lena + n] = 0;
}

char* CreateArray(int len) {
  char* res = new char[len];
  memset(res, 0, len);
  return res;
}

// add leading zeros if needed
void make_equal_length(char* a, char* b) {
  int lena = strlen(a);
  int lenb = strlen(b);

  int n = std::max(lena, lenb);

  add_leading_zeros(a, n - lena);
  add_leading_zeros(b, n - lenb);
}

void karatsuba(char* x, char* y, char* res) {
  make_equal_length(x, y);

  int len = strlen(x);
  if (len == 1) {
    int val = (x[0] - '0') * (y[0] - '0');
    if (val < 10) {
      res[0] = val + '0';
    } else {
      res[0] = (val / 10) + '0';
      res[1] = (val % 10) + '0';
    }
  } else {
    char* xl = CreateArray(len);
    char* xr = CreateArray(len);
    char* yl = CreateArray(len);
    char* yr = CreateArray(len);

    int rightSize = len / 2;
    int leftSize = len - rightSize;

    strncpy(xl, x, leftSize);
    strcpy(xr, x + leftSize);
    strncpy(yl, y, leftSize);
    strcpy(yr, y + leftSize);

    int maxl = 3 * len;
    char* P1 = CreateArray(maxl);
    char* P2 = CreateArray(maxl);
    char* P3 = CreateArray(maxl);

    karatsuba(xl, yl, P1);
    karatsuba(xr, yr, P2);

    char* tmp1 = CreateArray(maxl);
    char* tmp2 = CreateArray(maxl);

    sum(xl, xr, tmp1);
    sum(yl, yr, tmp2);
    karatsuba(tmp1, tmp2, P3);

    sub(P3, P1, P3);
    sub(P3, P2, P3);
    mult10(P3, rightSize);

    mult10(P1, 2 * rightSize);

    sum(P1, P2, res);
    sum(res, P3, res);

    remove_leading_zeros(res);

    delete[] xl;
    delete[] xr;
    delete[] yl;
    delete[] yr;
    delete[] tmp1;
    delete[] tmp2;
    delete[] P1;
    delete[] P2;
    delete[] P3;
  }
}

int main() {
  char a[MAX_LENGTH], b[MAX_LENGTH];
  scanf("%s\n%s", a, b);

  char* res = CreateArray(MAX_LENGTH);
  karatsuba(a, b, res);

  printf("%s\n", res);

  

  return 0;
}
