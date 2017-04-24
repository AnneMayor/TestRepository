package ch14_practice.exam09;

import java.util.function.ToIntFunction;

public class LambdaExample06 {

	private static Student[] students = { new Student("ȫ�浿", 90, 96), new Student("�ſ��", 95, 93) };

	public static double avg(ToIntFunction<Student> arg) {
		int sum = 0;
		for (Student student : students) {
			sum += arg.applyAsInt(student);
		}
		double avg = sum / students.length;
		return avg;
		
		/*
		 * double engSum = 0; double mathSum = 0; for(Student student :
		 * students) { engSum += student.englishScore; mathSum +=
		 * student.mathScore; } students[0].englishScore = (int) (engSum /
		 * students.length); students[1].mathScore = (int) (mathSum /
		 * students.length); return arg.applyAsInt();
		 * ĩ...���� ���ٽı��� �����ϴ°� ���ƴ�...�ФФ���...���� �˰��� �Ƿ��� ������ ��������...�Ф�
		 */
	}

	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("���� ��� ����: " + englishAvg);
		
		double englishAvg = avg(students[0]::getEnglishScore());
		double englishAvg = avg(students[1]::getEnglishScore());
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("���� ��� ����: " + mathAvg);
	}

	public static class Student {
		private String name;
		private int englishScore;
		private int mathScore;

		public Student(String name, int englishScore, int mathScore) {
			this.name = name;
			this.englishScore = englishScore;
			this.mathScore = mathScore;
		}

		public String getName() {
			return name;
		}

		public int getEnglishScore() {
			return englishScore;
		}

		public int getMathScore() {
			return mathScore;
		}
	}

}
