
package myQueueCompleteUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.MyQueue;

/**
 * <p>
 * The <code> MyQueueTests </code>  is designed to be used as a basis for all
 * the MyQueue<E>data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this methods will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this list holds.
 *
 * @author Bushra Osman 
 *
 */
public class MyQueueTests {
	private MyQueue<Integer> q;
	private MyQueue<Integer> q2;
	
	private MyQueue<String> qu;
	private MyQueue<String> que;
	
	private String test1;
	private String test2;
	private String test3;
	private String test4;
	private String test5;
	
	private Integer test6;
	private Integer test7;
	private Integer test8;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		q= new MyQueue<Integer>();
		qu= new MyQueue<String>();
		test1="test1";
		test2="test2";
		test3="test3";
		test4="test4";
		test5="test5";
		test6=1;
		test7=1;
		test8=2;
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		q= null;
		qu= null;
		test1=null;
		test2=null;
		test3=null;
		test4=null;
		test5=null;
	}

	
	@Test
	public  void emptyTest() {
		//assertTrue(q.isEmpty());
       // assertEquals(q.size(),0);
        q.enqueue(test6);
		assertFalse(q.isEmpty());
	};
	
	@Test
	public void nQTest() {
		//assertTrue(q.isEmpty());
		int sizeOfQ =  (int) (Math.random()*10+3);
        for (int i = 0; i < sizeOfQ; i++) {
            qu.enqueue(test1);
        }
       // assertTrue(!q.isEmpty());
        assertEquals(qu.size(), sizeOfQ);
	};	
	
	@Test
	public void dQTest() throws EmptyQueueException {
		//assertTrue(q.isEmpty());
        qu.enqueue(test2);
        assertEquals(qu.dequeue(), test2);
	};	
	
	@Test(expected = IndexOutOfBoundsException.class)
    public void dQEmptyTest() throws IndexOutOfBoundsException {
       // assertTrue(q.isEmpty());
        try {
			q.dequeue();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	public void peekTest() throws EmptyQueueException {
		assertTrue(q.isEmpty());
        qu.enqueue(test3);
        int sizeOfQ = q.size();
        assertEquals(qu.peek(), test3);
	};
	
	@Test(expected = IndexOutOfBoundsException.class)
    public void peekEmptyTest() throws IndexOutOfBoundsException, EmptyQueueException {
		q.peek();
    }
	
	@Test
	public void equalsTest(){
		try {
		q.enqueue(test6);
		q2.enqueue(test7);
        assertEquals(q,q2);
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	};
	
	@Test
	public void sizeTest() {
	
		int sizeOfQ = (int) (Math.random()*10+3);
        for (int i = 0; i < sizeOfQ; i++) {
            qu.enqueue(test4);
        }
        assertTrue(!qu.isEmpty());
        assertEquals(qu.size(), sizeOfQ);
	};
	
	@Test
	public void dQAllTest() throws EmptyQueueException {
		assertTrue(q.isEmpty());
		int sizeOfQ =  (int) (Math.random()*10+3);
        for (int i = 0; i < sizeOfQ; i++) {
            qu.enqueue(test5);
        }
        for (int i = 0; i < sizeOfQ; i++) {
            qu.dequeue();
        }
        assertTrue(qu.isEmpty());
        assertEquals(qu.size(), 0);
        assertFalse(!qu.isEmpty());
	};
	
	@Test
	public void toArrayTest() {
       //(q.isEmpty());
        q.enqueue(test7);
        Object[] testing=q.toArray();
        assertEquals(testing.length,1);
        assertEquals(testing[0],1);
	};
	
	@Test
	public void  iteratorTest(){
//		
		qu.enqueue(test1);
		qu.enqueue(test2);
		Iterator<String> myStackIterator = qu.iterator();
		String expectedFirst =(String) myStackIterator.next();
		String expectedSecond =(String) myStackIterator.next();
		
		String actual1="test1";
		String actual2="test2";
		assertEquals(expectedFirst, actual1);
		assertEquals(expectedSecond, actual2);
	};
	

}