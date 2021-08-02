import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}

	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void testAddChromebook() {
		// fail("Not yet implemented");
		// write your code here
		// 1,2,3
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cc1, chromebookList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}

	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// test if the list of camcorder retrieved from the SourceCentre is empty
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}
//cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
	//cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
	@Test
	public void testRetrieveAllChromebook() {
	    //fail("Not yet implemented");
	    // write your code here
	    assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
	    
	    String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
	    String testOutput = "";
	    assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	    
	    ResourceCentre.addChromebook(chromebookList, cb1);
	    ResourceCentre.addChromebook(chromebookList, cb2);
	    assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
	    
	    allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

	    testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
	    testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
	  
	    assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

	  }
	@Test
	public void testDoLoanCamcorder() {
		// fail("Not yet implemented");
		// write your code here

	}

	@Test
	public void testDoLoanChromebook() {
		// fail("Not yet implemented");
		// write your code here

	}

	@Test
	public void testDoReturnCamcorder() {
	
		// write your code here

		// Test that a given list is not null, a newly added item cannot be returned
		// successfully
		assertNotNull(camcorderList);
		assertFalse(ResourceCentre.doReturnCamcorder(camcorderList, cc2.getAssetTag()));

		// Test that camcorder which is loaned already is not available and has a due
		// date before able to return
		ResourceCentre.addCamcorder(camcorderList, cc2);
		ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "24/8/2021");
		String Camcorder2 = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CC0012", "Sony DSC-RX100M7", "No",
				"24/8/2021", 20);
		assertEquals("Test if cc2 is loaned", Camcorder2, testOutput);

		// Test that after camcorder returned, Avalaible becomes "Yes" and has no due
		// date.
		ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		String Camcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput2 = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CC0012", "Sony DSC-RX100M7", "Yes", "",20);
		assertEquals("Test if cc2 is now available", Camcorder, testOutput2);

		// Test that isAvailable is false
		assertEquals("Test if cc2 isAvailable is now true", camcorderList.get(0).getIsAvailable(),
				cc2.getIsAvailable());

	}
	//cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
	@Test
	public void testDoReturnChromebook() {
		
		// write your code here
		// Test that a given list is not null, a newly added item cannot be returned
		// successfully
		assertNotNull(chromebookList);
		assertFalse(ResourceCentre.doReturnChromebook(chromebookList, cb2.getAssetTag()));

		// Test that Chromebook which is loaned already is not available and has a due
		// date before able to return
		ResourceCentre.addChromebook(chromebookList, cb2);
        ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "24/8/2021");
        String Chromebook2= ResourceCentre.retrieveAllChromebook(chromebookList);
        String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "Macbook Pro","No","24/8/2021","Mac OS");
        assertEquals("Test if cb2 is loaned",Chromebook2,testOutput);
       
        //Test that after chromebook returned, Avalaible becomes "Yes" and has no due date.
        ResourceCentre.doReturnChromebook(chromebookList,"CB0012");
        String Chromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
        String testOutput2 = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "Macbook Pro", "Yes", "", "Mac OS");
        assertEquals("Test if cb2 is now available", Chromebook, testOutput2);
       
        //Test that isAvailable is false
        assertEquals("Test if cb2 isAvailable is now true",chromebookList.get(0).getIsAvailable(),cb2.getIsAvailable());
    

	      }

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
