package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/2.
 *
*/

public class ActiveUserInformation {
    private static  String name;
    private static int image;

    public ActiveUserInformation() {
    }

    public static String getName() {
        return name ;  }

    public void setName( String name) {
        if(this.name == null){
            this.name = name;
        }

    }

    public static int getImage() {
        return image;
    }

    public void setImage(int image) {
        if(this.image == 0){
            this.image = image;
        }

    }
}
