package com.fonet.utilities;

public class Utilities {

    /*
    This method will accept int (in seconds) and executes Thread.sleep for given duration.
     */
    public static void sleep(int seconds) {

        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

    //We can write more browser utilities


}
