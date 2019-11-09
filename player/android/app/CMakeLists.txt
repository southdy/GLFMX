cmake_minimum_required(VERSION 3.6)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(PROJ_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../code")

message(STATUS "CMAKE_BUILD_TYPE: ${CMAKE_BUILD_TYPE}")

IF(${CMAKE_BUILD_TYPE} MATCHES "Debug")
  add_definitions(-DDEBUG=1)
ELSE(${CMAKE_BUILD_TYPE} MATCHES "Debug")
  add_definitions(-DNDEBUG)
ENDIF(${CMAKE_BUILD_TYPE} MATCHES "Debug")

add_definitions(-DGL_GLEXT_PROTOTYPES)

file(GLOB SOURCE_FILES_KYLIN
  ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c
  ${PROJ_DIR}/kylin/*.c
)

add_library(
  kylin SHARED
  ${SOURCE_FILES_KYLIN}
)

target_include_directories(
  kylin PRIVATE
  .
  ${PROJ_DIR}/kylin
  ${PROJ_DIR}/thirdparty
  ${ANDROID_NDK}/sources/android/native_app_glue
)

target_link_libraries(
  kylin
  android
  EGL
  GLESv2
  OpenSLES
  log
)
