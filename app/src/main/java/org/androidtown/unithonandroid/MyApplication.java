package org.androidtown.unithonandroid;

/**
 * Created by LikeJust on 2018-01-28.
 */

public class MyApplication {
    static public int Did2ImgSrc(String name) {
        int imgSrc = 0;

        switch (name) {
            case "김명회":
                imgSrc = R.drawable.img_write_mom;
                break;
            case "임근원":
                imgSrc = R.drawable.img_write_grand;
                break;
            case "김도현":
                imgSrc = R.drawable.img_write_daddy;
                break;
            default:
                break;
        }

        return imgSrc;
    }
}
