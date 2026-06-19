class Solution {
    public double angleClock(int hour, int minutes) {

        double minHand = 6.0 * minutes;
        double hourHand = 30.0 * (hour % 12) + 0.5 * minutes;

        double diff = Math.abs(hourHand - minHand);

        return Math.min(diff, 360 - diff);
    }
}
