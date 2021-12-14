
package myStackCompleteUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.EmptyStackException;
import utilities.Iterator;
import utilities.MyStack;

/**
 * <p>
 * The <code>MyStackTests </code> is designed to be used as a basis for all
 * the MyStack<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this methods will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this list holds.
 *
 * @author Jonghan Park
 *
 */
public class MyStackTests {

	private MyStack<String> myStack;
	private MyStack<String> myStack2;
	private String test1;
	private String test2;
	private String test3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myStack = new MyStack<String>();
		myStack2 = new MyStack<String>();
		test1 = new String("test1");
		test2 = new String("test2");
		test3 = new String("test3");

	}

	@After
	public void tearDown() throws Exception {
		myStack = null;
		myStack2 = null;
		test1 = null;
		test2 = null;
		test3 = null;
	}
	
	/**
	 * Test method for {@link utility.MyStack#push(java.lang.Object)}.
	 * @throws NullPointerException 
	 * @throws EmptyStackException 
	 */
	@Test
	public void testPush_ForStackPushedCorrectly() throws NullPointerException, EmptyStackException {
		String expected = "test3";
			myStack.push(test1);
			myStack.push(test2);
			myStack.push(test3);
			String actual = myStack.peek();
			assertEquals(expected, actual);

	}
	
	/**
	 * Test method for {@link utility.MyStack#push(java.lang.Object)}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testPushNull_ForNullPointerException() throws NullPointerException {
		try {
			myStack.push(null);
		}catch(NullPointerException e) {
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link utility.MyStack#pop()}.
	 * @throws NullPointerException 
	 * @throws EmptyStackException 
	 */
	@Test
	public void testPopTopStack_ForStackPoppedCorrectly() throws NullPointerException, EmptyStackException {
		String expected = "test3";
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);

		String actual = myStack.pop();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link utility.MyStack#pop()}.
	 * @throws NullPointerException 
	 * @throws EmptyStackException 
	 */
	@Test
	public void testPop_ForEmptyStackException() throws EmptyStackException {
		try {
			myStack.pop();
		} catch(EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyStack#peek()}.
	 * @throws NullPointerException 
	 * @throws EmptyStackException 
	 */
	@Test
	public void testPeekTopStack_ForStackPeekedCorrectly() throws NullPointerException, EmptyStackException {
		String expected = "test3";
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);
		
		String actual = myStack.peek();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link utility.MyStack#peek()}.
	 * @throws NullPointerException 
	 * @throws EmptyStackException 
	 */
	@Test
	public void testPeek_ForEmptyStackException() throws EmptyStackException {
		try {
			myStack.peek();
		} catch(EmptyStackException e) {
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link utility.MyStack#search(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testSearchLastPosition() throws NullPointerException {
		int expected = 3;
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);
		
		int actual = myStack.search("test1");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#search(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testSearchSecondPosition() throws NullPointerException {
		int expected = 2;
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);
		
		int actual = myStack.search("test2");
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link utility.MyStack#search(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testSearchFirstPosition() throws NullPointerException {
		int expected = 1;
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);
		
		int actual = myStack.search("test3");
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link utility.MyStack#search(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testSearchElementNotInPosition() throws NullPointerException {
		int expected = -1;
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);
		

		int actual = myStack.search("test5");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#search(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testSearchNull_ForNullPointerException() throws NullPointerException {
		try {
			test1 = null;
			myStack.push(test1);
		} catch(NullPointerException e) {
			assertTrue(true);
		}
		

	}

	/**
	 * Test method for {@link utility.MyStack#contains(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testContains_ForTrue() throws NullPointerException {
		
		myStack.push(test1);
		boolean expectedTrue = myStack.contains(test1);
		assertTrue(expectedTrue);

	}

	/**
	 * Test method for {@link utility.MyStack#contains(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testContains_ForFalse() throws NullPointerException {
		
		myStack.push(test1);
		boolean expectedFalse = myStack.contains(test2);
		assertFalse(expectedFalse);
	}

	/**
	 * Test method for {@link utility.MyStack#contains(java.lang.Object)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testContainsNull_ForNullPointerException() throws NullPointerException {
		
		try {
			test1 = null;
			myStack.contains(test1);
		} catch(NullPointerException e) {
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link utility.MyStack#equals(utility.StackADT)}.
	 * @throws exceptions.NullPointerException 
	 */
	@Test
	public void testEqualsTwoStacks_ForTrue() throws NullPointerException {
		boolean expected = true;
		myStack.push(test1);
		myStack2.push(test1);
		boolean actual = myStack.equals(myStack2);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link utility.MyStack#equals(utility.StackADT)}.
	 */
	@Test
	public void testEqualsTwoStacks_ForFalse() throws NullPointerException {
		boolean expected = false;
		
		myStack.push(test1);
		myStack2.push(test2);
		boolean actual = myStack.equals(myStack2);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link utility.MyStack#size()}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testSize() throws NullPointerException {
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);

		int expected = 3;
		int actual = myStack.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_ForTrue() {
		boolean expected = true;
		boolean actual = myStack.isEmpty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#isEmpty()}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testIsEmpty_ForFalse() throws NullPointerException {
		myStack.push(test1);
		
		boolean expected = false;
		boolean actual = myStack.isEmpty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#clear()}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testClear() throws NullPointerException {
		myStack.push(test1);
		myStack.push(test2);
		myStack.push(test3);

		myStack.clear();
		boolean expected = true;
		boolean actual = myStack.isEmpty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link utility.MyStack#toArray(E[])}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testArraySpecificType_ForAllStacksStored() throws NullPointerException {
		String[] testArray = new String[2];
		myStack.push(test1);
		myStack.push(test2);
		myStack.toArray(testArray);
		
		String expected1 = testArray[0];
		String expected2 = testArray[1];
		
		String actual1 = test1;
		String actual2 = test2;
		
		assertEquals(expected2, actual1);
		assertEquals(expected1, actual2);
		
	}

	/**
	 * Test method for {@link utility.MyStack#toArray(E[])}.
	 */
	@Test
	public void testArraySpecificTypeNull_ForNullPointerException() throws NullPointerException {
		test1 = null;
		test2 = null;
		
		String[] testArray = new String[2];
		try {
			myStack.push(test1);
			myStack.push(test2);
			myStack.toArray(testArray);
		}catch(NullPointerException e) {
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link utility.MyStack#toArray()}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testToArray_ForAllStacksStored() throws NullPointerException {
		Object[] testArray = new Object[2];

			myStack.push(test1);
			myStack.push(test2);
			testArray = myStack.toArray();
			
			String expectedFirstElement = "test2";
			String expectedSecondElement = "test1";
			
			String actual1 = (String) testArray[0];
			String actual2 = (String) testArray[1];
			
			assertEquals(expectedFirstElement, actual1);
			assertEquals(expectedSecondElement, actual2);

	}

	/**
	 * Test method for {@link utility.MyStack#iterator()}.
	 * @throws NullPointerException 
	 */
	@Test
	public void testIterator() throws NullPointerException {
		myStack.push(test1);
		myStack.push(test2);
		Iterator<String> myStackIterator = myStack.iterator();
		String expectedFirstElement = (String) myStackIterator.next();
		String expectedSecondElement = (String) myStackIterator.next();
		String actual1 = "test1";
		String actual2 = "test2";
		assertEquals(expectedFirstElement, actual2);
		assertEquals(expectedSecondElement, actual1);
	}

}
