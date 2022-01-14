package io.jiffy.example;

import java.io.IOException;

import org.scijava.nativelib.NativeLoader;

public class Runme {
    static {
        try {
            NativeLoader.loadLibrary("adding_java_downcasts_to_polymorphic_return_types");
        } catch (IOException e) {
            System.err.println(
                    "Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n"
                            + e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = AddingJavaDowncastsToPolymorphicReturnTypes.vehicle_factory();
        vehicle.start();

        Ambulance ambulance = Ambulance.dynamic_cast(vehicle);
        ambulance.sound_siren();
    }

}
