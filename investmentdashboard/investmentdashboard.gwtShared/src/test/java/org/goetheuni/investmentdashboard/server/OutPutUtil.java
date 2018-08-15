/**
 * 
 */
package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 *
 */
public class OutPutUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// add test payments
		CashPayment paymentNormal = new CashPayment(BigDecimal.valueOf(150), "EUR", "X", "DE1111XYZ",
				DateConversionUtil.toDate(date1));
		CashPayment paymentNegative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "X", "DE2222XYZ",
				DateConversionUtil.toDate(date2));
		CashPayment paymentBig = new CashPayment(BigDecimal.valueOf(10000), "EUR", "X", "DE3333XYZ",
				DateConversionUtil.toDate(date3));

		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			System.out.println(writer.writeValueAsString(paymentNormal));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
