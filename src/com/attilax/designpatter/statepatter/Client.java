package com.attilax.designpatter.statepatter;
public class Client {

    public static void main(String[] args){
     
        //��������
        Context context = new Context();
        //��״̬���õ�������
        //����״̬
        State state = new ConcreteStateB();
        context.setState(state);
        
        //����
        context.request("test");
    }
}