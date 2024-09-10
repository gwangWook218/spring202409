package ch03;

public class AddCalc implements Calculator {
	@Override
	public Integer calc(Integer x, Integer y) {
		return x + y;
	}
}
