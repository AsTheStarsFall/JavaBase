package com.tianhy.javabase.json.fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.tianhy.javabase.json.Human;
import lombok.extern.java.Log;

import java.util.Date;

/**
 * @Desc: 阿里巴巴Json
 * @Author: thy
 * @CreateTime: 2019/3/20
 **/
@Log
public class FastJsonTest {
    private Human human;
    public FastJsonTest() {
        human = new Human();
        human.setAge(18);
        human.setName("thy");
        human.setTime(new Date(System.currentTimeMillis()));
//        List list =new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            list.add(i,i);
//        }
//        human.setHobbies(list);
    }

    /**
     * json转bean
     */
    public void t1(){
    }

    /**
     * bean转json
     */
    public void t2(){
        System.out.println(new Gson().toJson(this.human));
        Human human = new Gson().fromJson(new Gson().toJson(this.human),Human.class);
        System.out.println(new Gson().toJson(human));
        JSON.toJSONString(human);
    }
}
