package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.io.IOManager;
import main.bg.softuni.judge.Tester;
import main.bg.softuni.network.DownloadManager;
import main.bg.softuni.repository.StudentsRepository;
import main.bg.softuni.staticData.SessionData;

import java.awt.*;
import java.io.File;

@Alias(value = "open")
public class OpenFileCommand extends Command {

    public OpenFileCommand(String input,
                           String[] data,
                           Tester tester,
                           StudentsRepository repository,
                           DownloadManager downloadManager,
                           IOManager ioManager) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "/" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }
}
