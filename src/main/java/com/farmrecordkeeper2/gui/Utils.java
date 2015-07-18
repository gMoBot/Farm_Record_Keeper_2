package main.java.com.farmrecordkeeper2.gui;

/**
 * Created by garrettcoggon on 7/9/15.
 */
public class Utils {
    public static String getFileExtension(String name){
        int pointIndex = name.lastIndexOf(".");

        if(pointIndex == -1){
            return null;
        }

        if(pointIndex == name.length() - 1){
            return null;
        }
//        System.out.println(name.substring(pointIndex + 1, name.length()));
        return name.substring(pointIndex + 1, name.length());
    }
}
