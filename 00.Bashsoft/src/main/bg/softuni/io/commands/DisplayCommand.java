package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.dataStructures.SimpleOrderedBag;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.models.Course;
import main.bg.softuni.models.Student;
import main.bg.softuni.repository.StudentsRepository;

import java.util.Comparator;

/**
 * Created by vladix on 4/17/17.
 */

@Alias(value = "display")
public class DisplayCommand extends Command {

    @Inject
    private StudentsRepository repository;

    public DisplayCommand(
            String input,
            String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = super.getData();
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String entityToDisplay = data[1];
        String sortType = data[2];
        if (entityToDisplay.equals("students")) {
            Comparator<Student> cmp = this.createStudentsComparator(sortType);
            SimpleOrderedBag<Student> sortedStudents = this.repository.getAllStudentsSorted(cmp);
            OutputWriter.writeMessageOnNewLine(sortedStudents.joinWith(System.lineSeparator()));
        } else if (entityToDisplay.equals("courses")) {
            Comparator<Course> cmp = this.createCoursesComparator(sortType);
            SimpleOrderedBag<Course> sortedStudents = this.repository.getAllCoursedSorted(cmp);
            OutputWriter.writeMessageOnNewLine(sortedStudents.joinWith(System.lineSeparator()));
        }
    }

    private Comparator<Course> createCoursesComparator(String sortType) {
        if (sortType.equals("ascending")) {
            return Course::compareTo;
        } else if (sortType.equals("descending")) {
            return Comparator.reverseOrder();
        } else {
            throw new InvalidInputException(super.getInput());
        }
    }

    private Comparator<Student> createStudentsComparator(String sortType) {
        if (sortType.equals("ascending")) {
            return Student::compareTo;
        } else if (sortType.equals("descending")) {
            return Comparator.reverseOrder();
        } else {
            throw new InvalidInputException(super.getInput());
        }
    }
}
