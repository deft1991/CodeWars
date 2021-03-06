package com.codewars.testtask;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 5/27/20

INPUT



PRINCIPAL =0.00|0.00|0.00|0.00|0.00|


INTEREST =0.00|0.00|404,671.00|0.00|



TOTAL_CF =0.00|0.00|404,671.00|0.00|



BALANCE =20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|



DATE_FORMATTED =20181221|20181227|20190128|20190227|



OUTPUT



#| DATE_FORMATTED| BALANCE|INTEREST|PRINCIPAL| TOTAL_CF

1|20181221|20,500,000.00|0.00|0.00|0.00

2|20181227|20,500,000.00|0.00|0.00|0.00

3|……

*
*

*  I have questions for this task:
* 1) Can I read ALL data to memory?
* 2) Or better to read line by line ?
* 3) Is this data placed in strings or in collection like list?
* 4) What should I do if principals more than interest or smth. like this?
* 5) In totalCf file in the end of the file i see two || is it correct ? What should I do with it?
* Let`s imagine that I have all data in memory;
* And all data in strings
* Ok, I`ll put NULL value if principals more than interest
*
*
* I have 4 strings for union an 1 counter
*
 */
public class DataFormatter {

    // Let`s test it
    public static void main(String[] args) {
        String principal = "0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|1,979,301.43|0.00|0.00|9,809,796.84|0.00|0.00|8,710,901.73||20,500,000.00|";
        String interest = "0.00|0.00|404,671.00|0.00|0.00|417,975.64|0.00|0.00|417,353.81|0.00|0.00|418,338.38|0.00|0.00|418,908.39|0.00|0.00|414,323.82|0.00|0.00|411,508.62|0.00|0.00|416,108.13|0.00|0.00|414,261.42|0.00|0.00|403,937.02|0.00|0.00|407,892.20|0.00|0.00|412,497.38|0.00|0.00|413,323.71|0.00|0.00|405,442.85|0.00|0.00|411,226.83|0.00|0.00|416,988.58|0.00|0.00|418,043.16|0.00|0.00|409,856.55|0.00|0.00|415,197.39|0.00|0.00|420,374.36|0.00|0.00|429,884.90|0.00|0.00|416,523.35|0.00|0.00|416,978.01|0.00|0.00|417,569.94|0.00|0.00|418,339.31|0.00|0.00|419,259.10|0.00|0.00|420,324.30|0.00|0.00|421,560.51|0.00|0.00|427,691.68|0.00|0.00|419,751.65|0.00|0.00|425,508.58|0.00|0.00|431,045.14|0.00|0.00|431,614.66|0.00|0.00|422,707.54|0.00|0.00|427,880.51|0.00|0.00|433,126.97|0.00|0.00|433,815.94|0.00|0.00|429,736.06|0.00|0.00|430,243.43|0.00|0.00|435,381.06|0.00|0.00|445,148.13|0.00|0.00|376,699.60|0.00|0.00|183,287.03||17,782,306.63|";
        String totalCf = "0.00|0.00|404,671.00|0.00|0.00|417,975.64|0.00|0.00|417,353.81|0.00|0.00|418,338.38|0.00|0.00|418,908.39|0.00|0.00|414,323.82|0.00|0.00|411,508.62|0.00|0.00|416,108.13|0.00|0.00|414,261.42|0.00|0.00|403,937.02|0.00|0.00|407,892.20|0.00|0.00|412,497.38|0.00|0.00|413,323.71|0.00|0.00|405,442.85|0.00|0.00|411,226.83|0.00|0.00|416,988.58|0.00|0.00|418,043.16|0.00|0.00|409,856.55|0.00|0.00|415,197.39|0.00|0.00|420,374.36|0.00|0.00|429,884.90|0.00|0.00|416,523.35|0.00|0.00|416,978.01|0.00|0.00|417,569.94|0.00|0.00|418,339.31|0.00|0.00|419,259.10|0.00|0.00|420,324.30|0.00|0.00|421,560.51|0.00|0.00|427,691.68|0.00|0.00|419,751.65|0.00|0.00|425,508.58|0.00|0.00|431,045.14|0.00|0.00|431,614.66|0.00|0.00|422,707.54|0.00|0.00|427,880.51|0.00|0.00|433,126.97|0.00|0.00|433,815.94|0.00|0.00|429,736.06|0.00|0.00|430,243.43|0.00|0.00|435,381.06|0.00|0.00|2,424,449.56|0.00|0.00|10,186,496.44|0.00|0.00|8,894,188.76||38,282,306.63|";
        String balance = "20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|20,500,000.00|18,520,698.57|18,520,698.57|18,520,698.57|8,710,901.73|8,710,901.73|8,710,901.73|0.00|";
        String dateFormatted = "20181221|20181227|20190128|20190227|20190327|20190429|20190528|20190627|20190729|20190827|20190927|20191028|20191127|20191227|20200127|20200227|20200327|20200427|20200527|20200629|20200727|20200827|20200928|20201027|20201127|20201228|20210127|20210301|20210329|20210427|20210527|20210628|20210727|20210827|20210927|20211027|20211129|20211227|20220127|20220228|20220328|20220427|20220527|20220627|20220727|20220829|20220927|20221027|20221128|20221227|20230127|20230227|20230327|20230427|20230530|20230627|20230727|20230828|20230927|20231027|20231127|20231227|20240129|20240227|20240327|20240429|20240528|20240627|20240729|20240827|20240927|20241028|20241127|20241227|20250127|20250227|20250327|20250428|20250527|20250627|20250728|20250827|20250929|20251027|20251128|20251229|20260127|20260227|20260327|20260427|20260527|20260629|20260727|20260827|20260928|20261027|20261127|20261228|20270127|20270301|20270329|20270427|20270527|20270628|20270727|20270827|20270927|20271027|20271129|20271227|20280127|20280228|20280327|20280427|20280530|20280627|20280727|20280828|20280927|20281027|20281127|20281227|20290129|20290227|20290327|20290427|20290529|20290627|20290727|||";
        DataFormatter dataFormatter = new DataFormatter();
        dataFormatter
                .processDataAllInMemory(principal, interest, totalCf, balance, dateFormatted)
                .forEach(System.out::println);
    }


    // in this way in depends on data. If I can store all data in memory
    // I can split by '|' char and use it.
    // In this solution I don`t see needs to use functional style
    List<String> processDataAllInMemory(String principal, String interest, String totalCf, String balance, String dateFormatted) {
        int count = 0;
        List<String> resultList = new ArrayList<>();
        resultList.add(union("#", "DATE_FORMATTED", "BALANCE", "INTEREST", "PRINCIPAL", "TOTAL_CF"));

        String[] splitPrincipal = principal.split("\\|");
        String[] splitInterest = interest.split("\\|");
        String[] splitTotalCf = totalCf.split("\\|");
        String[] splitBalance = balance.split("\\|");
        String[] splitDateFormatted = dateFormatted.split("\\|");

        while (count < splitPrincipal.length) {
            String splitInterestV = count >= splitInterest.length ? "NULL" : splitInterest[count];
            String splitTotalCfV = (count >= splitTotalCf.length) ? "NULL" : splitTotalCf[count];
            String splitBalanceV = (count >= splitBalance.length) ? "NULL" : splitBalance[count];
            String splitDateFormattedV = (count >= splitDateFormatted.length) ? "NULL" : splitDateFormatted[count];

            resultList.add(union(String.valueOf(count + 1),
                    splitPrincipal[count],
                    splitInterestV,
                    splitTotalCfV,
                    splitBalanceV,
                    splitDateFormattedV));
            count++;
        }

        return resultList;
        // or I can use steam for loop
//        int finalCount = count;
//        return IntStream
//                .range(0, splitPrincipal.length)
//                .filter(i -> i % 2 == 0)
//                .mapToObj(i -> {
//                    String splitInterestV = finalCount >= splitInterest.length ? "NULL" : splitInterest[finalCount];
//                    String splitTotalCfV = (finalCount >= splitTotalCf.length) ? "NULL" : splitTotalCf[finalCount];
//                    String splitBalanceV = (finalCount >= splitBalance.length) ? "NULL" : splitBalance[finalCount];
//                    String splitDateFormattedV = (finalCount >= splitDateFormatted.length) ? "NULL" : splitDateFormatted[finalCount];
//
//                    return   union(String.valueOf(finalCount + 1),
//                            splitPrincipal[finalCount],
//                            splitInterestV,
//                            splitTotalCfV,
//                            splitBalanceV,
//                            splitDateFormattedV);
//                })
//                .collect(Collectors.toList());
    }


    private String union(String count, String principal, String interest, String totalCf, String balance, String dateFormatted) {
        return count +
                '|' +
                principal +
                '|' +
                interest +
                '|' +
                totalCf +
                '|' +
                balance +
                '|' +
                dateFormatted;

    }

    private String unionFunctionalStyle(String... vars) {
//        return Arrays.stream(vars).collect(Collectors.joining("|"));
        return String.join("|", vars);

    }

}
