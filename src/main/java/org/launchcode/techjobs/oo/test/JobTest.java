package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //TODO: Test the Job Class constructor for unique ID's on two Job objects
    @Test
    public void testSettingJobId() {
        String spec = "Two empty Job objects have distinct ID's";
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(spec, testJob1, testJob2);
    }

    //TODO: Test the full Job Constructor
    //instantiate a testJob Job object to be tested
//    @Before
//    public void createJobObject() {
//        Job testJob = new Job(
//                "Product Tester",
//                new Employer("Acme"),
//                new Location("Desert"),
//                new PositionType("Quality control"),
//                new CoreCompetency("Persistence")
//        );
//    }
    //TODO: Test each parameter
    @Test
    public void testJobConstructorSetsAllFields() {
        String spec = "a job Object is properly instantiated with each parameter (Employer, Location, Position Type, Core Competency).";
        //Create testJob object from the Job class
        Job testJob = new Job(
                "Product Tester",
                new Employer("Acme"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        //Expected values
        String expectedName = "Product Tester";
        String expectedEmployer = "Acme";
        String expectedLocation = "Desert";
        String expectedPositionType = "Quality control";
        String expectedCoreCompetency = "Persistence";

        //Actual Values
        String actualName = testJob.getName();
        String actualEmployer = testJob.getEmployer().getValue();
        String actualLocation = testJob.getLocation().getValue();
        String actualPositionType = testJob.getPositionType().getValue();
        String actualCoreCompetency = testJob.getCoreCompetency().getValue();

        //Assertions actual vs expected for all fields
        assertEquals(expectedName, actualName);
        assertEquals(expectedEmployer, actualEmployer);
        assertEquals(expectedLocation, actualLocation);
        assertEquals(expectedPositionType, actualPositionType);
        assertEquals(expectedCoreCompetency, actualCoreCompetency);

        //Assertion to be true for all Classes of corresponding objects
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        String spec = "custom equals method compares Jobs on id number only";
        Job testJob1 = new Job(
                "Product Tester",
                new Employer("Acme"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job testJob2 = new Job(
                "Product Tester",
                new Employer("Acme"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        boolean condition = testJob1.equals(testJob2);
        assertFalse(condition);

    }

}
