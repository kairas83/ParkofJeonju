package kr.co.ipdisk.home35.ParkofJeonJu;

/**
 * Created by kairas on 2016-11-23.
 */

        /*
       아이템 리스트
       공원 이름, 사진 , 보유시설등을 설정할 수 있도록 한 아이템 리스트
     */

class MyItem {
    MyItem( String name, String image, int bench, int camera, int parking, int playground, int pulling_up_training_silhouette, int roundabout, int toilet) {
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
    String image;

    int bench;
    int camera;
    int parking;
    int playground;
    int pulling_up_training_silhouette;
    int roundabout;
    int toilet;
}
