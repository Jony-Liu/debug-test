package com.demo.test;

import org.junit.Test;

/**
 * refer to https://mp.weixin.qq.com/s/vGYSySoHY3M0LDpPnRFLIA
 *
 * @author jonyliu
 * @date 2021/10/15 15:16
 */
public class DebugTest {

    /**
     * 1. 条件断点
     */
    @Test
    public void ifDebug(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    /**
     * 2. 回到"上一步"
     */
    @Test
    public void dropFrameDebug(){
        int i = 99;
        method1(i);
    }

    private void method1(int i){
        System.out.println("method1:"+i);
        method2(i);
    }

    private void method2(int j){
        j++;
        System.out.println("method2:"+j);
    }

    /**
     * 3.多线程调试
     *
     * refer to https://blog.csdn.net/wo541075754/article/details/82119860
     */
    @Test
    public void multiThreadTest(){
        new Thread(()->{
            System.out.println("1.卧枝商恨低");
        },"菩提树下的杨过").start();
        new Thread(()->{
            System.out.println("2.卧梅又闻花");
        },"空中的飞鸟").start();
        System.out.println("3.要问卧似水");
        System.out.println("4.倚头答春绿");
    }

    /**
     * 4.远程调试
     */
    @Test
    public void remoteDebug(){
        //启动应用参数添加如下参数：
        //-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9081
        //Edit Configurations 新增Remote
    }

    /**
     * 5. 临时执行表达式/修改变量的运行值
     */
    @Test
    public void changeValue(){
        int i = 10;
        System.out.println("i="+i);

        System.out.println("i="+i);
    }

}
