package javaCoreOne.time;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

public class LambdaTest {

	public static void main(String[] args) {
		String[] planets=new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		
		Arrays.sort(planets, (first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(planets));
		javax.swing.Timer timer=new javax.swing.Timer(5000, 
				event->System.out.println("At the tone,the time is"+new Date()));
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
