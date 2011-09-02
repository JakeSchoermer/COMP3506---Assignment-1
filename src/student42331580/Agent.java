package student42331580;

import java.io.*;
import java.util.StringTokenizer;
import datastructures.*;

public class Agent implements IAgent {

	private ListQueue buyOrders;
	private ListQueue sellOrders;
	private ArrayQueue<Stock> transactions;

	/*
	 * Default constructor
	 */
	public Agent() {
		// You may choose which data structures you would like to use

		this.buyOrders = new ListQueue();
		this.sellOrders = new ListQueue();
		this.transactions = new ArrayQueue<Stock>();
	}

	/*
	 * Takes a file name as input and parses the commands in the file
	 */
	public int parseInput(String fileName) throws InvalidInputException {

        int ret = 0;
        Node node = new Node<Stock>(null,null);

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream dstream = new DataInputStream(fstream);
            InputStreamReader isreader = new InputStreamReader(dstream);
            BufferedReader file = new BufferedReader(isreader);

            //Parse each line in the file add add the parameters to the appropriate Queue
            String line;
            int LineNumber = 1;


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

        Stock purchase = new Stock();
        Stock sale = new Stock();

        if (this.buyOrders.isEmpty() || this.sellOrders.isEmpty()) {
            return;
        }
        int buyOrdersOrigSize = buyOrders.size();

        for (int i=0; i<buyOrdersOrigSize; i++) {
            purchase = (Stock)this.buyOrders.front();

            for (int j=0; j<this.sellOrders.size();j++) {
                sale = (Stock)this.sellOrders.front();

                //If Match
                if ((purchase.getName().equals(sale.getName())) && (purchase.getPrice() >= sale.getPrice())) {
                    //Exact Match
                    if (purchase.getQuantity() == sale.getQuantity()) {
                        this.transactions.enqueue(sale);
                        this.sellOrders.dequeue();
                        this.buyOrders.dequeue();
                    }

                    else if (purchase.getQuantity() > sale.getQuantity()) {
                        this.transactions.enqueue(sale);
                        this.sellOrders.dequeue();
                    }

                    else {
                        ((Stock) this.buyOrders.front()).setQuantity(sale.getQuantity() - purchase.getQuantity());
                    }
                    break;
                }

                //No Match
                else {
                    //Do Nothing.
                }
            }
        }
    }

	/*
	 * Returns a string of the buy and sell orders. See assignment spec for more
	 * detail.
	 */
	public String printQueues() {
		//Copy the buyOrders and sellOrders
        ListQueue localbuys = new ListQueue();
        localbuys = this.buyOrders;

        ListQueue localsells = new ListQueue();
        localsells = this.sellOrders;

        String output = "";

        String product;
        int quantity;
        String price;

        Stock item;
        Node node;

        int b = localbuys.size();

        for (int i=0;i<b;i++) {
            item = (Stock)localbuys.dequeue();

            product = item.getName();
            quantity = item.getQuantity();
            price = Double.toString(item.getPrice());

            if (price.split("\\.", 2)[1].equals("0")) {
                price = price.split("\\.",2)[0] + ".00";
            }

            output+="buy "+product+" "+quantity+" $"+price;

            if (i < b) {
                output+= "\n";
            }
        }

        int s = localsells.size();

        for (int i=0;i<s;i++) {

            item = (Stock)localsells.dequeue();


            product = item.getName();
            quantity = item.getQuantity();
            price = Double.toString(item.getPrice());

            if (price.split("\\.", 2)[1].equals("0")) {
                price = price.split("\\.",2)[0] + ".00";
            }

            output+="sell "+product+" "+quantity+" $"+price;


            if (i < localsells.size()) {
                output+= "\n";
            }
        }
		return output; // To prevent an error in the project
	}

	/*
	 * Returns a string of the transactions. See assignment spec for more
	 * detail.
	 */
	public String printTransactions() {
		// Implement this method
        ArrayQueue transactions = new ArrayQueue<Stock>();
        transactions = this.transactions;

        String output = "";

        String product;
        int quantity;
        String price;

        Stock item;
        Node node;

        int t = transactions.size();

        for (int i=0;i<t;i++) {
            item = (Stock)transactions.dequeue();

            product = item.getName();
            quantity = item.getQuantity();
            price = Double.toString(item.getPrice());

            if (price.split("\\.", 2)[1].equals("0")) {
                price = price.split("\\.",2)[0] + ".00";
            }

            output+=product+" "+quantity+" $"+price;

            if (i < t-1) {
                output+= "\n";
            }
        }
        return output;
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