package bg.softuni.io.commands;

import bg.softuni.annotations.Alias;
import bg.softuni.annotations.Inject;
import bg.softuni.dataStructures.SimpleOrderedBag;
import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.models.Course;
import bg.softuni.models.Student;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

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
