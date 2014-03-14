package com.example.preinstancewebbrowser;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final String TAG = "MainActivity : ";
	
	/**
	 * ViewGroup
	 */
	WebView content = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		assignViewField();
		
		content.setWebChromeClient(new WebChromeClient(){});
		content.setWebViewClient(new WebViewClient(){});	// 현재 webview 에서 보여지도록 함
		content.loadUrl("http://www.naver.com");
		
//		String summary = "<html><body>You scored <b>192</b> points.</body></html>";
//		content.loadData(summary, "text/html", null);
		 
		unassignViewField();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 뒤로 버튼 눌렀을시 뒤로가기
		if (keyCode == KeyEvent.KEYCODE_BACK){
			assignViewField();
			if (content.canGoBack())
				content.goBack();
			else{
				// confirm finish
				new AlertDialog.Builder(this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle(android.R.string.ok)
					.setMessage("종료하시겠습니까?")
					.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//Stop the activity
							MainActivity.this.finish();    
						}
					})
					.setNegativeButton(android.R.string.no, null)
					.show();
			}
			
			unassignViewField();
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
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