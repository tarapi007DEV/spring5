/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Diego
 */
public enum ResponseStatus {
    SUCESSO(1),
    ERRO(-1),
    INFO(0);
    
    private final int value;
    ResponseStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }

}
