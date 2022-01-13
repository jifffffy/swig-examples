find_package(SWIG REQUIRED)
find_package(JNI REQUIRED)

include(UseSWIG)

set(CMAKE_SWIG_FLAGS -c++ -package io.jiffy.example -features autodoc=1)
set(CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_SOURCE_DIR}/src/main/java/io/jiffy/example)
set_source_files_properties(${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig/adding_java_downcasts_to_polymorphic_return_types.i PROPERTIES CPLUSPLUS ON)

swig_add_library(adding_java_downcasts_to_polymorphic_return_types
        LANGUAGE Java
        SOURCES ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig/adding_java_downcasts_to_polymorphic_return_types.i)
target_include_directories(adding_java_downcasts_to_polymorphic_return_types PRIVATE
        include
        ${JNI_INCLUDE_DIRS}
        ${CMAKE_CURRENT_SOURCE_DIR}/src/main/swig
        )

# For convenience we copy the dynamic library to the current build folder
add_custom_command(
        TARGET adding_java_downcasts_to_polymorphic_return_types
        POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:adding_java_downcasts_to_polymorphic_return_types> ${CMAKE_CURRENT_SOURCE_DIR}/src/main/resources/natives/linux_64/
)