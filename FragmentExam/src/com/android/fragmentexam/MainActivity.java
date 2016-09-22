package com.android.fragmentexam;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements OnSelectedBookChangeListener/*View.OnClickListener*/  {
	
	boolean mIsDynamic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("fragmentexam", "[MainActivity]onCreate()...");
		// 책 상세 설명 프래그먼트 획득
		FragmentManager fm = getFragmentManager();
		Fragment bookDescFragment = fm.findFragmentById(R.id.fragmentDescription);
		
		// 찾지 못하면 동적 관리
		mIsDynamic = bookDescFragment == null || !bookDescFragment.isInLayout();
		
		// 필요하다면 리스트 프래그먼트 로드
		if(mIsDynamic) {
			// 트랜잭션 시작
			FragmentTransaction ft = fm.beginTransaction();
			
			// 프래그먼트 생성과 추가
			BookListFragment2 listFragment = new BookListFragment2();
			ft.add(R.id.layoutRoot, listFragment, "bookList");
			
			// 변화용 커밋
			ft.commit();
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Log.d("fragmentexam", "[MainActivity]onResume()...");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		Log.d("fragmentexam", "[MainActivity]onPause()...");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	*/
	@Override
	public void onSelectedBookChanged(int bookIndex) {
		// FragmentManager에 접근
		//FragmentManager fragmentManager = getFragmentManager();
		// 책 상세 설명 프래그먼트 획득
		//BookDescFragment bookDescFragment = (BookDescFragment)fragmentManager.findFragmentById(R.id.fragmentDescription);
		
		// 프래그먼트 유효성 체크
		//if(bookDescFragment == null || !bookDescFragment.isVisible()) {
			// 상세 설명 표시를 위한 액티비티 사용
			//Intent intent = new Intent(this, BookDescActivity.class);
			//intent.putExtra("bookIndex", bookIndex);
			//startActivity(intent);
		//} else {
			// 상세 설명 표시를 위해 포함하고 있는 프래그먼트 사용
			//bookDescFragment.setBook(bookIndex);
		//}
		
		BookDescFragment bookDescFragment;
		FragmentManager fm = getFragmentManager();
		
		Log.d("fragmentexam", "[MainActivity]onSelectedBookChanged() : mIsDynamic = " + mIsDynamic);
		
		// 프래그먼트 레퍼런스 유효성 검사
		if(mIsDynamic) {
			// 상세 설명 프래그먼트를 동적으로 변경하는 부분
			FragmentTransaction ft = fm.beginTransaction();
			
			// 프래그먼트 생성과 책 인덱스 첨부
			bookDescFragment = new BookDescFragment();
			Bundle args = new Bundle();
			args.putInt(BookDescFragment.BOOK_INDEX, bookIndex);
			bookDescFragment.setArguments(args);
			
			// 책 리스트 상세 설명으로 변경
			ft.replace(R.id.layoutRoot, bookDescFragment, "bookDescription");
			ft.addToBackStack(null);
			ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
			ft.commit();
			
		} else {
			// 이미 보이는 상세 설명 프레그먼트를 사용
			bookDescFragment = (BookDescFragment)fm.findFragmentById(R.id.fragmentDescription);
			bookDescFragment.setBook(bookIndex);
		}
	}
}
