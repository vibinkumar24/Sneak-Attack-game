public class LimitClass {

    private static LimitClass limInstance;
    String name;
    public static int objCount = 0;

    private LimitClass(){
        objCount++;
    }

    public static synchronized LimitClass getLimInstance(String name){
        if(objCount < 3 ){
            limInstance = new LimitClass();
        }
        return limInstance;
    }
}
