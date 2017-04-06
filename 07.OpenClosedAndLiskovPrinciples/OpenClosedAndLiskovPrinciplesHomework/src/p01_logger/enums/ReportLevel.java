package p01_logger.enums;

public enum ReportLevel {
    INFO, WARNING, ERROR, CRITICAL, FATAL;

    @Override
    public String toString() {
        return super.name();
    }
}
