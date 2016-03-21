import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solver {
    private final DateFormat dateFormat = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
    private HashMap<Integer,Integer> yearsMap = new HashMap<Integer, Integer>();

    public int findSolutionYear(String fileName) throws ParseException, FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        Livedates livedates;
        while ((livedates = getNextLivedates(input)) != null) {
            int birthYear = getYearFromDate(livedates.birthDate);
            int deathYear = getYearFromDate(livedates.deathDate);
            for (int year = birthYear; year <= deathYear; year++) {
                incrementYear(year);
            }
        }
        return getMaximumYear(yearsMap);
    }

    private Livedates getNextLivedates(Scanner input) throws ParseException {
        if (input.hasNextLine()) {
            String line = input.nextLine();

            Date birthDate = null;
            Date deathDate = null;
            int lastIndex = 0;
            int currIndex = 0;
            int count = 0;
            while (currIndex != -1) {
                currIndex = line.indexOf(",", lastIndex + 1);
                count++;
                if (count == 2) {
                    String birth = line.substring(lastIndex + 1, currIndex).trim();
                    if (!birth.equals("")) {
                        birthDate = dateFormat.parse(birth);
                    }
                } else if (count == 4) {
                    String death = line.substring(lastIndex + 1, currIndex).trim();
                    if (!death.equals("")){
                        deathDate = dateFormat.parse(death);
                    }
                }
                lastIndex = currIndex;
            }
            return new Livedates(birthDate, deathDate);
        }
        return null;
    }

    private int getYearFromDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    private void incrementYear(int yearNumber) {
        if (yearsMap.containsKey(yearNumber)){
            yearsMap.put(yearNumber, yearsMap.get(yearNumber) + 1);
        }
        else{
            yearsMap.put(yearNumber, 1);
        }
    }

    private Integer getMaximumYear(HashMap<Integer, Integer> map) {
        Integer maxYear = 0;
        Integer maxVal = 0;
        for (Map.Entry<Integer, Integer> year : map.entrySet()) {
            if (year.getValue() > maxVal){
                maxVal = year.getValue();
                maxYear = year.getKey();
            }
        }
        return maxYear;
    }


}
