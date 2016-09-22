package com.android.fragmentexam;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class BookDescActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_desc);
		
		// 액티비티 인텐트로부터 책 인덱스 찾아오기
		Intent intent = getIntent();
		int bookIndex = intent.getIntExtra("bookIndex", -1);
		
		if(bookIndex != -1) {
			// BookDescFragment에 접근하기 위해 FragmentManager 사용
			FragmentManager fm = getFragmentManager();
			BookDescFragment bookDescFragment = (BookDescFragment)fm.findFragmentById(R.id.fragmentDescription);
			
			// 책 제목 표시
			bookDescFragment.setBook(bookIndex);
		}
	}
}
