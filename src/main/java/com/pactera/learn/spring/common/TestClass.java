package com.pactera.learn.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class TestClass {

    public static Boolean testFunction(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String servletPath = request.getServletPath();
        if (servletPath.contains("Login1")) {
            return false;
        }
/*
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "test1");
        HashMap map2 = new HashMap();
        map2.put("name", "test2");
        HashMap map3 = new HashMap();
        map3.put("name", "test3");

        List<HashMap> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        for (HashMap map : mapList) {
            System.out.println(map.get("name"));
        }
*/

        Hashtable<String, String> hashtable1 = new Hashtable<>();
        hashtable1.put("name", "test1");
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("name", "test2");
        Hashtable hashtable3 = new Hashtable();
        hashtable3.put("name", "test3");
        List<Hashtable> hashtableList = new ArrayList<>();
        hashtableList.add(hashtable1);
        hashtableList.add(hashtable2);
        hashtableList.add(hashtable3);

/*
        for (Hashtable hashtable : hashtableList) {
            System.out.println(hashtable.get("name"));
        }

        hashtableList.stream().forEach(hashtable -> System.out.println(hashtable.get("name")));

        hashtableList.forEach(hashtable -> System.out.println(hashtable.get("name")));
        Iterator<Hashtable> iterator = hashtableList.iterator();
        while(iterator.hasNext()) {
            Hashtable hashtable = iterator.next();
            System.out.println(hashtable.get("name"));
        }
*/

        Iterator<Hashtable> iterator = hashtableList.iterator();
        while(iterator.hasNext()) {
            Hashtable hashtable = iterator.next();
            if(hashtable.get("name").toString().contains("test")){
                iterator.remove();
            }
        }

        hashtableList.forEach(hashtable -> System.out.println(hashtable.get("name")));
        return true;
    }

}
