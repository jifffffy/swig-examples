/* File : example.i */
%module(directors="1") special_variable
%{
#include "special_variable.h"
%}

/* turn on director wrapping Callback */
%feature("director") Callback;

%include "special_variable.h"

