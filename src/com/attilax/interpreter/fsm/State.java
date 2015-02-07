package com.attilax.interpreter.fsm;
public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter,Context context);
}