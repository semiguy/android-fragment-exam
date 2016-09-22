package com.android.dialogfragmentexam;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyDialogFragment extends DialogFragment implements View.OnClickListener {
	
	// 통보를 위한 인터페이스 액티비티 구현
	public interface OnButtonClickListener {
		void onButtonClick(int buttonId);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setStyle(DialogFragment.STYLE_NORMAL, 0);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		
		View theView = inflater.inflate(R.layout.fragment_my_dialog, container, false);
		
		// 예 버튼 클릭 이벤트 연결과 리퀘스트 포커스
		View yesButton = theView.findViewById(R.id.btnYes);
		yesButton.setOnClickListener(this);
		yesButton.requestFocus();
		
		// 아니오 버튼 클릭 이벤트 연결
		View noButton = theView.findViewById(R.id.btnNo);
		noButton.setOnClickListener(this);
		
		// 다이얼로그 프래그먼트 츨면에서 다이얼로그 설정
		Dialog dialog = getDialog();
		dialog.setTitle(getString(R.string.myDialogFragmentTitle));
		dialog.setCanceledOnTouchOutside(false);
		
		return theView;
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		int buttonId = view.getId();
		
		// 버튼 선택에 대한 통보
		OnButtonClickListener parentActivity = (OnButtonClickListener) getActivity();
		parentActivity.onButtonClick(buttonId);
		
		// 다이얼로그 프래그먼트 닫기
		dismiss();
	}
}
