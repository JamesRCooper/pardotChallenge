package com.pardot;

public class Secret {

    public static int secret(int x) {

        if(x == 27 || x == 9967)
            return 0;
        return 3 * x;
    }
}