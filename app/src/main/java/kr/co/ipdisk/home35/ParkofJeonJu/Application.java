package kr.co.ipdisk.home35.ParkofJeonJu;

/**
 * Created by kaira on 2016-11-25.
 */

public final class Application extends android.app.Application {
    @Override

    /*
        폰트를 위한 설정
     */
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "THEAlien.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "THEAlien.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "THEAlien.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "THEAlien.ttf");
    }
}
