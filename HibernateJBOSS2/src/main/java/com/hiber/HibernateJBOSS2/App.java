package com.hiber.HibernateJBOSS2;

import com.generatedEntities.CarHome;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CarHome ch = new CarHome();
       System.out.println( ch.findById("A150FA17-2556-4C61-B2CA-01C04C1F45EC1").toString() );
    }
}
