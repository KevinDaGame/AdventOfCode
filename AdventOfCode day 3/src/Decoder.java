import java.util.ArrayList;

public class Decoder {

    public void getHighAndLow(ArrayList<String> values) {

        int[] countOfOnes = getCountOfOnes(values);
        String gammaRate = "";
        String epsilonRate = "";
        for (int i = 0; i < countOfOnes.length; i++) {
            if (countOfOnes[i] > values.size() / 2) {
                gammaRate += "1";
                epsilonRate += "0";
            } else {
                gammaRate += "0";
                epsilonRate += "1";
            }
        }
        System.out.println("gamma rate: " + gammaRate);
        System.out.println("epsilon rate: " + epsilonRate);
        System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2));
    }


    public int getOxygenRating(ArrayList<String> values) {
        for (int i = 0; i < 12; i++) {
            if (values.size() == 1) {
                break;
            }
            int commonValue = getCommonValueAtIndex(values, i, 1);
            ArrayList<String> newValues = new ArrayList<>();
            for (String s : values) {
                if (Character.getNumericValue(s.charAt(i)) == commonValue) {
                    newValues.add(s);
                }

            }
            values = newValues;
        }
        System.out.println("oxygen rate: " + values.get(0));
        return Integer.parseInt(values.get(0), 2);
    }

    public void getLifeRating(ArrayList<String> values) {
        int oxygen = getOxygenRating(values);
        int scrubber = getScrubberRating(values);
        System.out.println(scrubber * oxygen);

    }

    public int getScrubberRating(ArrayList<String> values) {
        for (int i = 0; i < 12; i++) {

            int commonValue = getCommonValueAtIndex(values, i, 0);
            ArrayList<String> newValues = new ArrayList<>();
            for (String s : values) {
                if (Character.getNumericValue(s.charAt(i)) != commonValue) {
                    newValues.add(s);
                }
            }
            values = newValues;
            if (values.size() == 1) {
                break;
            }
        }
        System.out.println("scrubber rate: " + values.get(0));
        return Integer.parseInt(values.get(0), 2);
    }

    private int[] getCountOfOnes(ArrayList<String> values) {
        int[] countOfOnes;
        countOfOnes = new int[12];
        for (String line : values) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.getNumericValue(line.charAt(i)) == 1) {
                    countOfOnes[i] += 1;
                }
            }
        }
        return countOfOnes;
    }

    private int getCommonValueAtIndex(ArrayList<String> values, int line, int bias) {
        int oneCount = 0;
        for (int i = 0; i < values.size(); i++) {
            if (Character.getNumericValue(values.get(i).charAt(line)) == 1) {
                oneCount++;
            }
        }
        if (oneCount > values.size() / 2) {
            return 1;
        } else if (oneCount == values.size() / 2){
            return bias;
        }else {
            return 0;
        }
    }
}
