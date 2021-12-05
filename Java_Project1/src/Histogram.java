import exceptions.HistBoundariesException;
import exceptions.BinsValueException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Histogram {

    /** Append method for new value.
     * ADD_TO_EDGE is used to add value to the edge of histogram if value is not in histogram.
     * EXPAND is used to adds bins to the histogram in order to add value.
     * INTERVAL_ONLY is used to add values only from interval.
     */
    public enum AppendMethod {
        ADD_TO_EDGE,
        EXPAND,
        INTERVAL_ONLY
    }

    private double min_hist;
    private double max_hist;
    private int bins;
    private ArrayList<Interval> intervals;

    /** Constructor for Histogram.
     *
     * @param min_hist lower histogram boundary.
     * @param max_hist upper histogram boundary.
     * @param bins number of bins in histogram.
     */
    public Histogram(double min_hist, double max_hist, int bins) {
        this.min_hist = min_hist;
        this.max_hist = max_hist;
        this.bins = bins;
        if (bins<=0){
            throw new BinsValueException("Can not initialize Histogram if it has negative/zero amount of bins.");
        }
        generateIntervals();
    }

    /** Generate bins intervals from min_hist to max_hist.
     *
     */
    private void generateIntervals(){
        this.intervals = new ArrayList<>();
        for (int i=0; i<this.bins; i++) {
            this.intervals.add(new Interval(this.min_hist + (this.max_hist - this.min_hist) / this.bins * i, this.min_hist + (this.max_hist - this.min_hist) / this.bins * (i+1)));
        }
        this.intervals.get(0).makeFirst();
    }

    /** Add intervals until it contains value.
     *
     * @param addValue adding value.
     * @param toLeft add interval to left or to right.
     */
    private void addIntervals(double addValue, boolean toLeft){
        double step = this.intervals.get(0).getSize();
        Interval newI;
        if (toLeft){
            newI = new Interval(this.intervals.get(0).getFloor() - step, this.intervals.get(0).getFloor());
            newI.makeFirst();
            newI.setCount(this.intervals.get(0).getOnLeft());
            this.intervals.get(0).undoFirst();
            this.intervals.add(0, newI);
            this.bins++;
            while (!newI.contains(addValue)) {
                newI = new Interval(this.intervals.get(0).getFloor() - step, this.intervals.get(0).getFloor());
                newI.makeFirst();
                newI.setCount(this.intervals.get(0).getOnLeft());
                this.intervals.get(0).undoFirst();
                this.intervals.add(0, newI);
                this.bins++;
            }
            this.min_hist = this.intervals.get(0).getFloor();
        } else {
            newI = new Interval(this.intervals.get(this.bins-1).getCeil(),
                    this.intervals.get(this.bins-1).getCeil() + step);
            this.intervals.add(newI);
            this.bins++;
            while (!newI.contains(addValue)) {
                newI = new Interval(this.intervals.get(this.bins - 1).getCeil(),
                        this.intervals.get(this.bins - 1).getCeil() + step);
                this.intervals.add(newI);
                this.bins++;
            }
            this.max_hist = this.intervals.get(this.bins-1).getCeil();
        }
    }

    /** Update number of bins and saves Histogram structure.
     *
     */
    private void updateIntervals(){
        Queue<Interval> oldIntervals = new LinkedList<>(this.intervals);
        generateIntervals();
        Queue <Interval> newIntervals = new LinkedList<>(this.intervals);

        Interval biggerInt;
        Interval smallerInt;
        if (oldIntervals.size()>newIntervals.size()){
            while (!newIntervals.isEmpty()) {
                biggerInt = newIntervals.remove();
                while (!oldIntervals.isEmpty()) {
                    smallerInt = oldIntervals.peek();
                    if (biggerInt.contains(smallerInt)){
                        oldIntervals.remove();
                        biggerInt.addElements(smallerInt.getCount());
                    } else {
                        break;
                    }
                }
            }
        } else {
            throw new BinsValueException("Can not reduce interval size after values have been added.");
        }
    }

    /** Add single number to Histogram.
     *
     * @param newValue value.
     * @param appendMethod is method of adding element.
     */
    public void addNumber(double newValue, AppendMethod appendMethod){

        if (appendMethod == AppendMethod.ADD_TO_EDGE) {
            if (newValue < getMin_hist()) {
                this.intervals.get(0).addElement(this.intervals.get(0).getFloor());
            } else if (newValue > getMax_hist()) {
                this.intervals.get(this.bins - 1).addElement(this.intervals.get(this.bins - 1).getCeil());
            }
        } else if (appendMethod == AppendMethod.EXPAND) {
            if (newValue < getMin_hist()) {
                addIntervals(newValue, true);
            } else if (newValue > getMax_hist()) {
                addIntervals(newValue, false);
            }
        }
        if (newValue<=this.max_hist || newValue >= this.min_hist){
            for (int i=0; i<getBins(); i++){
                if (this.intervals.get(i).contains(newValue)) {
                    this.intervals.get(i).addElement(newValue);
                    break;
                }
            }
        }
    }

    /** Add array of values to histogram.
     *
     * @param data array.
     * @param appendMethod is method of adding element.
     */
    public void addArray(double[] data, AppendMethod appendMethod){
        for (double num: data){
            addNumber(num, appendMethod);
        }
    }

    /** Add array of values to histogram.
     *
     * @param data array.
     * @param appendMethod is method of adding element.
     */
    public void addArray(float[] data, AppendMethod appendMethod){
        for (float num: data){
            addNumber(num, appendMethod);
        }
    }

    /** Add array of values to histogram.
     *
     * @param data array.
     * @param appendMethod is method of adding element.
     */
    public void addArray(int[] data, AppendMethod appendMethod){
        for (int num: data){
            addNumber(num, appendMethod);
        }
    }

    /** Add values from file to histogram.
     *
     * @param fileName path to file
     * @param appendMethod is method of adding element.
     */
    public void addArray(String fileName, AppendMethod appendMethod){
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            double val;
            while(scanner.hasNextDouble()) {
                val = scanner.nextDouble();
                addNumber(val, appendMethod);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Getter for min_hist.
     *
     * @return Lower boundary of histogram.
     */
    public double getMin_hist() {
        return min_hist;
    }

    /** Setter for min_hist.
     *
     * @param min_hist Lower boundary of histogram.
     */
    public void setMin_hist(double min_hist) {
        if (count()>0) {
            throw  new HistBoundariesException("Can't change histogram size after values have been added.");
        }
        this.min_hist = min_hist;
    }

    /** Getter for max_hist.
     *
     * @return Upper boundary of histogram.
     */
    public double getMax_hist() {
        return max_hist;
    }

    /** Setter for max_hist.
     *
     * @param max_hist Upper boundary of histogram.
     */
    public void setMax_hist(double max_hist) {
        if (count()>0){
            throw new HistBoundariesException("Can't change histogram size after values have been added.");
        }
        this.max_hist = max_hist;
    }

    /** Getter for bins.
     *
     * @return number of bins.
     */
    public int getBins() {
        return bins;
    }

    /** Setter for bins.
     *
     * @param bins new number of bins.
     */
    public void setBins(int bins) {
        if (bins <= 0) {
            throw new BinsValueException("Can't initialize Histogram when number of bins is negative or equals zero.");
        } else if (count()!=0 && this.bins<bins) {
            throw new BinsValueException("Can't extend interval size after values have been added.");
        } else if (count() == 0){
            this.bins = bins;
            generateIntervals();
        } else {
            this.bins = bins;
            updateIntervals();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Histogram:\n");
        for (Interval interval: this.intervals){
            stringBuilder.append('\t');
            stringBuilder.append(interval);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    /** Count all elements in histogram.
     *
     * @return number of elements in histogram.
     */
    public int count(){
        return  this.intervals.stream().mapToInt(Interval::getCount).sum();
    }

    /** Count number of elements from interval.
     *
     * @param index index of the interval.
     * @return number of elements.
     */
    public int count(int index){
        if (index>=0 && index < this.bins) {
            return this.intervals.get(index).getCount();
        } else {
            throw new IndexOutOfBoundsException("Interval index is out of bounds.");
        }
    }

    /** Return Mean of the histogram.
     *
     * @return mean.
     */
    public double mean(){
        return rawMoment(1);
    }

    /** Return variational series.
     *
     * @return variational series.
     */
    public ArrayList<Double> variationalSeries(){
        ArrayList<Double> vSeries = new ArrayList<>();
        for (Interval interval: this.intervals){
            for (int c=0; c<interval.getCount(); c++) {
                vSeries.add(interval.getMedian());
            }
        }
        return vSeries;
    }

    /** Return median.
     *
     * @return Median.
     */
    public double median(){
        ArrayList<Double> vSeries= variationalSeries();
        return vSeries.size()%2==0 ?
                (vSeries.get(vSeries.size()/2)+vSeries.get((vSeries.size()+1)/2))/2:
                vSeries.get((vSeries.size()+1)/2);
    }

    /** Return standard deviation.
     *
     * @return Standard Deviation.
     */
    public double std() {
        return Math.sqrt(rawMoment(2));
    }

    /** Return variance.
     *
     * @return variance.
     */
    public double variance(){
        return std()/mean();
    }

    /** Return skewness (measure of the asymmetry).
     *
     * @return skewness.
     */
    public double skewness(){
        return centralMoment(3)/Math.pow(std(),3);
    }

    /** Return excess of the histogram.
     *
     * @return excess.
     */
    public double excess(){
        return kurtosis()-3;
    }

    /** Return kurtosis (measure of the "tailedness")
     *
     * @return kurtosis = excess + 3.
     */
    public double kurtosis(){
        return centralMoment(4)/Math.pow(std(), 4);
    }

    /** Raw moment of n-th degree.
     *
     * @param n degree of moment.
     * @return Raw moment.
     */
    public double rawMoment(int n){
        if (n <= 0) throw new AssertionError();
        double sum = 0;
        for (Double val : variationalSeries()){
            sum += Math.pow(val, n);
        }
        return 1/(double)count()*sum;
    }


    /** Central moment of n-th degree.
     *
     * @param n degree of moment.
     * @return central moment.
     */
    public double centralMoment(int n) {
        if (n <= 0) throw new AssertionError();
        double sum = 0;
        double meanV = mean();
        for (Double val : variationalSeries()) {
            sum += Math.pow((val - meanV), n);
        }
        return 1 / (double) count() * sum;
    }

    /** Range of histogram.
     *
     * @return range.
     */
    public double range(){
        double l = this.intervals.get(0).getFloor();
        double u = this.intervals.get(getBins()-1).getCeil();
        int i=0;
        while (i<getBins()) {
            if (this.count(i)!=0){
                l = this.intervals.get(i).getFloor();
                break;
            }
            if (this.count(getBins()-1-i)!=0){
                u = this.intervals.get(getBins()-1-i).getCeil();
                break;
            }
            i++;
        }
        return u-l;

    }

    /** Median absolute deviation.
     *
     * @return median absolute deviation.
     */
    public double mad(){
        //
        double sum = 0;
        double med = median();
        for (Double val : variationalSeries()) {
            sum += Math.abs(val - med);
        }
        return 1 / (double) count() * sum;

    }

    /** Statistical describe of histogram.
     *
     * @return string.
     */
    public String describe() {
        return "Histogram:\n\tCount = %d\n\tRange = %s\n\tMean = %s\n\tMedian = %s\n\tSTD = %s\n\tVariance coefficient = %s\n\tSkewness = %s\n\tExcess = %s\n\tKurtosis = %s\n\tMedian absolute deviation = %s".formatted(count(), range(), mean(), median(), std(), variance(), skewness(), excess(), kurtosis(), mad());
    }
}