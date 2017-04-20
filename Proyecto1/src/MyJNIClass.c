#include <jni.h>
#include <stdio.h>
#include "MyJNIClass.h"

JNIEXPORT jfloat JNICALL Java_MyJNIClass_X(JNIEnv * env, jobject objc,  jfloat P, jfloat I) 
{	
	jfloat x;
	x = P + I;
	 return x;
	
}
	
