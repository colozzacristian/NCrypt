package com.example.Threads;

import com.example.Crypto.CryptoList;

//yeah the name isn't the best but i found it funny
public class CallerCaller extends Thread {
     
    private CryptoList cryptoList;
    private boolean isAlive=true;

    @Override
    public void run() {


        try {
            while(isAlive){
                System.out.println("starting 1 minut timer");
                sleep(60000);
                System.out.println("timer expired. Refreshing values");
                cryptoList.getCall2Action().release();
                
            }
            
        } catch (Exception e) {
            isAlive=false;
        }
        System.out.println("CallerCaller has stopped running");
    
    }

    public CallerCaller(CryptoList list){
        this.cryptoList=list;
    }


    public CryptoList getCryptoList() {
        return cryptoList;
    }

    public void setCryptoList(CryptoList cryptoList) {
        this.cryptoList = cryptoList;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    
    
}
