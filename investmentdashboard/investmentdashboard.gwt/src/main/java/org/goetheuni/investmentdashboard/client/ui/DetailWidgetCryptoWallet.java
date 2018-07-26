package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.Grid;

public class DetailWidgetCryptoWallet extends Grid implements AbstractDetailWidget<SelectableCryptoWallet> {

	private static int NUMBER_OF_PAYMENTS = 2;
	
	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#update(org.goetheuni.investmentdashboard.client.ui.Selectable)
	 */
	@Override
	public void update(SelectableCryptoWallet correspondingObject) {
		// get recent payments
		List<CryptoPayment> payments = correspondingObject
				.getRecentPaymentsSorted(DetailWidgetCryptoWallet.NUMBER_OF_PAYMENTS);

		// reset the table
		this.clear();

		// plot payments
		for (int row = 0; row < payments.size(); row++) {
			// get the payment
			CryptoPayment payment = payments.get(row);

			// set the date
			this.setText(row, 0,
					DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM).format(payment.getDateOfExecution()));

			// set the counter party name
			this.setText(row, 1, payment.getCounterPartyAddress());

			// format the amount
			BigDecimal rounded = payment.getAmount().setScale(6, RoundingMode.DOWN);
			String sign = rounded.signum() < 0? "-":"";
			NumberFormat format = NumberFormat.getDecimalFormat().overrideFractionDigits(2, 6);
			BigDecimal absolute = rounded.abs();		
			
			
			// set the amount
			this.getCellFormatter().getElement(row, 2).getStyle().setTextAlign(TextAlign.RIGHT);
			this.setText(row, 2, sign+payment.getCurrencyCode()+format.format(absolute.doubleValue()));
			
			// set the color
			String color = payment.getAmount().signum() < 0 ? StyleConstants.NEGATIVE_COLOR : StyleConstants.POSITIVE_COLOR;
			this.getCellFormatter().getElement(row, 2).getStyle().setColor(color);
		}
	}

	public DetailWidgetCryptoWallet() {
		super(DetailWidgetCryptoWallet.NUMBER_OF_PAYMENTS, 3);
		this.getColumnFormatter().setWidth(0, "40%");
		this.getColumnFormatter().setWidth(1, "40%");
		this.getColumnFormatter().setWidth(2, "20%");
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());
	}

	
}
