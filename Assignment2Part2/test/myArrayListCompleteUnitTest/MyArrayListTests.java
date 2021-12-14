
package myArrayListCompleteUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.Iterator;
import utilities.MyArrayList;

/**
 * <p>
 * The <code> MyArrayListTests </code>  is designed to be used as a basis for all
 * the MyArrayList<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this methods will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this list holds.
 *
 * @author Jihoon Oh
 *
 */
public class MyArrayListTests {

	private MyArrayList<String>  MyList;
	private String  one ;
	private String  two ;
	private String  three ;

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
		MyList = new MyArrayList<String>();
		one = new String("Eunji");
		two = new String("jounghan");
		three = new String("Bushra");
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		MyList = null;
		one =null;
		two = null;
		three = null;

	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		MyList.add(one);
		
		assertEquals(1,MyList.size());
		assertFalse(MyList.isEmpty());
        
	      
	}
	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.clear();
		assertTrue(MyList.isEmpty());
	
		
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntObject() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(2, one);
		
		
		assertEquals(7,MyList.size());
		assertEquals(one,MyList.get(2));
		assertEquals(three,MyList.get(3));
		assertFalse(MyList.isEmpty());
		
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject() {
		
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		assertEquals(3,MyList.size());
		assertEquals(three,MyList.get(2));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(adt.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		MyArrayList<String>  test = new MyArrayList<String>();
		test.add(one);
		test.add(two);
		test.add(three);
		MyList.addAll(test);
		assertEquals(3,MyList.size());
		assertFalse(MyList.isEmpty());
		assertEquals(one,MyList.get(0));
		assertEquals(three,MyList.get(2));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		
		assertEquals(three,MyList.get(2));
		assertEquals(one,MyList.get(3));
		assertFalse(MyList.isEmpty());
		
		
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.remove(0);
		
		
		assertEquals(two, this.MyList.get(0));
		assertEquals(5, this.MyList.size());
		assertFalse(MyList.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		
		assertEquals(two, this.MyList.get(1));
		
		
		MyList.remove(two);
		
		
		assertEquals(three, this.MyList.get(1));
		assertFalse(MyList.isEmpty());
		assertEquals(two, this.MyList.get(3));
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		
		assertEquals(two, this.MyList.get(4));
		assertEquals(6, this.MyList.size());
		
		MyList.set(3,"set");
		
		assertEquals("set", this.MyList.get(3));
		assertEquals(two, this.MyList.get(4));
		assertEquals(6, this.MyList.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(0, MyList.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		
		boolean contains = this.MyList.contains(two);
		assertTrue(contains);
		
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(java.lang.Object[])}.
	 */
	@Test
	public void testToArrayObjectArray() {
		String[] toArray = new String[3];
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		toArray = MyList.toArray(toArray);

		String actualString = "";
		for(int i = 0; i < toArray.length; i++) {
			actualString += toArray[i];
		}

		String[] expectedArray = new String[3];
		expectedArray[0] = "Eunji";
		expectedArray[1] = "jounghan";
		expectedArray[2] = "Bushra";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}		
		
		assertEquals(true, expectedString.equals(actualString));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		MyList.add(one);
		MyList.add(two);
		MyList.add(three);
		Object[] toArray = MyList.toArray();
		
		String actualString = "";
		for(int i = 0; i < toArray.length; i++) {
			actualString += toArray[i];
		}
		
		String[] expectedArray = new String[3];
		expectedArray[0] = "Eunji";
		expectedArray[1] = "jounghan";
		expectedArray[2] = "Bushra";
		
		String expectedString = "";
		for(int i = 0; i < expectedArray.length; i++) {
			expectedString += expectedArray[i];
		}		
		assertEquals(true, expectedString.equals(actualString));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		String expected = "";
		String actual = "";
		
		Iterator<String> iterator = MyList.iterator();
		
		while(iterator.hasNext()) {
			actual += iterator.next();
		}
		
		assertEquals(true,expected.equals(actual));
	}

}