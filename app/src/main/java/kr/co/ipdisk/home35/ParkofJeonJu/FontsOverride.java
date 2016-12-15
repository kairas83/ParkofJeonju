package kr.co.ipdisk.home35.ParkofJeonJu;

/**
 * Created by kaira on 2016-11-25.
 */

import java.lang.reflect.Field;
import android.content.Context;
import android.graphics.Typeface;

final class FontsOverride {

        /*
            Default 폰트 설정을 위한 java 파일
     */

    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}