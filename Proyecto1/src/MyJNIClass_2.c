#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <time.h>
#include "dUQx.h"
#include <signal.h>


#include <jni.h>
#include <stdio.h>
#include "MyJNIClass.h"

int signo = SIGALRM;
sigset_t set;


JNIEXPORT jfloat JNICALL Java_MyJNIClass_InitDuqx(JNIEnv * env, jobject objc,  jint port, jint res) 
{	
	float vref;
	dUQx_Init(port);
	dUQx_SetResolution(res);
	dUQx_ConfigureDigital(0x3ff);
	dUQx_CalibrateAnalog(&vref);
	return vref;
	
}

JNIEXPORT void JNICALL Java_MyJNIClass_Timer(JNIEnv * env, jobject objc) 
{	

	timer_t timer_id;
	struct itimerspec timer;
	sigemptyset(&set);// se crea un set vacio.
	sigaddset(&set, signo);// se agrega SIGALRM al set
	sigprocmask(SIG_BLOCK, &set, NULL); 
	timer.it_value.tv_sec = 0;// se establecen los valores para el timer 100ms y periodico
	timer.it_value.tv_nsec = 100000000;
	timer.it_interval.tv_sec = 0;
	timer.it_interval.tv_nsec = 100000000;
	timer_create(CLOCK_REALTIME, NULL, &timer_id); // se crea el timer
	timer_settime( timer_id, 0, &timer, NULL );        // se inicializa el timer

	
	
}

JNIEXPORT jfloat JNICALL Java_MyJNIClass_Handler(JNIEnv * env, jobject objc, jint ch, jfloat vref) 
{
	float v;
	sigwait(&set,&signo);
	dUQx_ReadAnalogSingle(ch,vref,&v);
	return v;
}

JNIEXPORT void JNICALL Java_MyJNIClass_DuqxEnd(JNIEnv * env, jobject objc) 
{
	dUQx_End();
}






























	
