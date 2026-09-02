package pckg_batch_processing;

public record LineRecord(String lineName, String line) {

    @Override
    public String toString() {
        return "LineRecord{" +
                "lineName='" + lineName + '\'' +
                ", line='" + line + '\'' +
                '}';
    }
}
