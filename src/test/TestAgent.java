package test;

import static org.junit.Assert.*;
import org.junit.Test;

import student42331580.*;

import java.io.IOException;

//assertEquals("Mssg", expected, actual)

public class TestAgent {

    @Test
    public void testBasicFileHandling() {
        try {
            Agent a = new Agent();
            String filepath = "./src/test/test_files/test1.txt";
            a.parseInput(filepath); // May need to check this path

        } catch (Exception e) {
			fail("Could Not Open test1.txt");
		}
    }

    @Test
	public void testParseLine() {
		try {
			Agent a = new Agent();
			a.parseInput("./src/test/test_files/test1.txt"); // May need to check this path
			assertEquals("Should be 2 stocks in buy", a.sizeBuy(), 2);
			assertEquals("Should be 1 stock in sell", a.sizeSell(), 1);
			assertEquals("Should be 0 stocks in transaction",
					a.sizeTransaction(), 0);
		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

    @Test
    public void TestParseLineBadInput() {
        try {
			Agent a = new Agent();
			a.parseInput("./src/test/test_files/test2.txt"); // May need to check this path
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
			a.parseInput("./src/test/test_files/test2.txt"); // May need to check this path
			assertEquals("Should be 2 stocks in buy", 2, a.sizeBuy());
			assertEquals("Should be 1 stock in sell", 1, a.sizeSell());
			assertEquals("Should be 0 stocks in transaction", 0,
					a.sizeTransaction());
			a.exchange();
			assertEquals("Should be 2 stocks in buy", 2, a.sizeBuy());
			assertEquals("Should be 1 stock in sell", 1, a.sizeSell());
			assertEquals("Should be 0 stocks in transaction", 0,
					a.sizeTransaction());

			// A buy and sell exactly match
			Agent b = new Agent();
			b.parseInput("./src/test/test_files/test3.txt"); // May need to check this path
			assertEquals("Should be 1 stock in buy", 1, b.sizeBuy());
			assertEquals("Should be 1 stock in sell", 1, b.sizeSell());
			assertEquals("Should be 0 stock in transaction", 0,
					b.sizeTransaction());
			b.exchange();
			assertEquals("Should be 0 stocks in buy", 0, b.sizeBuy());
			assertEquals("Should be 0 stocks in sell", 0, b.sizeSell());
			assertEquals("Should be 1 stock in transaction", 1,
					b.sizeTransaction());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

    @Test
    public void testExchangeB() {

        try {

            Agent b = new Agent();
			b.parseInput("./src/test/test_files/test5.txt"); // May need to check this path
			assertEquals("Should be 1 stock in buy", 4, b.sizeBuy());
			assertEquals("Should be 1 stock in sell", 2, b.sizeSell());
			assertEquals("Should be 0 stock in transaction", 0,
					b.sizeTransaction());
			b.exchange();
			assertEquals("Should be 0 stocks in buy", 0, b.sizeBuy());
			assertEquals("Should be 0 stocks in sell", 0, b.sizeSell());
			assertEquals("Should be 1 stock in transaction", 2,
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
			a.parseInput("./src/test/test_files/test4.txt"); // May need to check this path
			a.exchange();
			assertEquals("Should be 1 stock in buy", 1, a.sizeBuy());
			assertEquals("Should be 0 stock in sell", 0, a.sizeSell());
			assertEquals("Should be 1 stock in transaction", 1,
					a.sizeTransaction());
			assertEquals("Print transactions", "HIJK 50 $5.00", a.printTransactions());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

	@Test
	public void testPrintQueues() {
		try {
			Agent a = new Agent();
			a.parseInput("./src/test/test_files/test4.txt"); // May need to check this path
			assertEquals("Print queues", "buy HIJK 100 $10.00\nsell HIJK 50 $5.00", a.printQueues());

		} catch (Exception e) {
			fail("Exception occurred.");
		}
	}

    @Test
	public void test100Transactions() {
		long beginTime, endTime;
		Agent a = new Agent();

		try {
            beginTime = System.currentTimeMillis();
		    a.parseInput("./src/test/test_files/smltest.txt");
		    endTime = System.currentTimeMillis();
		    System.out.print("Parse 100 records = ");
		    System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.exchange();
            endTime = System.currentTimeMillis();
            System.out.print("Exchange 100 records = ");
            System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.printQueues();
            endTime = System.currentTimeMillis();
            System.out.print("Print records = ");
            System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.printTransactions();
            endTime = System.currentTimeMillis();
            System.out.print("Print Transactions = ");
            System.out.println(endTime - beginTime);
        } catch (Exception e) {
			fail("Exception occurred.");
		}
	}

    @Test
	public void test10000Transactions() {
		long beginTime, endTime;
		Agent a = new Agent();

		try {
            beginTime = System.currentTimeMillis();
		    a.parseInput("./src/test/test_files/lrgtest.txt");
		    endTime = System.currentTimeMillis();
		    System.out.print("Parse 10000 records = ");
		    System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.exchange();
            endTime = System.currentTimeMillis();
            System.out.print("Exchange 10000 records = ");
            System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.printQueues();
            endTime = System.currentTimeMillis();
            System.out.print("Print records = ");
            System.out.println(endTime - beginTime);
            beginTime = System.currentTimeMillis();
            a.printTransactions();
            endTime = System.currentTimeMillis();
            System.out.print("Print Transactions = ");
            System.out.println(endTime - beginTime);
        } catch (Exception e) {
			fail("Exception occurred.");
		}
	}

}