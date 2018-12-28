package com.codewars.level6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Your friend Phil came up with a great new Bitcoin investment strategy, but before he can start making millions, he needs to know the minimum, average and maximum exchange rate for certain periods in the last few months.
 * <p>
 * He'll pay you 0.5 Bitcoin for a function that takes several arrays (one for each period) and calculates the minimum, average and maximum for each array, as well as the total minimum, average and maximum. Some numbers at the start and end of each period don't agree with Phil's theory, so he wants you to discard them.
 * <p>
 * For example, for the input
 * <p>
 * discard = 2
 * array 0 = 800,1200,2100,4100,1300,700 // discard 800,1200 at start and 1300,700 at end
 * array 1 = 1000,1500,4500,5000,5800,2000,1500 // discard 1000,1500 at start and 2000,1500 at end
 * your function should return
 * <p>
 * array 0 = 2100,3100,4100 // min, avg, max for input array 0 (without discarded values)
 * array 1 = 4500,5100,5800 // min, avg, max for input array 1 (without discarded values)
 * array 2 = 2100,4300,5800 // total min, avg, max (without discarded values)
 * Good luck!
 *
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 12/28/2018
 */
public class BitcoinStatistics {

  public static double[][] getMinAvgMax(int discard, double[][] data) {
	double[][] rez = new double[3][3];

	for (int i = 0; i < data.length; i++ ) {
	  fillResult(rez, i, getConvertToList(data[i], discard));
	}

	List<Double> tmp = new ArrayList<>();

	tmp.addAll(getConvertToList(rez[0], 0));
	tmp.addAll(getConvertToList(rez[1], 0));
	fillResult(rez, 2, tmp);
	return rez;
  }

  /**
   *
   * @param datum - started arr
   * @param discard - count of cut elements
   * @return converted list
   */
  private static List<Double> getConvertToList(double[] datum, int discard) {
	double[] doubles = Arrays.copyOfRange(datum, discard, datum.length - discard);
	return DoubleStream.of(doubles).boxed().collect(Collectors.toList());
  }

  /**
   * Fill result collection
   *
   * @param rez     - result
   * @param i       - index of arr
   * @param collect - list of mix, average, max
   */
  private static void fillResult(double[][] rez, int i, List<Double> collect) {
	Double min = Collections.min(collect);
	Double average = collect.stream().mapToDouble(a -> a).average().orElse(0);
	Double max = Collections.max(collect);
	rez[i][0] = min;
	rez[i][1] = average;
	rez[i][2] = max;
  }
}
