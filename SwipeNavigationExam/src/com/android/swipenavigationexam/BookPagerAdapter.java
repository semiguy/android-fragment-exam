package com.android.swipenavigationexam;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BookPagerAdapter extends FragmentPagerAdapter {
	
	final String[] mBookTitles;
	final String[] mBookTitleShort;
	final String[] mBookDescriptions;

	// Creating an array of drawable resources as a resource adds some complications
	// that are outside the scope of our discussion so just loading the array here
	// in code. If you'd like to learn more about working with an array of resources
	// that is defined as a resource, checkout the Typed Array documentation on
	// the Android developer site:
	// http://developer.android.com/guide/topics/resources/more-resources.html#TypedArray
	final int[] mTopImageResourceIds = 
		{ 
			R.drawable.db_programming_top_card,
			R.drawable.android_4_top_card,
			R.drawable.sys_dev_top_card,
			R.drawable.and_engine_top_card
		};
	
	public BookPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		
		Resources resources = context.getResources();
		mBookTitles = resources.getStringArray(R.array.book_titles);
		mBookTitleShort = resources.getStringArray(R.array.book_titles_short);
		mBookDescriptions = resources.getStringArray(R.array.book_descriptions);
	}
	
	@Override
	public Fragment getItem(int idx) {
		
		// 프래그먼트를 위한 인자값 저장
		Bundle arguments = new Bundle();
		arguments.putString(BookFragment.BOOK_TITLE, mBookTitles[idx]);
		arguments.putString(BookFragment.BOOK_DESCRIPTIONS, mBookDescriptions[idx]);
		arguments.putInt(BookFragment.TOP_IMAGE, mTopImageResourceIds[idx]);
		
		// 프래그먼트 인스턴스 생성과 인자 전달
		BookFragment bookFragment = new BookFragment();
		bookFragment.setArguments(arguments);
			
		// 프래그먼트 인스턴스 리턴
		return bookFragment;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		//return super.getPageTitle(position);
		return mBookTitleShort[position];
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return 0;
		return mBookTitleShort.length;
	}
}
