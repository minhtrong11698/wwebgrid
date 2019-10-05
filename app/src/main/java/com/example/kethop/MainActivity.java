package com.example.kethop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] imageIDs={
            R.mipmap.garena,
            R.mipmap.garena,
            R.mipmap.garena,
            R.mipmap.garena,
            R.mipmap.garena,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv=findViewById(R.id.webview);
        WebSettings webSettings=wv.getSettings();
        GridView gridView=findViewById(R.id.gridview1);
        gridView.setAdapter(new ImageAdapter(this));
        // Enable JavaScript WebSettings webSettings =
        // WebSettings webSettings = myWebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        // Provide a WebViewClient for your WebView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"pic"+(position+1)+"selected",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;
        public ImageAdapter(Context c){
            context=c;
        }
        public int getCount(){
            return  imageIDs.length;
        }
        public Object getItem(int posotion){
            return posotion;
        }
        public long getItemId(int positon){
            return positon;
        }
        public  View getView(final int positon, View convertView, ViewGroup parent){
            ImageView imageView;
            if (convertView==null){
                imageView=new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5, 5, 5, 5);
                imageView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        openWB("http://www.google.com");
                        openyt("http://www.youtube.com");


                    }
                }

                );
            }else {
                imageView= (ImageView) convertView;
            }
            imageView.setImageResource(imageIDs[positon]);
            return imageView;
        }
    }

    private void openyt(String url) {
        Intent currentBrowserIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        startActivity(currentBrowserIntent );

    }

    private void openWB(String url) {
        Intent currentBrowserIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        startActivity(currentBrowserIntent );
    }
}
