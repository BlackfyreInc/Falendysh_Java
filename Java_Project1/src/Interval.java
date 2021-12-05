import exceptions.IntervalBoundException;
import exceptions.IntervalElementException;

/** Helper class for Histogram.
 * Defines Intervals of the Histogram.
 */
public class Interval{
    private final double floor; // lower boundary of interval
    private final double ceil; // upper boundary
    private int count; // Number of values in interval
    private boolean isFirst; // closed or open interval
    private int onLeft; // if isFirst number of values on left boundary

    Interval(double floor, double ceil) {
        if (floor>=ceil){
            throw new IntervalBoundException("Invalid interval boundary. Upper boundary should be bigger than lower boundary.");
        }
        this.floor = floor;
        this.ceil = ceil;
        this.count = 0;
        this.isFirst = false;
    }

    /** Getter for onLeft.
     *
     * @return number of values on left boundary.
     */

    public int getOnLeft() {
        return onLeft;
    }

    /** Change interval type from closed to open.
     *
     */
    void makeFirst(){
        this.isFirst = true;
    }

    /** Change interval type from open to closed.
     *
     */
    void undoFirst() {
        this.isFirst = false;
        this.count -= this.onLeft;
        this.onLeft = 0;
    }

    /** Getter for size of the interval.
     *
     * @return size.
     */
    double getSize() {
        return this.ceil-this.floor;
    }

    /** Check interval type.
     *
     * @return true if interval is open; false if interval is closed.
     */
    boolean isFirst(){
        return this.isFirst;
    }

    /** Getter for floor.
     *
     * @return lower boundary of interval.
     */
    public double getFloor() {
        return floor;
    }

    /** Getter for ceil.
     *
     * @return Upper boundary of interval.
     */
    public double getCeil() {
        return ceil;
    }

    /** Check if interval contains a value.
     *
     * @param value double value to check.
     * @return true if contains.
     */
    boolean contains(double value) {

        return isFirst() ? this.floor<=value && value<=this.ceil : this.floor<value && value<=this.ceil;
    }

    /** Add element to interval
     *
     * @param value double value
     */
    void addElement(double value) {
        if (!contains(value)){
            throw new IntervalElementException("Value doen not belong to this interval.");
        }
        this.count++;
        if (value == this.floor){
            this.onLeft++;
        }
    }

    /** Add some elements to interval.
     *
     * @param value amount of added elements.
     */
    void addElements(int value){
        this.count += value;
    }

    /** Getter for count.
     *
     * @return Number of values in interval
     */
    public int getCount() {
        return count;
    }

    /** Setter for count.
     *
     * @param count Number of values in interval.
     */
    void setCount(int count) {
        this.count = count;
    }

    /** Check if interval contains other interval.
     *
     * @param other other interval.
     * @return true if this contains other's ceil.
     */
    public boolean contains(Interval other){
        return contains(other.ceil);
    }

    /** Return median of an interval.
     *
     * @return median.
     */
    public double getMedian(){
        return (getCeil()+getFloor())/2;
    }

    @Override
    public String toString() {
        return (isFirst() ?"[" : "(") + floor + "; " + ceil + "]: " + count;
    }

    public String print() {
        return (isFirst() ?"[" : "(") + floor + "; " + ceil + "]: ";
    }
}