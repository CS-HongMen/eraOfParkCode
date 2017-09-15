package com.iFox.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public class Test {
    @org.junit.Test
    public void testHttp() {
        Map<String,String> map = new HashMap<>();
        map.put("email","419881361@qq.com");
        map.put("password","123");
        Net("http://localhost:8080/login",map);
    }

    public static void Net(String path, Map<String, String> map) {
        try {
            URL url;
            HttpURLConnection connection;
            StringBuffer sb = new StringBuffer();
            sb.append(path).append("?");
            for (Map.Entry<String, String> map1 : map.entrySet()) {
                sb.append(map1.getKey()).append("=").append(map1.getValue()).append("&");
            }

            url = new URL(sb.substring(0,sb.length()-1).toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer result = new StringBuffer();
            String line = new String();
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
