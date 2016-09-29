package by.it.senchenko.jd01_08;

public class Play {
    public static void main(String[] args){
        VideoPlayer player = new VideoPlayer();
        VideoPlayer playerCd = new VideoPlayerCd();
        player.equipmentBreak();
        player.status();
        player.equipmentFix();
        player.status();
        player.equipmentOn();
        player.onOf();
        player.equipmentWorks();
        player.play();
        player.pause();
        player.play();
        player.pause();
        player.play();
        player.chooseFile(7);
        player.volumeUp();
        player.volumeDown();
        player.equipmentOff();
        player.onOf();

        playerCd.equipmentOn();
        playerCd.play();
        playerCd.version(1);
        playerCd.version(1.1);
    }
}
