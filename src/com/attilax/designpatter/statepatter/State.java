package com.attilax.designpatter.statepatter;

 

public interface State {
    /**
     * ״̬��Ӧ�Ĵ���
     */
    public void handle(String sampleParameter);
    public void handle(String sampleParameter,Context context);
}