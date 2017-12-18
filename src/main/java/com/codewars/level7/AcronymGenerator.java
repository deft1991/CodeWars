package com.codewars.level7;

/*In nearly every company each employee has a certain acronym containing the first characters of his first and last name(s).
Your task is to write an acronym generator which generates an acronym for a given name.
You don't have to care about duplicate acronyms (someone else will do this for you).
Note that names can be given in upper or in lower case. The acronym shall always be upper case.
Normally the acronym is always the first letter of your first and the first letter of the last name in upper case.
For example:
Thomas Meyer => TM
martin schmidt => MS
In your company there work only people with a maxinmum of two first names.
If a person has two first names, they might be joined with a dash.
Jan-Erich Schmidt => JES Jan Erich Mueller => JEM
Last names may also be joined with a dash. No one can have more than two last names.
Paul Meyer-Schmidt
In Germany, there are last names which have the leading word "von". This shall be abbreviated with a lower case "v":
Paul von Lahnstein => PvL
Martin von Lahnstein-Meyer => MvLM
Happy coding!*/
public class AcronymGenerator {
    public static String createAcronym(String lastName, String firstName) {
        String rez = "";
        rez += parseFirstName(firstName);
        rez += parseLastName(lastName);
        return rez;
    }

    private static String parseLastName(String lastName) {
        StringBuilder rez = new StringBuilder();
        if (lastName.trim().startsWith("von") || lastName.trim().startsWith("VON")) {
            rez.append("v");
            if (lastName.contains("-") || lastName.contains(" ")) {
                String[] arr = lastName.substring(4).split("-").length > 1
                        ? lastName.substring(4).split("-") : lastName.substring(4).split(" ");
                for (int i = 0; i < arr.length; i++) {
                    appengFirstChar(rez, arr[i]);
                }
            } else {
                appengFirstChar(rez, lastName.substring(4));
            }
        } else if (lastName.contains("-") || lastName.contains(" ")) {
            String[] arr = lastName.split("-").length > 1 ? lastName.split("-") : lastName.split(" ");
            for (int i = 0; i < arr.length; i++) {
                appengFirstChar(rez, arr[i]);
            }
            rez.append("111111111");
        } else {
            rez.append(lastName.substring(0, 1).toUpperCase());
        }
        return rez.toString();
    }

    private static String parseFirstName(String firstName) {
        StringBuilder rez = new StringBuilder();
        if (firstName.contains("-") || firstName.contains(" ")) {
            String[] arr = firstName.split("-").length > 1 ? firstName.split("-") : firstName.split(" ");
            for (int i = 0; i < arr.length; i++) {
                appengFirstChar(rez, arr[i]);
            }
        } else {
            appengFirstChar(rez, firstName);
        }
        return rez.toString();
    }

    private static void appengFirstChar(StringBuilder rez, String s) {
        rez.append(s.substring(0, 1).toUpperCase());
    }
}
