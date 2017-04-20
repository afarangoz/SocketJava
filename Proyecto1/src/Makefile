	javac MyJNIClass.java
	javah -jni MyJNIClass
	gcc -shared -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -o libmyJNIlib.so MyJNIClass.c
	export LD_LIBRARY_PATH=.
	
