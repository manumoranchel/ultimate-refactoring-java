package signatureChange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvBuilder {
    private String buildLine(String... fields){
        return Arrays.asList(fields).stream().collect(Collectors.joining(","));
    }

    private String header(){
        return "Field1, Field2";
    }

    public List<String> aFileWithLine(String... line){
        return Arrays.asList(header(), buildLine(line));
    }
}
