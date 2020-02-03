package design_pattern.adapter;

public class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("mp3")){
	         System.out.println("Playing mp3 file. Name: "+ fileName);            
	      } 
	      //mediaAdapter 提供了播放其他文件格式的支持
	      else if(audioType.equalsIgnoreCase("vlc") 
	         || audioType.equalsIgnoreCase("mp4")){
	    	  MediaAdapter mediaAdapter = new MediaAdapter();
	    	  mediaAdapter.play(audioType, fileName);
	      }
	      else{
	         System.out.println("Invalid media. "+
	            audioType + " format not supported");
	      }
	}

}
