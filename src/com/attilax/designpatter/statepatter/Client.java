package com.attilax.designpatter.statepatter;
public class Client {

    public static void main(String[] args){
     
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        //创建状态
        State state = new ConcreteStateB();
        context.setState(state);
        
        //请求
        context.request("test");
    }
}