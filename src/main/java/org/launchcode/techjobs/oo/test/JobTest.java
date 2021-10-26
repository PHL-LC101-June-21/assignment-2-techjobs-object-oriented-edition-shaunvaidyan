package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();

        assertNotEquals(testJob1, testJob2);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job job2 = new Job(
                "QA analyst",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "QA analyst",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertEquals('\n',
                job.toString().charAt(0));
        assertEquals('\n',
                job.toString().charAt(job.toString().length()-1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString(), "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: " + job.getCoreCompetency() + "\n");
    }
    @Test
    public void testToStringHandlesEmptyField() {
        // create a Job object with some fields empty
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("")
        );
        assertEquals(
                "\nID: " + job.getId() +
                        "\nName: Product tester" +
                        "\nEmployer: ACME" +
                        "\nLocation: Desert" +
                        "\nPosition Type: Data not available" +
                        "\nCore Competency: Data not available" + "\n",
                job.toString()
        );
    }
}