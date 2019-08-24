package java300.practice;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        TreeSet<Computer> computerTreeSet=new TreeSet<Computer>();
        computerTreeSet.add(new Computer("samsung","UAD",5666.3f));
        computerTreeSet.add(new Computer("Lenovo","dX-s",4664.3f));
        computerTreeSet.add(new Computer("Lenovo","dsa-s",4164.3f));
        computerTreeSet.add(new Computer("ASUS","ROGv",2666.3f));
        computerTreeSet.add(new Computer("ASUS","ROGA",5366.3f));
        for (Computer c:computerTreeSet){
            System.out.println(c.price);
        }
        //list、map、set遍历
        List list=new ArrayList<>();
        list.add("张三");
        list.add("lisi");
        list.add("XXX");

        Set<String> set =new HashSet<String>();
        set.add("张大");
        set.add("莫名");
        set.add("无助");

        Map<String,String> map=new HashMap<String,String>();
        map.put("a","A");
        map.put("b","B");
        map.put("c","C");

        for(Object s:list){
            System.out.println(s);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        Iterator<String> iterator=list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(String s:set){
            System.out.println(s);
        }

        Iterator iteratorSet=set.iterator();
        while (iteratorSet.hasNext()){
            System.out.println(iteratorSet.next());
        }

        for(String key:map.keySet()){
            System.out.println(map.get(key));
        }
        Iterator<Map.Entry<String,String>> iteratorMap=map.entrySet().iterator();
        while (iteratorMap.hasNext()){
            Map.Entry<String,String> entry=iteratorMap.next();
            System.out.println(entry.getKey()+">>>"+entry.getValue());
        }
        for(Map.Entry<String,String> m:map.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        for(String value:map.values()){
            System.out.println(value);
        }
    }

}


class Computer implements Comparable<Computer>{
    String band;
    String name;
    float price;
    public Computer(String band,String name,float price){
        this.band=band;this.name=name;this.price=price;
    }
    @Override
    public int compareTo(Computer c) {
        return price>c.price?1:(price==c.price?0:-1);
    }

    public int equals(Computer c){
        return true==(band.equals(c.band) && name.equals(c.name) && price==c.price)?0:-1;
    }
}