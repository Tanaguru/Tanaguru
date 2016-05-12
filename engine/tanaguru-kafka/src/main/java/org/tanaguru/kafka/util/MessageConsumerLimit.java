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
    private static int currentNumberMessages = 0;
    
    public int getCurrentNumberMessages(){
        return this.currentNumberMessages;
    }
    public void setCurrentNumberMessages(int _currentNumberMessages){
        this.currentNumberMessages = _currentNumberMessages;
    }
    
    public void messageConsumed(){
        this.currentNumberMessages++;
    }
    
    public void messageAudited(){
        this.currentNumberMessages --;
    }
}
