package basic.StrategyModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 策略模式的学习
 */
public class Context {
	// 私有声明
	private Strategy strategy;

	// 有参构造
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}

}
