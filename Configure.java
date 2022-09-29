package com.antoniofrische.holaandroid.Libs;

import java.time.format.DateTimeFormatter;

public class Configure {
    public static DateTimeFormatter DATE_FORMATT= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final String ESCAPE = "\u001B[";
    public static final String RESET = ESCAPE + "0m";//el reset para el final
    public static final double PI = Math.PI;//PI como und final para operationes matematicas
    public static final boolean DEBUG = true;
    public static final int NUM_MAX_ALETORIO = 10;
}
