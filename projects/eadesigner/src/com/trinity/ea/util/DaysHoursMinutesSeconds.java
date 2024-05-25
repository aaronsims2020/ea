package com.trinity.ea.util;
import java.text.DecimalFormat;

/** Modified by aaronsc, src was found on Sun Java Forums, posted by tajenkins at http://forums.java.sun.com forums */ 
public class DaysHoursMinutesSeconds 
{
   public static long MS_SECOND = 1000L;
   public static long MS_MINUTE = 60L * MS_SECOND;
   public static long MS_HOUR = 60L * MS_MINUTE;
   public static long DAY = 24L * MS_HOUR;

   public static String[] getDaysHoursMinutesSeconds(long value) 
   {
      DecimalFormat nf = new DecimalFormat("00");
      long remainder = 0;
      long days = value / DAY;
      remainder = value % DAY;
      long hours = remainder / MS_HOUR;
      remainder = value % MS_HOUR;
      long minutes = remainder / MS_MINUTE;
      remainder = remainder % MS_MINUTE;
      long seconds = remainder / MS_SECOND;
      String[] strArray = new String[4];
      StringBuffer buffer = new StringBuffer();
      strArray[0] = nf.format(days);
      strArray[1] = nf.format(hours);
      strArray[2] = nf.format(minutes);
      strArray[3] = nf.format(seconds); 

      return strArray;
   } 
}
