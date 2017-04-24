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
			onClickListner.onClick(); // if�� ������ nullPointException�� �´�!
		}
	}
	// Nested Interface
	interface OnClickListener {
		void onClick();
	}
}

//�̰� ���� ���� ���� ����...1�ð����� ��� �����!