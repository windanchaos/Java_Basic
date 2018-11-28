package javaCoreOne.time;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

import javax.swing.JOptionPane;

public class TimerTest {

	public static void main(String[] args) {
		ActionListener listener=new TimePrinter();
		javax.swing.Timer timer=new javax.swing.Timer(5000, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
		
	}

}
class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("At the tone,the time is"+new Date());
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}
