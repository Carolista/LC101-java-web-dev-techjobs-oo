package org.launchcode.techjobs_oo.tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class JobTest {

    Job job0, job1, job2, job3, job4, job5;
    Employer testEmployer;
    Location testLocation;
    PositionType testPositionType;
    CoreCompetency testCoreCompetency;

    @Before
    public void createTestJobs() {

        job0 = new Job("First job", new Employer("Bob's House of Pain"), new Location("Hades"), new PositionType("Peon"), new CoreCompetency("High tolerance for pain"));
        job1 = new Job();
        job2 = new Job();
        testEmployer = new Employer("ACME");
        testLocation = new Location("Desert");
        testPositionType = new PositionType("Quality control");
        testCoreCompetency = new CoreCompetency("Persistent");
        job3 = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        job4 = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        job5 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));

    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job3.getName());
        assertEquals(testEmployer, job3.getEmployer());
        assertEquals(testLocation, job3.getLocation());
        assertEquals(testPositionType, job3.getPositionType());
        assertEquals(testCoreCompetency, job3.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    // Use TDD to create toString method in Job class

    @Test
    public void toStringStartsAndEndsWithBlankLines() {
        String s = job3.toString();
        int l = s.length();
        assertTrue(s.substring(0,2).contains("\n"));
        assertTrue(s.substring(l-2,l).contains("\n"));
    }

    @Test
    public void toStringPutsAllFieldsOnNewLinesWithValues() {
        String s = job0.toString();
        int testID = job0.getId();
        String subID = "ID: " + testID + "\n";
        assertTrue(s.contains(subID));
        assertTrue(s.contains("Name: First job\n"));
        assertTrue(s.contains("Employer: Bob's House of Pain\n"));
        assertTrue(s.contains("Location: Hades\n"));
        assertTrue(s.contains("Position Type: Peon\n"));
        assertTrue(s.contains("Core Competency: High tolerance for pain\n"));
    }

    @Test
    public void toStringSubstituteTextWhenEmpty() {
        String s = job5.toString();
        assertTrue(s.contains("Data not Available"));
    }

    @Test
    public void toStringObjectHasIdOnly() {
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
    }

}
