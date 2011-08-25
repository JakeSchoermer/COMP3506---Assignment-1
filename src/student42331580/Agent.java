package student42331580;

import java.io.*;
import java.util.StringTokenizer;
import datastructures.*;
import student42331580.*;

public class Agent implements IAgent {

	private ArrayQueue<Stock> buyOrders;
	private ArrayQueue<Stock> sellOrders;
	private ArrayQueue<Stock> transactions;

	/*
	 * Default constructor
	 */
	public Agent() {
		// You may choose which data structures you would like to use

		this.buyOrders = new ArrayQueue<Stock>();
		this.sellOrders = new ArrayQueue<Stock>();
		this.transactions = new ArrayQueue<Stock>();
	}

	/*
	 * Takes a file name as input and parses the commands in the file
	 */
	public int parseInput(String fileName) throws InvalidInputException {

        int ret = 0;

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream dstream = new DataInputStream(fstream);
            InputStreamReader isreader = new InputStreamReader(dstream);
            BufferedReader file = new BufferedReader(isreader);

            //Parse each line in the file add add the parameters to the appropriate Queue
            String line;
            int LineNumber = 1;
            int nodeIdx = 0;

            while ((line = file.readLine())  != null) {

                if (line != "") { //Skip Line if Empty
                    StringTokenizer st = new StringTokenizer(line);

                    if (st.countTokens() != 4) {
                        ret = -1;
                        throw new InvalidInputException(LineNumber);
                    }

                    String transactionType = st.nextToken();
                    String stockName = st.nextToken();
                    int quantity = Integer.parseInt(st.nextToken());
                    String tempPrice = st.nextToken();
                    double price = Double.parseDouble(tempPrice.substring(1, tempPrice.length()));

                    Stock stock = new Stock(stockName, quantity, price);

                    if (transactionType.equals("buy")) {
                        this.buyOrders.enqueue(stock);
                    }
                    else if (transactionType.equals("sell")) {
                        this.sellOrders.enqueue(stock);
                    }
                    else {
                        ret = -1;
                        throw new InvalidInputException(LineNumber);
                    }
                }
                LineNumber++;
            }
        }
        catch (FileNotFoundException e){//Catch exception if any
            System.err.println("File Not Found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }


		return ret; // To prevent an error in the project
	}

	/*
	 * Tries to match buy and sell orders. See assignment spec for more detail.
	 */
	public void exchange() {
		// Implement this method

        for (int i=0; i<buyOrders.size(); i++) {
            Stock stock = buyOrders.dequeue();

        }

	}

	/*
	 * Returns a string of the buy and sell orders. See assignment spec for more
	 * detail.
	 */
	public String printQueues() {
		//Copy the buyOrders and sellOrders
        ArrayQueue localbuys = new ArrayQueue<Stock>();
        localbuys = this.buyOrders;

        ArrayQueue localsells = new ArrayQueue<Stock>();
        localsells = this.sellOrders;

        for (int i=0;i<localbuys.size();i++) {
            System.out.println("buy "+localbuys.dequeue());
        }

        for (int i=0;i<localsells.size();i++) {
            System.out.println("sell "+localsells.dequeue());
        }
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
