package com.volacode.URLShortener.utils;

import java.util.ArrayList;
import java.util.List;

public class IDConverter {

    private static final char[]  char62Array=
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    private static  final List<Long> remainderList = new ArrayList<>();

    public static  String convertRequestID(Long requestId){
        if(requestId < 62){
            long request = requestId;
            return String.valueOf(char62Array[(int) request]);
        }
        long divisor = requestId;
        while(divisor != 0){
            remainderList.add(0,divisor % 62);
            divisor /= 62;
        }

        StringBuilder convertedKey = new StringBuilder();
        for (long remainder:remainderList
             ) {
            convertedKey.append(char62Array[(int) remainder]);
        }
        remainderList.clear();
        return  convertedKey.toString();

        }

        public  static  int getRequestId(String convertedId){
        int requestKey = 0;
            for (int i = 0; i < convertedId.length(); i++) {
                for (int j = 0; j < 62 ; j++) {
                    if (convertedId.charAt(i) == char62Array[j]){
                        requestKey += j * Math.pow(62,convertedId.length() - (i + 1));
                 break;
                    }
                }
            }
            return requestKey;
        }
}
