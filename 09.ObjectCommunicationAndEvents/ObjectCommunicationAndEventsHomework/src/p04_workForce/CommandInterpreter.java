package p04_workForce;

import jdk.nashorn.internal.scripts.JO;
import p04_workForce.models.employees.Employee;
import p04_workForce.models.employees.PartTimeEmployee;
import p04_workForce.models.employees.StandartEmployee;
import p04_workForce.models.jobs.Job;
import p04_workForce.models.jobs.JobImpl;

import java.util.*;

/**
 * Created by vladix on 4/19/17.
 */
public class CommandInterpreter {

    private Map<String, Employee> employeeByName;
    private List<Job> jobs;

    public CommandInterpreter() {
        this.employeeByName = new HashMap<>();
        this.jobs = new ArrayList<>();
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        while (!line.equals("End")) {
            String[] commandArgs = line.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Job": {
                    String jobName = commandArgs[1];
                    int hoursOfWorkRequired = Integer.parseInt(commandArgs[2]);
                    String employeeName = commandArgs[3];

                    Employee employee = this.employeeByName.get(employeeName);

                    Job job = new JobImpl(jobName, hoursOfWorkRequired, employee);
                    this.jobs.add(job);
                    break;
                }
                case "StandartEmployee": {
                    String employeeName = commandArgs[1];
                    Employee employee = new StandartEmployee(employeeName);

                    this.employeeByName.put(employeeName, employee);
                    break;
                }
                case "PartTimeEmployee": {
                    String employeeName = commandArgs[1];
                    Employee employee = new PartTimeEmployee(employeeName);


                    this.employeeByName.put(employeeName, employee);
                    break;
                }
                case "Pass": {
                    List<Job> unfinishedJobs = new ArrayList<>();

                    for (Job job : this.jobs) {
                        job.update();

                        if (job.getHoursOfWorkRequired() <= 0) {
                            System.out.println(String.format("Job %s done!", job.getNameOfJob()));
                        } else {
                            unfinishedJobs.add(job);
                        }
                    }

                    this.jobs = unfinishedJobs;
                    break;
                }
                case "Status":
                    for (Job job : this.jobs) {
                        if (job.getHoursOfWorkRequired() <= 0) {
                        } else {
                            System.out.println(String.format("Job: %s Hours Remaining: %d", job.getNameOfJob(), job.getHoursOfWorkRequired()));
                        }
                    }

                    break;
            }

            line = in.nextLine();
        }
    }

}
