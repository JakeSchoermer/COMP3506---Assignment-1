package student42331580;

import java.util.StringTokenizer;
import datastructures.*;

public class Agent implements IAgent {

	private IREPLACEME<Stock> buyOrders;
	private IREPLACEME<Stock> sellOrders;
	private IREPLACEME<Stock> transactions;

	/*
	 * Default constructor
	 */
	public Agent() {
		// You may choose which data structures you would like to use

		this.buyOrders = new REPLACEME<Stock>();
		this.sellOrders = new REPLACEME<Stock>();
		this.transactions = new REPLACEME<Stock>();
	}

	/*
	 * Takes a file name as input and parses the commands in the file
	 */
	public int parseInput(String fileName) {
		// Implement this method
		return 0; // To prevent an error in the project
	}

	/*
	 * Tries to match buy and sell orders. See assignment spec for more detail.
	 */
	public void exchange() {
		// Implement this method
	}

	/*
	 * Returns a string of the buy and sell orders. See assignment spec for more
	 * detail.
	 */
	public String printQueues() {
		// Implement this method
		return ""; // To prevent an error in the project
	}

	/*
	 * Returns a string of the transactions. See assignment spec for more
	 * detail.
	 */
	public String printTransactions() {
		// Implement this method
		return ""; // To prevent an error in the project

	}

	public int sizeSell() {
		return this.sellOrders.size();
	}

	public int sizeBuy() {
		return this.buyOrders.size();
	}

	public int sizeTransaction() {
		return this.transactions.size();
	}

}
