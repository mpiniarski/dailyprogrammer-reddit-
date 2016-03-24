/**
 * Created by marcin on 24.03.16.
 */
public class IpDistanceSolver {
    final char[][] keypad = new char[][] {{'1','2','3'},
                                    {'4','5','6'},
                                    {'7','8','9'},
                                    {'.','0'    }};

    public double calculateDistance(String ipAddress) throws IncorrectIpAdressException {

        if (! isValid(ipAddress)) throw new IncorrectIpAdressException();

        double distance = 0;
        for (int i = 0; i < ipAddress.length() - 1; i++) {
            Integer[] firstPosition = positionOf(ipAddress.charAt(i));
            Integer[] secondPosition = positionOf(ipAddress.charAt(i+1));
            distance += distanceBetween(firstPosition, secondPosition);
        }
        return roundTo(distance,2);
    }

    private boolean isValid(String ipAddress) {
        String[] ipAddressParts = ipAddress.split("\\.");
        for (String part : ipAddressParts) {
            if (part.length() > 3) return false;
            else{
                for (int i = 0; i < part.length(); i++) {
                    if ("123456789".indexOf(part.charAt(i)) == -1) return false;
                }
            }
        }
        return true;
    }

    private Integer[] positionOf(char sign) {
        for (int w = 0; w < keypad.length; w++) {
            for (int k = 0; k < keypad[w].length; k++) {
                if (keypad[w][k] == sign) return new Integer[]{w,k};
            }
        }
        return null;
    }

    private double distanceBetween(Integer[] first, Integer[] second) {
        return Math.sqrt( Math.pow(second[0]-first[0],2) + Math.pow(second[1]-first[1],2));
    }

    private double roundTo(double distance, int places) {
        double temp = Math.pow(10,places);
        return Math.round(distance*temp)/temp;
    }

}
