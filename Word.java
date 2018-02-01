package eyup.miwok;


import java.net.NetworkInterface;

public class Word {
    private String mDefaultTranslatiom;

    private String mMiwokTranslotion;

    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaulttranslation, String miwoktranslation, int imageresourceıd, int audioresourceId ){

            mDefaultTranslatiom = defaulttranslation;
            mMiwokTranslotion = miwoktranslation;
            mImageResourceId = imageresourceıd;
            mAudioResourceId = audioresourceId;


    }



    public String getmDefaultTranslatiom(){
        return mDefaultTranslatiom;

    }


    public String getmMiwokTranslotion(){
        return mMiwokTranslotion;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {  return mAudioResourceId; }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
