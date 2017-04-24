package ch09.exam08;

public class Button {

	// Field
	private OnClickListener onClickListner;
	// Constructor
	// Method
	public void setOnClickListner(OnClickListener onClickListner){
		this.onClickListner = onClickListner;
	}
	
	public void touch() {
		if(onClickListner != null ){
			onClickListner.onClick(); // if문 없으면 nullPointException이 온다!
		}
	}
	// Nested Interface
	interface OnClickListener {
		void onClick();
	}
}

//이거 정말 많이 쓰는 패턴...1시간동안 명상에 잠기자!