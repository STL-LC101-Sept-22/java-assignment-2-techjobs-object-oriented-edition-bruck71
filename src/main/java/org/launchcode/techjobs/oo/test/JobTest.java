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
    //TODO: Test the custom equals method
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

    //TODO: Test custom toString method by checking that the string starts and ends with a blank line.
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String spec = "Custom toString method should start and end with new line character";
        Job job = new Job(
                "Product Tester",
                new Employer("Acme"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        char expectedBeginningChar = '\n';
        char expectedEndChar = '\n';
        char actualFirstChar = job.toString().charAt(0);
        char actualLastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(expectedBeginningChar, actualFirstChar);
        assertEquals(expectedEndChar, actualLastChar);
    }

    //TODO: Test custom toString method by checking the proper labels and values.
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String spec = "Custom toString method should properly display labels and values";
        //"Web Developer", "LaunchCode", "StL", "Back-end developer", "Java"
        Job job = new Job("Product Tester", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String expected = "\nID: " + job.getId() +
                "\nName: Product Tester" +
                "\nEmployer: LaunchCode" +
                "\nLocation: StL" +
                "\nPosition Type: Back-end developer" +
                "\nCore Competency: Java\n";
        String actual = job.toString();
        assertEquals(expected, actual);
    }

    //TODO: Test custom toString method by checking empty fields response of "Data not available" after the label
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String expected = "\nID: " + job.getId() +
                "\nName: Web Developer" +
                "\nEmployer: Data not available" +
                "\nLocation: StL" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Java\n";
        String actual = job.toString();
        assertEquals(expected, actual);
    }
}
