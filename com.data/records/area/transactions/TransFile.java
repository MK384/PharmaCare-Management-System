package records.area.transactions;


import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public record TransFile(String client , LocalDate dateOfOrdering, File orderFile) {
}
