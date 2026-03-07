#pragma once
#include <plugin.h> // Plugin-SDK version 1000 from 2025-10-28 18:33:25

using namespace plugin;

#define Max(a,b) ((a) > (b) ? (a) : (b))
#define Min(a,b) ((a) < (b) ? (a) : (b))

typedef uint8_t uint8;
typedef int8_t int8;
typedef uint16_t uint16;
typedef int16_t int16;
#ifndef __MWERKS__
typedef uint32_t uint32;
typedef int32_t int32;
#else
typedef unsigned int uint32;
typedef int int32;
#endif
typedef uintptr_t uintptr;
typedef intptr_t intptr;
typedef uint64_t uint64;
typedef int64_t int64;
// hardcode ucs-2
typedef uint16_t wchar;
