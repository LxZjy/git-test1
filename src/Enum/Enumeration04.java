package Enum;

public class Enumeration04 {
    public static void main(String[] args) {
        Music.MUSIC.playing();
    }
}
interface IPlaying{
    public void playing();
}
enum Music implements IPlaying{
   MUSIC;

    @Override
    public void playing() {
        System.out.println("播放"+name()+"音乐");
    }
}