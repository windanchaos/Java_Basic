package javaCoreOne.InnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
		/*
		 * 在Java中，A类中的静态方法不能直接调用A的动态方法。
		 * main 是静态方法
		 * 如果TalkingClock类属于InnerClassTest，则需要TalkingClock为静态
		 */
		//InnerClassTest innerClassTest=new InnerClassTest();
		TalkingClock talkingClock = new TalkingClock(1000, true);
		
		talkingClock.start4();

		JOptionPane.showMessageDialog(null, "quit now?");
		System.exit(0);

	}
}
class TalkingClock {
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}

	// 内部内
	public class TimePrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("At the tone,the time is:" + new Date());
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	
	//局部内部类
	/*
	 * 局部内部内不能用Public/private进行申明
	 */
	public void start2() {
		class TimePrinter implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone,the time is:" + new Date());
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	//匿名内部类
	/*
	 * 
	 */
	public void start3() {
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone,the time is:" + new Date());
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	//匿名内部内的最佳替代方案lambda
	public void start4() {
		Timer t = new Timer(interval, listener-> {
			System.out.println("At the tone,the time is:" + new Date());
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		});
		t.start();
	}
		
}
