import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.time.Instant;

public class Main {

    public static class Day {
       public String[] solve(List<String> input) { 
           return new String[]{"Not implemented", "Not implemented"}; 
       }
   }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java Main <day> <input_type>");
            return;
        }

        int day = Integer.parseInt(args[0]);
        String inputFile = args[1].equals("test") 
            ? String.format("test_inputs/%02d.in", day)
            : String.format("inputs/%02d.in", day);
            
        List<String> input = Files.readAllLines(Path.of(inputFile));
        
        var solution = (Day) Class.forName("Day" + String.format("%02d", day))
                                .getDeclaredConstructor()
                                .newInstance();
        
        long start = Instant.now().toEpochMilli();
        String[] results = solution.solve(input);
        long time = Instant.now().toEpochMilli() - start;
       
        System.out.printf("Part 1: %s%nPart 2: %s%nTime: %dms%n", results[0], results[1], time);
    }
}
