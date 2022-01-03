package records.area.transactions;


import java.io.File;
import java.util.Date;

public record TransFile(String client , Date dateOfOrdering, File orderFile) {
}
