 package com.example.vatsal.guessthecelebrity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class MainActivity extends AppCompatActivity {

     ArrayList<String> celebURLs =new ArrayList<String>();
     ArrayList<String> celebnames =new ArrayList<String>();
    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result= "";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url= new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                while(data!=-1){
                    char current=(char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadTask task=new DownloadTask();
        String result=null;
        try{
            result=task.execute("http://www.posh24.se/kandisar").get();
            String[] splitResult=result.split("listedArticles");
            Pattern p=Pattern.compile("img src=\"(.*?)\"" );
            Matcher m=p.matcher(splitResult[0]);
            while(m.find()){
                System.out.println(m.group(1));
            }
           p=Pattern.compile("alt=\"(.*?)\"");
            m=p.matcher(splitResult[0]);
            while(m.find()){
                System.out.println(m.group(1));
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
