package com.android.fragmentexam;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListFragment2 extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		String[] bookTitles = getResources().getStringArray(R.array.bookTitles);
		
		ArrayAdapter<String> bookTitlesAdapter;
		bookTitlesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, bookTitles);
		
		setListAdapter(bookTitlesAdapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		// 액티비티에 접근하고 인터페이스로 캐스트
		OnSelectedBookChangeListener listener = (OnSelectedBookChangeListener)getActivity();
		// 선택된 액티비티 통보
		listener.onSelectedBookChanged(position);
	}	
}
