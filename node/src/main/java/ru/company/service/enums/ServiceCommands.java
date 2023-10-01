package ru.company.service.enums;

public enum ServiceCommands {
    START("/start"),
    REGISTRATION("/registration"),
    HELP("/help"),
    CANCEL("/cancel");
    private final String cmd;

    ServiceCommands(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString(){
        return cmd;
    }

    public boolean equals(String cmd){
        return this.toString().equals(cmd);
    }
}
