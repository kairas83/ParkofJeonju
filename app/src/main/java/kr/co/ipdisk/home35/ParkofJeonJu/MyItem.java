package kr.co.ipdisk.home35.ParkofJeonJu;

/**
 * Created by kairas on 2016-11-23.
 */

class MyItem {
    MyItem( String name, int image, int bench, int camera, int parking, int playground, int pulling_up_training_silhouette, int roundabout, int toilet) {
        this.name = name;
        this.image = image;

        this.bench = bench;
        this.camera = camera;
        this.parking = parking;
        this.playground = playground;
        this.pulling_up_training_silhouette = pulling_up_training_silhouette;
        this.roundabout = roundabout;
        this.toilet = toilet;
    }
    String name;
    int image;

    int bench;
    int camera;
    int parking;
    int playground;
    int pulling_up_training_silhouette;
    int roundabout;
    int toilet;
}
