import Exceptions.NoValidCommand;

public class CommandEvaluator {

    private String newCommand = "C";
    private String lineCommand = "L";
    private String rectangleCommand = "R";
    private String fillCommand = "B";
    private String quitCommand = "Q";
    private Boolean canvasExist = false;
    private Integer maxX;
    private Integer maxY;
    private Integer[] command;

    public Integer[] getCommand() {
        return command;
    }

    public void setCanvasExist(Boolean canvasExist) {
        this.canvasExist = canvasExist;
    }

    public Integer readCommand(String command) throws NoValidCommand {
        String[] splittedCommand = command.split(" ");
        int commandType = this.validateCommandType(splittedCommand[0]);

        if (commandType == 0) {
            throw new NoValidCommand();
        } else if (commandType == 1) {
            newCanvas(splittedCommand);
            return 1;
        } else if (commandType == 2 && this.canvasExist) {
            line(splittedCommand);
            return 2;
        } else if (commandType == 3 && this.canvasExist) {
            return 3;
        } else if (commandType == 4 && this.canvasExist) {
            return 4;
        } else if (commandType == 5 && this.canvasExist) {
            return 5;
        } else {
            throw new NoValidCommand();
        }
    }

    private Integer validateCommandType(String command) {
        if (command.equals(this.newCommand)) {
            return 1;
        } else if (command.equals(this.lineCommand)) {
            return 2;
        } else if (command.equals(this.rectangleCommand)) {
            return 3;
        } else if (command.equals(this.fillCommand)) {
            return 4;
        } else if (command.equals(this.quitCommand)) {
            return 5;
        } else {
            return 0;
        }
    }

    private void newCanvas(String[] command) throws NoValidCommand {
        if (command.length != 3) {
            throw new NoValidCommand();
        }
        if (!this.isInteger(command[1]) || !this.isInteger(command[2])) {
            throw new NoValidCommand();
        }
        this.command = new Integer[]{Integer.parseInt(command[1]), Integer.parseInt(command[2])};
    }

    private void line(String[] command) throws NoValidCommand {
        if (command.length != 5) {
            throw new NoValidCommand();
        }
        if (!this.isInteger(command[1]) || !this.isInteger(command[2]) || !this.isInteger(command[3]) || !this.isInteger(command[4])) {
            throw new NoValidCommand();
        }
        if (!this.isInRangeX(Integer.parseInt(command[1])) || !this.isInRangeX(Integer.parseInt(command[3]))) {
            throw new NoValidCommand();
        }
        if (!this.isInRangeY(Integer.parseInt(command[2])) || !this.isInRangeY(Integer.parseInt(command[4]))) {
            throw new NoValidCommand();
        }
        this.command = new Integer[]{Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]), Integer.parseInt(command[4])};
    }

    private Boolean isInteger(String command) {
        if (command == null) {
            return false;
        }
        try {
            Integer i = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private Boolean isInRangeX(Integer integer) {
        return integer < this.maxX && integer > 1;
    }

    private Boolean isInRangeY(Integer integer) {
        return integer < this.maxY && integer > 1;
    }


}
