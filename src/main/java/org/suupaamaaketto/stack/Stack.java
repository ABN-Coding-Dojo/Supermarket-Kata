package org.suupaamaaketto.stack;

public class Stack {

    private Boolean isEmpty=true;
    public Boolean isEmpty() {
        return isEmpty;
    }
    
    public void push(String input){
        isEmpty=false;
    }

    public String pop()throws UnderFlowException
    {
        if(isEmpty()){
            throw new UnderFlowException();
        }

        isEmpty = true;
        return "1";
    }
}
