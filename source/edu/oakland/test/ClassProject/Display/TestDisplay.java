package edu.oakland.test.ClassProject.Display;

import edu.oakland.production.ClassProject.Display.*;
import junit.framework.*;
/**
 * @version Hello
 * @author Mel and Ben
 */
public class TestDisplay extends TestCase{

	public void testStack(){
	       Display display = new Display("44 1 1 1 1 1 5");
	       
		  assertEquals("gID: 348689, name:10. Grant, major:CS, GPA:3.88, TG:99gID: 677422, name:1. Jones", display.runMainMenu()); //this is meant to fail
	}

	
}