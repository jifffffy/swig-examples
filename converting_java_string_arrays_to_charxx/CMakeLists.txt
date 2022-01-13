find_package(SWIG REQUIRED)
find_package(JNI REQUIRED)

include(UseSWIG)

set(CMAKE_SWIG_FLAGS -package io.jiffy.example -features autodoc=1)
set(CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_SOURCE_DIR}/src/main/java/io/jiffy/example)

swig_add_library(converting_java_string_arrays_to_charxx
        LANGUAGE Java
        SOURCES ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig/converting_java_string_arrays_to_charxx.i)
target_include_directories(converting_java_string_arrays_to_charxx PRIVATE
        include
        ${JNI_INCLUDE_DIRS}
        ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig
        )

# For convenience we copy the dynamic library to the current build folder
add_custom_command(
        TARGET converting_java_string_arrays_to_charxx
        POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:converting_java_string_arrays_to_charxx> ${CMAKE_CURRENT_SOURCE_DIR}/src/main/resources/natives/linux_64/
)