find_package(SWIG REQUIRED)
find_package(JNI REQUIRED)

include(UseSWIG)

set(CMAKE_SWIG_FLAGS -c++ -package io.jiffy.example -features autodoc=1)
set(CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_SOURCE_DIR}/src/main/java/io/jiffy/example)
set_source_files_properties(${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig/special_variable.i PROPERTIES CPLUSPLUS ON)

swig_add_library(special_variable
        LANGUAGE Java
        SOURCES ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig/special_variable.i)
target_include_directories(special_variable PRIVATE
        include
        ${JNI_INCLUDE_DIRS}
        ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig
        )

# For convenience we copy the dynamic library to the current build folder
add_custom_command(
        TARGET special_variable
        POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:special_variable> ${CMAKE_CURRENT_SOURCE_DIR}/src/main/resources/natives/linux_64/
)