package com.example.multiable.demo_bmob.application;

import android.app.Application;

import com.example.multiable.demo_bmob.config.Config;

import cn.bmob.v3.Bmob;

/**
 * Created by macremote on 2015/12/17.
 */
public class BmobApplication extends Application {
    //定义一个私有的静态的全局变量来保存该类的唯一实例
    private static BmobApplication application ;
    private BmobApplication(){
    }

    /**获得BmobApplication实例
     * @return
     */
    public static BmobApplication getInStance(){
        if(application==null){
            application = new BmobApplication();
        }
        return application ;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bmob
        // 初始化 Bmob SDK,使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, Config.APPLICATION_ID);
    }
}
