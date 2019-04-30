package d.com.newsapp.MVP.ContentWebView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import d.com.newsapp.R;

public class DetailsActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        intiViews();
        showWebView();
    }

    private void showWebView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        Log.i("url_news", url);
        webView.loadUrl(url);
    }

    private void intiViews() {
        webView = findViewById(R.id.webView);
    }
}
