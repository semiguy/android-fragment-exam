package com.android.fragmentexam;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookDescFragment extends Fragment {
	
	// 책 인덱스 인자명
	public static final String BOOK_INDEX = "book index";
	// 책 인덱스 디폴트값
	private static final int BOOK_INDEX_NOT_SET = -1;
	
	String[] mBookDescriptions;
	TextView mBookDescriptionsTextView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		//return super.onCreateView(inflater, container, savedInstanceState);
		Log.d("fragmentexam", "[BookDescFragment]onCreateView()...");
		
		View viewHierarcy = inflater.inflate(R.layout.fragment_book_desc, container, false);
		
		// 책 상세내역의 array 로드
		mBookDescriptions = getResources().getStringArray(R.array.bookDescriptions);
		
		// 책 상세내역 텍스트 뷰 레퍼런스 획득
		mBookDescriptionsTextView = (TextView)viewHierarcy.findViewById(R.id.bookDescription);
		
		// 첨부된 책 인덱스가 있다면 획득
		Bundle args = getArguments();
		int bookIndex = args != null ? args.getInt(BOOK_INDEX, BOOK_INDEX_NOT_SET) : BOOK_INDEX_NOT_SET;
		
		// 책 인덱스를 찾았으면 사용
		if (bookIndex != BOOK_INDEX_NOT_SET) {
			setBook(bookIndex);
		}
		
		return viewHierarcy;
	}
	
	public void setBook(int bookIndex) {
		Log.d("fragmentexam", "[BookDescFragment]setBook() : bookIndex = " + bookIndex);
		// 책 상세 설명 살펴보기
		String bookDescription = mBookDescriptions[bookIndex];
		
		// 표시하기
		mBookDescriptionsTextView.setText(bookDescription);
	}
}
