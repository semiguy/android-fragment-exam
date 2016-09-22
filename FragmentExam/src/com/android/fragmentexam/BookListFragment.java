package com.android.fragmentexam;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class BookListFragment extends Fragment implements RadioGroup.OnCheckedChangeListener  {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		
		Log.d("fragmentexam", "[BookListFragment]onCreateView()...");
		View viewHierarchy = inflater.inflate(R.layout.fragment_book_list, container, false);
		
		// 리스너를 라디오 그룹과 연결
		RadioGroup group = (RadioGroup) viewHierarchy.findViewById(R.id.bookSelectGroup);
		group.setOnCheckedChangeListener(this);
		
		return viewHierarchy;
	}

	@Override
	public void onCheckedChanged(RadioGroup radiogroup, int id) {
		// 라디오 버튼을 북 인덱스로 전환
		int bookIndex = translateIdToIndex(id);
		
		// 부모 액티비티를 취하고 통보하기
		OnSelectedBookChangeListener listener = (OnSelectedBookChangeListener) getActivity();
		listener.onSelectedBookChanged(bookIndex);
	}
	
	int translateIdToIndex(int id) {
		int index = -1;
		switch(id) {
		case R.id.dynamicUiBook:
			index = 0;
			break;
		case R.id.android4NewBook:
			index = 1;
			break;
		case R.id.androidSysDevBook:
			index = 2;
			break;
		case R.id.androidEngineBook:
			index = 3;
			break;
		case R.id.androidDbProgBook:
			index = 4;
			break;
		}
		
		return index;
	}
	
}
