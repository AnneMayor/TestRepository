package hw08.exam01;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List getBoardList() {
		List<Board> list = new ArrayList<>();
		list.add(new Board("����1", "����1"));
		list.add(new Board("����2", "����2"));
		list.add(new Board("����3", "����3"));
		
		return list;
	}
} 
