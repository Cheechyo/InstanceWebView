package com.example.preinstancewebbrowser;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	/**
	 * ViewGroup
	 */
	WebView content = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		assignViewField();
		
		content.setWebViewClient(new WebViewClient());
		content.loadUrl("http://www.naver.com");
		
//		String summary = "<html><body>You scored <b>192</b> points.</body></html>";
//		content.loadData(summary, "text/html", null);
		 
		unassignViewField();
	}

	/**
	 * 화면에 보여지는 View들을 가져와 ViewGroup 필드에 대한다.
	 */
	private void assignViewField() {
		content = (WebView)findViewById(R.id.main_content_webView);
	}
	
	/**
	 * view 필드들을 초기화한다. null값이 대입된다.
	 */
	private void unassignViewField(){
		content = null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
