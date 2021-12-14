
package myDLLCompleteUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.Iterator;
import utilities.MyDLL;
import utilities.MyDLLNode;

/**
 * <p>
 * The <code> MyDLLTests </code>  is designed to be used as a basis for all
 * the MyDLLNode<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this methods will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this list holds.
 *
 * @author Eunji Lee
 *
 */
public class MyDLLTests {
	private MyDLL<String> myDLL;
	private String a;
	private String b;
	private String c;
	private String d;
	
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
		myDLL = new MyDLL<String>();
		a = "a";
		b = "b";
		c = "c";
		d = "d";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		myDLL = null;
		a = null;
		b = null;
		c = null;
		d = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#MyDLL()}.
	 */
	@Test
	public void testMyDLLConstructor() {
		boolean expected = true;
		boolean actual = (myDLL != null &&
				myDLL.getHead() == null && myDLL.getTail() == null);
		
		assertEquals("My Doubly-Linked List was not created", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#getHead()}.
	 */
	@Test
	public void testGetHeadForEmptyDLL() {
		boolean expected = true;
		boolean actual = (myDLL.getHead() == null);
		
		assertEquals("Correct head was not returned", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#getHead()}.
	 */
	@Test
	public void testGetHeadForOneElementDLL() {
		myDLL.add(a);
		
		String expected = "a";		
		String actual = myDLL.getHead().getElement();
		
		assertEquals("Correct head was not returned", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#getHead()}.
	 */
	@Test
	public void testGetHeadForManyElementsDLL() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		String expected = "a";		
		String actual = myDLL.getHead().getElement();
		
		assertEquals("Correct head was not returned", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#setHead(utilities.MyDLLNode)}.
	 */
	@Test
	public void testSetHeadByNull() {
		myDLL.setHead(null);
		
		boolean expected = true;
		boolean actual = (myDLL.getHead() == null);
		
		assertEquals("Correct head was not set", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#setHead(utilities.MyDLLNode)}.
	 */
	@Test
	public void testSetHeadByNotNull() {
		MyDLLNode<String> newHead = new MyDLLNode<String>(a, null, null);
		myDLL.setHead(newHead);
		
		String expected = "a";		
		String actual = myDLL.getHead().getElement();
		
		assertEquals("Correct head was not set", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#getTail()}.
	 */
	@Test
	public void testGetTailForEmptyDLL() {
		boolean expected = true;
		boolean actual = (myDLL.getTail() == null);
		
		assertEquals("Correct tail was not returned", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#getTail()}.
	 */
	@Test
	public void testGetTailForOneElementDLL() {
		myDLL.add(a);
		
		String expected = "a";		
		String actual = myDLL.getTail().getElement();
		
		assertEquals("Correct tail was not returned", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#getTail()}.
	 */
	@Test
	public void testGetTailForManyElementsDLL() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		String expected = "d";
		String actual = myDLL.getTail().getElement();
				
		assertEquals("Correct tail was not returned", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#setTail(utilities.MyDLLNode)}.
	 */
	@Test
	public void testSetTailByNull() {
		myDLL.setTail(null);
		
		boolean expected = true;
		boolean actual = (myDLL.getTail() == null);
		
		assertEquals("Correct tail was not set", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#setTail(utilities.MyDLLNode)}.
	 */
	@Test
	public void testSetTailByNotNull() {
		MyDLLNode<String> newTail = new MyDLLNode<String>(a, null, null);
		myDLL.setTail(newTail);
		
		String expected = "a";		
		String actual = myDLL.getTail().getElement();
		
		assertEquals("Correct tail was not set", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSizeForEmptyDLL() {		
		int expected = 0;
		int actual = myDLL.size();
		
		assertEquals("Size was not correct", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSizeForForOneElementDLL() {
		myDLL.add(a);
		
		int expected = 1;
		int actual = myDLL.size();
		
		assertEquals("Size was not correct", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSizeForForManyElementsDLL() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		int expected = 4;
		int actual = myDLL.size();
		
		assertEquals("Size was not correct", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	public void testClearForEmptyDLL() {		
		myDLL.clear();
		
		boolean expected = true;
		boolean actual = (myDLL != null &&
				myDLL.getHead() == null && myDLL.getTail() == null);
		
		assertEquals("All elements were not removed", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	public void testClearForOneElementDLL() {
		myDLL.add(a);		
		myDLL.clear();
		
		boolean expected = true;
		boolean actual = (myDLL != null &&
				myDLL.getHead() == null && myDLL.getTail() == null);
		
		assertEquals("All elements were not removed", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	public void testClearForManyElementsDLL() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);		
		myDLL.clear();
		
		boolean expected = true;
		boolean actual = (myDLL != null &&
				myDLL.getHead() == null && myDLL.getTail() == null);
		
		assertEquals("All elements were not removed", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForEmptyDLL() {
		myDLL.add(0, a);
		
		String expected = "a";
		String actual = myDLL.get(0);
		int expectedSize = 1;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not added correctly at the first position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForFirstPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(0, d);
		
		String expected = "d";
		String actual = myDLL.get(0);
		int expectedSize = 4;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not added correctly at the first position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForLastPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		myDLL.add(3, d);

		String expected = "d";
		String actual = myDLL.get(3);
		int expectedSize = 4;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not added correctly at the last position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForMiddlePosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		myDLL.add(1, d);
		
		String expected = "d";
		String actual = myDLL.get(1);
		int expectedSize = 4;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not added correctly at the middle position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForNegativeIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		try {
			myDLL.add(-1, d);
			fail("Add method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForOverIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		try {
			myDLL.add(4, d);
			fail("Add method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForNullException() {
		try {
			myDLL.add(0, null);
			fail("Add method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEForBooleanReturn() {
		boolean expected = true;
		boolean actual = myDLL.add(0, a);
		
		assertEquals("True value was not returned after adding elements", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE() {	
		myDLL.add(a);
		
		String expectedFirst = "a";
		String actualFirst = myDLL.get(0);
		int expectedFirstSize = 1;
		int actualFirstSize = myDLL.size();

		assertEquals("First element was not added correctly", expectedFirst, actualFirst);
		assertEquals("Size was not updated correctly", expectedFirstSize, actualFirstSize);
		
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		String expectedLast = "d";
		String actualLast = myDLL.get(3);
		int expectedLastSize = 4;
		int actualLastSize = myDLL.size();

		assertEquals("Last element was not added correctly", expectedLast, actualLast);	
		assertEquals("Size was not updated correctly", expectedLastSize, actualLastSize);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEForNullException() {
		try {
			myDLL.add(null);
			fail("Add method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}		
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEForBooleanReturn() {		
		boolean expected = true;
		boolean actual = myDLL.add(a);
		
		assertEquals("True value was not returned after adding elements", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		MyDLL<String> toAdd = new MyDLL<String>();
		toAdd.add(a);
		toAdd.add(b);
		
		myDLL.addAll(toAdd);
		
		String expectedFirst = "a";
		String actualFirst = myDLL.get(0);
		int expectedFirstSize = 2;
		int actualFirstSize = myDLL.size();
		
		assertEquals("First element was not added correctly", expectedFirst, actualFirst);
		assertEquals("Size was not updated correctly", expectedFirstSize, actualFirstSize);
		
		myDLL.addAll(toAdd);
			
		String expectedLast = "b";
		String actualLast = myDLL.get(3);
		int expectedLastSize = 4;
		int actualLastSize = myDLL.size();
		
		assertEquals("Second element was not added correctly", expectedLast, actualLast);
		assertEquals("Size was not updated correctly", expectedLastSize, actualLastSize);
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAllForNullException() {
		try {
			myDLL.addAll(null);
			fail("Add method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAllForBooleanReturn() {
		MyDLL<String> toAdd = new MyDLL<String>();
		toAdd.add(b);
		toAdd.add(c);
		
		boolean expected = true;
		boolean actual = myDLL.addAll(toAdd);
		
		assertEquals("True value was not returned after adding element", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGet() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		String expectedFirst = "a";
		String actualFirst = myDLL.get(0);

		assertEquals("Correct first element was not returned", expectedFirst, actualFirst);
		
		
		String expectedLast = "d";
		String actualLast = myDLL.get(3);

		assertEquals("Correct last element was not returned", expectedLast, actualLast);	
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGetForNegativeIndexException() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		try {
			myDLL.get(-1);
			fail("Get method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGetForOverIndexException() {
		myDLL.add(a);
		myDLL.add(b);
		myDLL.add(c);
		myDLL.add(d);
		
		try {
			myDLL.get(4);
			fail("Get method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForOneElementDLL() {
		myDLL.add(a);
		
		String expected = "a";
		String actual = myDLL.remove(0);
		int expectedSize = 0;
		int actualSize = myDLL.size();
		
		assertEquals("Element was not removed correctly", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForFirstPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		myDLL.remove(0);
		
		String expected = "b";
		String actual = myDLL.getHead().getElement();
		int expectedSize = 3;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not removed correctly at the first position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForLastPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		myDLL.remove(3);
		
		String expected = "c";
		String actual = myDLL.getTail().getElement();
		int expectedSize = 3;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not removed correctly at the last position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForMiddlePosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		String expected = "b";
		String actual = myDLL.remove(1);
		int expectedSize = 3;
		int actualSize = myDLL.size();
		
		assertEquals(
				"Element was not removed correctly at the middle position", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForNegativeIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.remove(-1);
			fail("Remove method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForOverIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.remove(4);
			fail("Remove method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntForElementReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		String expected = "b";
		String actual = myDLL.remove(1);
		
		assertEquals("Element was not returned after removing", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEForContainedElement() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		String expected = "b";
		String actual = myDLL.remove(b);
		int expectedSize = 3;
		int actualSize = myDLL.size();
		
		assertEquals("Element was not removed correctly", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEForNotContainedElement() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		String expected = null;
		String actual = myDLL.remove(d);
		int expectedSize = 3;
		int actualSize = myDLL.size();
		
		assertEquals("Element was removed incorrectly", expected, actual);
		assertEquals("Size was not updated correctly", expectedSize, actualSize);
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEForNullException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.remove(null);
			fail("Remove method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEForElementReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		String expected = "b";
		String actual = myDLL.remove(b);
		
		assertEquals("Element was not returned after removing", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForFirstPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		myDLL.set(0, d);
		
		String expected = "d";
		String actual = myDLL.getHead().getElement();

		assertEquals("Correct element was not set at correct position", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForLastPosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		myDLL.set(2, d);
		
		String expected = "d";
		String actual = myDLL.getTail().getElement();

		assertEquals("Correct element was not set at correct position", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForMiddlePosition() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		myDLL.set(1, d);
		
		String expected = "d";
		String actual = myDLL.get(1);
		
		assertEquals("Correct element was not set at correct position", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForNegativeIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		try {
			myDLL.set(-1, d);
			fail("Set method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForOverIndexException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		try {
			myDLL.set(3, d);
			fail("Set method failed to throw IndexOutOfBoundsException");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForNullException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.set(1, null);
			fail("Set method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetForElementReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		String expected = "b";
		String actual = myDLL.set(1, d);
		
		assertEquals("Element was not returned after setting", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmptyForTrueReturn() {
		boolean expected = true;
		boolean actual = myDLL.isEmpty();
		
		assertEquals("True value was not returned correctly", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmptyForFalseReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		boolean expected = false;
		boolean actual = myDLL.isEmpty();
		
		assertEquals("False value was not returned correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsForTrueReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		boolean expected = true;
		boolean actual = myDLL.contains(b);
		
		assertEquals("True value was not returned correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsForFalseReturn() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);
		
		boolean expected = false;
		boolean actual = myDLL.contains(d);
		
		assertEquals("False value was not returned correctly", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsForNullException() {
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.contains(null);
			fail("Contain method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayForSameLength() {		
		String[] actualArray = new String[4];
		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		actualArray = myDLL.toArray(actualArray);
		
		String actualString = "";
		for(int i = 0; i < actualArray.length; i++) {
			actualString += actualArray[i];
		}

		String[] expectedArray = new String[4];
		expectedArray[0] = "a";
		expectedArray[1] = "b";
		expectedArray[2] = "c";
		expectedArray[3] = "d";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}
		
		boolean expected = true;
		boolean actual = expectedString.equals(actualString);
		
		assertEquals("Array was not converted correctly", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayForLongerLength() {		
		String[] actualArray = new String[10];
		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		actualArray = myDLL.toArray(actualArray);
		
		String actualString = "";
		for(int i = 0; i < actualArray.length; i++) {
			actualString += actualArray[i];
		}

		String[] expectedArray = new String[10];
		expectedArray[0] = "a";
		expectedArray[1] = "b";
		expectedArray[2] = "c";
		expectedArray[3] = "d";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}
		
		boolean expected = true;
		boolean actual = expectedString.equals(actualString);
		
		assertEquals("Array was not converted correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayForSmallerLength() {		
		String[] actualArray = new String[1];
		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		actualArray = myDLL.toArray(actualArray);
		
		String actualString = "";
		for(int i = 0; i < actualArray.length; i++) {
			actualString += actualArray[i];
		}

		String[] expectedArray = new String[4];
		expectedArray[0] = "a";
		expectedArray[1] = "b";
		expectedArray[2] = "c";
		expectedArray[3] = "d";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}
		
		boolean expected = true;
		boolean actual = expectedString.equals(actualString);
		
		assertEquals("Array was not converted correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayForNullException() {		
		String[] actualArray = null;
		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		try {
			myDLL.toArray(actualArray);
			fail("To array method failed to throw NullPointerException");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	public void testToArray() {		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		Object[] actualArray = myDLL.toArray();
		
		String actualString = "";
		for(int i = 0; i < actualArray.length; i++) {
			actualString += actualArray[i];
		}
		
		String[] expectedArray = new String[4];
		expectedArray[0] = "a";
		expectedArray[1] = "b";
		expectedArray[2] = "c";
		expectedArray[3] = "d";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}
		
		boolean expected = true;
		boolean actual = expectedString.equals(actualString);
		
		assertEquals("Array was not converted correctly", expected, actual);
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	public void testToArrayForEmptyDLL() {		
		Object[] actualArray = myDLL.toArray();
		
		String actualString = "";
		for(int i = 0; i < actualArray.length; i++) {
			actualString += actualArray[i];
		}
		
		String[] expectedArray = new String[0];
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}
		
		boolean expected = true;
		boolean actual = expectedString.equals(actualString);
		
		assertEquals("Array was not converted correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	public void testIterator() {		
		myDLL.add(a);		
		myDLL.add(b);		
		myDLL.add(c);		
		myDLL.add(d);
		
		String expected = "abcd";
		String actual = "";
		
		Iterator<String> iterator = myDLL.iterator();
		
		while(iterator.hasNext()) {
			actual += iterator.next();
		}
		
		assertEquals("Iterator did not work correctly", expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	public void testIteratorForEmptyDLL() {		
		String expected = "";
		String actual = "";
		
		Iterator<String> iterator = myDLL.iterator();
		
		while(iterator.hasNext()) {
			actual += iterator.next();
		}
		
		assertEquals("Iterator did not work correctly", expected, actual);
	}
}
