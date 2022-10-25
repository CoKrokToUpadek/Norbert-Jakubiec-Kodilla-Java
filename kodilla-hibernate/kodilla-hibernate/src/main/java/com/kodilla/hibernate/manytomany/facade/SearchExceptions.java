package com.kodilla.hibernate.manytomany.facade;

public class SearchExceptions extends Exception{

    public static String ERR_NO_COMPANY_NAMES_FOUND="No companies found, check search parameters";
    public static String ERR_NO_EMPLOYEE_NAMES_FOUND="No employees found, check search parameters";

    public SearchExceptions(String message) {
        super(message);
    }
}
