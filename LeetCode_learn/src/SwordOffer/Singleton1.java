package SwordOffer;

/*
@author: bass
@Data: 2018-08-06 08:21:20
*/

public class Singleton1 {
    //no lock, only fit single thread
    private Singleton1(){}
    private static Singleton1 instance = null;
    public static Singleton1 getInstance(){
        if (instance == null)
            instance = new Singleton1();
        return instance;
    }

    //lock the whole block, low efficiency
    private static Singleton1 instance_bad_lock = null;
    public static Singleton1 getInstance_bad_lock(){
        if (instance_bad_lock == null){
            synchronized (Singleton1.class){
                instance_bad_lock = new Singleton1();
            }
        }
        return instance_bad_lock;
    }

    //利用静态构造函数，不过会过早的创建实例，降低内存的使用效率。
    private static Singleton1 instance_good = new Singleton1();
    public static Singleton1 getInstance_good(){
        return instance_good;
    }


    private static Singleton1 instace_best;
    public Singleton1 getInstace_best(){
        return Nestd.instance_test;
    }
    private static class Nestd{
         static Singleton1 instance_test = new Singleton1();
    }


}
