package se.johan.samuelsson;

import android.webkit.WebView;
import android.webkit.WebViewClient;


//This class controls the app browser to not open links in the phone
//browser.
public class OurViewClient extends WebViewClient {
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView v, String url){
		v.loadUrl(url);
		return true;
	}

}
