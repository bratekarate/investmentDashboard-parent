package org.goetheuni;

import java.math.BigDecimal;
import java.util.Date;

import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new SecurityTransaction(3, BigDecimal.valueOf(30), new Security("isin", "name", "shortName"), new Date(500000));
    }
}
