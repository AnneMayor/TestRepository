package ch15.exam02;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("Title1", "Content1", "Writer1"));
		list.add(new Board("Title2", "Content2", "Writer2"));
		list.add(new Board("Title3", "Content3", "Writer3"));
		list.add(new Board("Title4", "Content4", "Writer4"));
		list.add(new Board("Title5", "Content5", "Writer5"));
		
	}
}