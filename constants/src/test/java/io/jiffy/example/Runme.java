package io.jiffy.example;

import java.lang.reflect.*;

import java.io.IOException;

import org.scijava.nativelib.NativeLoader;

public class Runme {
    static {
        try {
            NativeLoader.loadLibrary("constants");
        } catch (IOException e) {
            System.err.println(
                    "Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n"
                            + e);
            System.exit(1);
        }
    }

    public static void main(String argv[]) {
        System.out.println("ICONST  = " + Constants.ICONST + " (should be 42)");
        System.out.println("FCONST  = " + Constants.FCONST + " (should be 2.1828)");
        System.out.println("CCONST  = " + Constants.CCONST + " (should be 'x')");
        System.out.println("CCONST2 = " + Constants.CCONST2 + " (this should be on a new line)");
        System.out.println("SCONST  = " + Constants.SCONST + " (should be 'Hello World')");
        System.out.println("SCONST2 = " + Constants.SCONST2 + " (should be '\"Hello World\"')");
        System.out.println("EXPR    = " + Constants.EXPR + " (should be 48.5484)");
        System.out.println("iconst  = " + Constants.iconst + " (should be 37)");
        System.out.println("fconst  = " + Constants.fconst + " (should be 3.14)");

        // Use reflection to check if these variables are defined:
        try {
            System.out.println(
                    "EXTERN = " + Constants.class.getField("EXTERN") + " (Arg! This shouldn't print anything)");
        } catch (NoSuchFieldException e) {
            System.out.println("EXTERN isn't defined (good)");
        }

        try {
            System.out.println("FOO    = " + Constants.class.getField("FOO") + " (Arg! This shouldn't print anything)");
        } catch (NoSuchFieldException e) {
            System.out.println("FOO isn't defined (good)");
        }
    }
}
