package adapter;

public class AdaptorMain {
    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");

        player = new FormatAdapter(new MP4());
        player.play("file.mp4");

        player = new FormatAdapter(new MKV());
        player.play("file.mkv");

    }
}

class FormatAdapter implements MediaPlayer {
    private MediaPakage media;

    FormatAdapter(MediaPakage media) {
        this.media = media;
    }

    @Override
    public void play(String fileName) {
        System.out.println("Using Adapter --> ");
        media.playFile(fileName);
    }
}

class MP3 implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 File --> " + fileName);
    }
}

class MP4 implements MediaPakage {
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing MP4 File -->" + fileName);
    }
}

class MKV implements MediaPakage {
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing MKV File -->" + fileName);
    }
}

interface MediaPlayer {
    void play(String fileName);
}

interface MediaPakage {
    void playFile(String fileName);
}
