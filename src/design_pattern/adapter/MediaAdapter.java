package design_pattern.adapter;

public class MediaAdapter implements MediaPlayer {
	
	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp4")) {
			Mp4Player player=new Mp4Player();
			player.playMp4(fileName);
		}
		if (audioType.equalsIgnoreCase("vlc")) {
			VlcPlayer player=new VlcPlayer();
			player.playVlc(fileName);
		}
		if (audioType.equalsIgnoreCase("mp3")) {
			
		}
	}
	
}
