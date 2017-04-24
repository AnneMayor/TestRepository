package ch14.exam05;

@FunctionalInterface // 개발자의 실수를 막기 위해서 어노테이션 꼭 집어넣기!
public interface FunctionalInterface1 {
	public boolean method(String a, String b);
}