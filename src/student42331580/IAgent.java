package student42331580;

public interface IAgent {

	public int parseInput(String str) throws InvalidInputException;

	public void exchange();

	public String printQueues();

	public String printTransactions();

	public int sizeSell();

	public int sizeBuy();

	public int sizeTransaction();

}
