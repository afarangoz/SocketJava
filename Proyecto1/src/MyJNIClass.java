

public class MyJNIClass {
	
	public static float getValue(float P, float I) {

        MyJNIClass jni = new MyJNIClass();
        float x = jni.X(P, I);
        return x;
    }

    static {
        // Carga la biblioteca dinamica: libmyJNIlib.so
        System.loadLibrary("myJNIlib");
    }
	private native float X(float P, float I);

}
