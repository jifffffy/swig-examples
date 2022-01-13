/* File : example.i */
%module clazz

%{
#include "clazz.h"
%}

/* Let's just grab the original header file here */
%include "clazz.h"
