package test;

import static org.junit.Assert.*;
import org.junit.Test;

import student42331580.*;

public class TestAgent {

	@Test
	public void testParseLine() {
		try {
			Agent a = new Agent();
			a.parseInput("./test_files/test1.txt"); // May need to check this path
			assertEquals("Should be 2 stocks in buy", a.sizeBuy(), 2);
			assertEquals("Should be 1 stock in sell", a.sizeSell(), 1);
			assertEquals("Should be 0 stocks in transaction",
					a.sizeTransaction(), 0);
		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

	@Test
	public void testExchange() {
		try {
			// Can't exchange
			Agent a = new Agent();
			a.parseInput("./test_files/test2.txt"); // May need to check this path
			assertEquals("Should be 2 stocks in buy", a.sizeBuy(), 2);
			assertEquals("Should be 1 stock in sell", a.sizeSell(), 1);
			assertEquals("Should be 0 stocks in transaction",
					a.sizeTransaction(), 0);
			a.exchange();
			assertEquals("Should be 2 stocks in buy", a.sizeBuy(), 2);
			assertEquals("Should be 1 stock in sell", a.sizeSell(), 1);
			assertEquals("Should be 0 stocks in transaction",
					a.sizeTransaction(), 0);

			// A buy and sell exactly match
			Agent b = new Agent();
			a.parseInput("./test_files/test3.txt"); // May need to check this path
			assertEquals("Should be 1 stock in buy", 1, b.sizeBuy());
			assertEquals("Should be 1 stock in sell", 1, b.sizeSell());
			assertEquals("Should be 0 stock in transaction", 0,
					b.sizeTransaction());
			b.exchange();
			assertEquals("Should be 0 stock in buy", 0, b.sizeBuy());
			assertEquals("Should be 0 stock in sell", 0, b.sizeSell());
			assertEquals("Should be 1 stock in transaction", 1,
					b.sizeTransaction());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

	@Test
	public void testPrintTransactions() {
		try {
			// Can't exchange
			Agent a = new Agent();
			a.parseInput("./test_files/test4.txt"); // May need to check this path
			a.exchange();
			assertEquals("Should be 1 stock in buy", 1, a.sizeBuy());
			assertEquals("Should be 0 stock in sell", 0, a.sizeSell());
			assertEquals("Should be 1 stock in transaction", 1,
					a.sizeTransaction());
			assertEquals("Print transactions", "HIJK 50 $5.0", a.printTransactions());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}
	
	@Test
	public void testPrintQueues() {
		try {
			Agent a = new Agent();
			a.parseInput("./test_files/test4.txt"); // May need to check this path
			assertEquals("Print queues", "buy HIJK 100 $10\nsell HIJK 50 $5.00", a.printQueues());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

}
