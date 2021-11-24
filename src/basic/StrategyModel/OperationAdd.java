package basic.StrategyModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 策略模式的学习(这个是加法)
 */
public class OperationAdd implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}

}
