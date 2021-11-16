package cn.chenshi.helloJava.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenShi
 * @date 2021/10/29 下午5:09
 */
public class Test123 {
    public static void main(String[] args){
        Lock lock = new ReentrantLock();

    }

    private static Test123 instance;
    public static Test123 getInstance(){
        if(instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = new Test123();
                }
            }
        }
        return instance;
    }

}
