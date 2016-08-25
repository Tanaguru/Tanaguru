/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

/**
 *
 * @author omokeddem at oceaneconsulting
 *
 */
public class MessageConsumerLimit {
    
    private static int currentNumberMessagesEvent = 0;
    private static int currentNumberMessagesRest =0;
    
    public int getCurrentNumberMessagesEvent(){
        return this.currentNumberMessagesEvent;
    }
    public int getCurrentNumberMessagesRest(){
        return this.currentNumberMessagesRest;
    }
    
    public void setCurrentNumberMessagesEvent(int _currentNumberMessages){
        this.currentNumberMessagesEvent = _currentNumberMessages;
    }
    
    public void setCurrentNumberMessagesRest(int _currentNumberMessages){
        this.currentNumberMessagesRest = _currentNumberMessages;
    }
    
    public void messageEventConsumed(){
        this.currentNumberMessagesEvent++;
    }
    public void messageRestConsumed(){
        this.currentNumberMessagesRest++;
    }
    
    public void messageEventAudited(){
        this.currentNumberMessagesEvent --;
    }
    
    public void messageRestAudited(){
        this.currentNumberMessagesRest --;
    }
}
