package javaCoreOne.reflection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class test {

	public static void main(String[] args) {
		ConcurrentHashMap <String,Object> map = new ConcurrentHashMap <String,Object>();
		System.out.println(map.put("haha", 1));
		System.out.println(map.put("haha", 2));
		System.out.println(map.get("haha"));
	}

}
