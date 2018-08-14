package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Objects of this class are detail widgets for security depots.
 * They have four child widgets. A transaction widget, a flop investment widget, a top investment widget and a aggregation widget.
 * 
 * 
 * JAVADOC DONE
 */
public class DetailWidgetSecurityDepot extends VerticalPanel implements AbstractDetailWidget<SelectableSecurityDepot> {

	/**
	 * The number of top-investments show.
	 */
	protected static final int NUMBER_OF_TOPS = 3;

	/** 
	 * The number of flop investments shown
	 */
	protected static final int NUMBER_OF_FLOPS = 3;

	/**
	 * Number of pixels between the first level child widgets
	 */
	protected static final int VERTICAL_PADDING = 10;

	/**
	 * The security depot, whose details are shown lastly
	 */
	protected SelectableSecurityDepot currentCorrespondingObject;

	/**
	 * The widget that shows aggregated information about the portofolio's developement
	 */
	protected AggregationsWidget aggregations;

	/**
	 * The panel containing the top and the flop widget
	 */
	protected HorizontalPanel middle;

	/**
	 * The widget that visualizes the portfolio's top investments
	 */
	protected TopsWidget tops;

	/**
	 * The widget that visualizes the portfolio's flop investments
	 */
	protected FlopsWidget flops;

	/**
	 * The widgets for the most recent transactions
	 */
	protected SecurityTransactionsWidget transactions;

	/**
	 * Adds all gains in value for all investments of the portfolio.
	 * Only investments with a positive gain = quotation > reference value
	 * 
	 * @param sortedInvestments All investments of the portfolio
	 * @return Sum of all value gains
	 */
	private static BigDecimal getTotalValueGain(List<SecurityInvestmentStruct> sortedInvestments) {
		BigDecimal result = BigDecimal.ZERO;

		for (int i = 0; i < sortedInvestments.size(); i++) {
			BigDecimal investmentGain = sortedInvestments.get(i).getCachedDelta();
			if (investmentGain.signum() > 0) {
				// accumulate
				result = result.add(investmentGain);
			} else {
				// no more gains left
				break;
			}
		}

		return result;
	}

	/**
	 * Adds the greatest (numberOfTops) gains in value for of the portfolio.
	 * @param sortedInvestments All investments of the portfolio
	 * @param numberOfTops The number of top-investments
	 * @return Sum of gains in value of the top-investment
	 */
	private static BigDecimal getTopsValueGain(List<SecurityInvestmentStruct> sortedInvestments, int numberOfTops) {
		BigDecimal result = BigDecimal.ZERO;
		int accumulated = 0;

		for (int i = 0; i < sortedInvestments.size() && accumulated < numberOfTops; i++) {
			BigDecimal investmentGain = sortedInvestments.get(i).getCachedDelta();
			if (investmentGain.signum() > 0) {
				// accumulate
				result = result.add(investmentGain);
				accumulated++;
			} else {
				// no more gains left
				break;
			}
		}

		return result;
	}

	/**
	 * Adds all declines in value for all investments of the portfolio.
	 * Only investments with a positive decline = quotation < reference value
	 * 
	 * @param sortedInvestments All investments of the portfolio
	 * @return Sum of all value declines
	 */
	private static BigDecimal getTotalValueDecline(List<SecurityInvestmentStruct> sortedInvestments) {
		BigDecimal result = BigDecimal.ZERO;

		for (int i = sortedInvestments.size() - 1; i >= 0; i--) {
			BigDecimal investmentDecline = sortedInvestments.get(i).getCachedDelta();
			if (investmentDecline.signum() < 0) {
				// accumulate
				result = result.add(investmentDecline);
			} else {
				// no more declines left
				break;
			}
		}
		// return the absolute value
		return result.abs();
	}

	/**
	 * Adds the (numberOfFlops) declines in value with the greatest absolute value for all investments of the portfolio.
	 * Only investments with a positive decline = quotation < reference value
	 * 
	 * @param sortedInvestments All investments of the portfolio
	 * @param numberOfFlops the number of flop-investments
	 * @return Sum of declines in value for the flop-investment
	 */
	private static BigDecimal getFlopsValueDecline(List<SecurityInvestmentStruct> sortedInvestments,
			int numberOfFlops) {
		BigDecimal result = BigDecimal.ZERO;
		int accumulated = 0;

		for (int i = sortedInvestments.size() - 1; i >= 0 && accumulated < numberOfFlops; i--) {
			BigDecimal investmentDecline = sortedInvestments.get(i).getCachedDelta();
			if (investmentDecline.signum() < 0) {
				// accumulate
				result = result.add(investmentDecline);
				accumulated++;
			} else {
				// no more declines left
				break;
			}
		}
		// return the absolute value
		return result.abs();
	}

	/**
	 * Returns the investments with the greatest total gain in value.
	 * 
	 * @param sortedInvestments All investments of the portfolio
	 * @param numberOfTops The maximum number of top-investements
	 * @return the investments with the greatest total gain in value, at most the given number
	 */
	private static List<SecurityInvestmentStruct> getTops(List<SecurityInvestmentStruct> sortedInvestments,
			int numberOfTops) {
		List<SecurityInvestmentStruct> result = new ArrayList<>();
		int accumulated = 0;

		for (int i = 0; i < sortedInvestments.size() && accumulated < numberOfTops; i++) {
			SecurityInvestmentStruct investment = sortedInvestments.get(i);
			BigDecimal investmentGain = investment.getCachedDelta();
			if (investmentGain.signum() > 0) {
				// add to list
				result.add(investment);
				accumulated++;
			} else {
				// no more gains left
				break;
			}
		}

		return result;
	}

	/**
	 * Returns the investments with the most severe decline in total value.
	 * 
	 * @param sortedInvestments All investments of the portfolio
	 * @param numberOfFlops maximum number of flop-investments
	 * @return the flop investments, at most the given number
	 */
	private static List<SecurityInvestmentStruct> getFlops(List<SecurityInvestmentStruct> sortedInvestments,
			int numberOfFlops) {
		List<SecurityInvestmentStruct> result = new ArrayList<>();
		int accumulated = 0;

		for (int i = sortedInvestments.size() - 1; i >= 0 && accumulated < numberOfFlops; i--) {
			SecurityInvestmentStruct investment = sortedInvestments.get(i);
			BigDecimal investmentDecline = investment.getCachedDelta();
			if (investmentDecline.signum() < 0) {
				// add to list
				result.add(investment);
				accumulated++;
			} else {
				// no more declines left
				break;
			}
		}

		return result;
	}

	/**
	 * @return the currentCorrespondingObject
	 */
	public SelectableSecurityDepot getCurrentCorrespondingObject() {
		return currentCorrespondingObject;
	}



	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#update(org.goetheuni.investmentdashboard.client.ui.Selectable)
	 */
	@Override
	public void update(SelectableSecurityDepot correspondingObject) {
		// update the current structure object
		this.currentCorrespondingObject = Objects.requireNonNull(correspondingObject,
				"The given structure object must not be null");

		// ensure visibility
		this.aggregations.setTableContentVisibility(true);
		this.tops.setVisible(true);
		this.flops.setVisible(true);
		this.transactions.setTableContentVisibility(true);

		List<SecurityInvestmentStruct> sortedInv = correspondingObject.getInvestments();
		sortedInv.sort(new Comparator<SecurityInvestmentStruct>() {

			@Override
			public int compare(SecurityInvestmentStruct a, SecurityInvestmentStruct b) {
				// descending
				return b.getCachedDelta().subtract(a.getCachedDelta()).signum();
			}
		});

		BigDecimal totalPlus = DetailWidgetSecurityDepot.getTotalValueGain(sortedInv);
		BigDecimal totalMinus = DetailWidgetSecurityDepot.getTotalValueDecline(sortedInv);
		BigDecimal topsPlus = DetailWidgetSecurityDepot.getTopsValueGain(sortedInv, NUMBER_OF_TOPS);
		BigDecimal flopsMinus = DetailWidgetSecurityDepot.getFlopsValueDecline(sortedInv, NUMBER_OF_FLOPS);

		// update the widget for aggregations
		this.aggregations.update(totalPlus, totalMinus, topsPlus, flopsMinus);

		// update the tops widget
		this.tops.update(DetailWidgetSecurityDepot.getTops(sortedInv, NUMBER_OF_TOPS));

		// update the flops widget
		this.flops.update(DetailWidgetSecurityDepot.getFlops(sortedInv, NUMBER_OF_FLOPS));

		// update the widgets for the most recent transactions
		this.transactions.update(correspondingObject);

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#
	 * resetAppearance()
	 */
	@Override
	public void resetAppearance() {

		// set the visibility of the child widgets to false
		this.aggregations.setTableContentVisibility(false);
		this.tops.setVisible(false);
		this.flops.setVisible(false);
		this.transactions.setTableContentVisibility(false);
	}

	private static void initialize(DetailWidgetSecurityDepot that) {

		that.setWidth("100%");

		// set the space between the widgets
		that.setSpacing(5);

		// create and add the child widget
		AggregationsWidget newAggregations = that.new AggregationsWidget();
		that.aggregations = newAggregations;
		that.add(newAggregations);
		newAggregations.getElement().getStyle().setPaddingTop(VERTICAL_PADDING, Unit.PX);
		newAggregations.getElement().getStyle().setPaddingBottom(VERTICAL_PADDING, Unit.PX);

		HorizontalPanel newMiddle = new HorizontalPanel();
		that.middle = newMiddle;
		that.add(newMiddle);
		newMiddle.setWidth("100%");
		newMiddle.getElement().getStyle().setPaddingBottom(VERTICAL_PADDING, Unit.PX);

		TopsWidget newTops = that.new TopsWidget();
		that.tops = newTops;
		newTops.setVisible(false);
		newMiddle.add(newTops);
		newMiddle.setCellWidth(newTops, "47%");
		newMiddle.setCellHorizontalAlignment(newTops, HasHorizontalAlignment.ALIGN_LEFT);

		FlopsWidget newFlops = that.new FlopsWidget();
		that.flops = newFlops;
		newFlops.setVisible(false);
		newMiddle.add(newFlops);
		newMiddle.setCellWidth(newFlops, "47%");
		newMiddle.setCellHorizontalAlignment(newFlops, HasHorizontalAlignment.ALIGN_RIGHT);

		SecurityTransactionsWidget newTransact = that.new SecurityTransactionsWidget();
		that.transactions = newTransact;
		that.add(newTransact);
	}

	/**
	 * Creates a detail widget for security accounts.
	 */
	public DetailWidgetSecurityDepot() {
		DetailWidgetSecurityDepot.initialize(this);
	}

	/**
	 * Objects of this class show aggregated information about the portfolio's development.
	 */
	protected class AggregationsWidget extends Grid {

		/**
		 * The number of columns of the table
		 * The column in the middle serves is intended to be blank.
		 */
		private static final int NUMBER_OF_COLUMNS = 5;

		/**
		 * The number of rows of the table.
		 * The first row must be reserved for the header.
		 */
		private static final int NUMBER_OF_ROWS = 4;

		/**
		 * Allows to set the visibility of the contained HTML tables content.
		 * 
		 * @param visibility
		 *            true = visible, false = not visible
		 */
		protected void setTableContentVisibility(boolean visibility) {
			if (visibility) {
				for (int index = 0; index < this.getRowCount(); index++) {
					// set visible
					this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.VISIBLE);
				}
			} else {
				for (int index = 0; index < this.getRowCount(); index++) {
					// set invisible
					this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.HIDDEN);
				}
			}
		}

		protected void update(BigDecimal sumOfValueGains, BigDecimal sumOfValueDeclines, BigDecimal topsValueGain,
				BigDecimal flopsValueDecline) {

			// prepare header
			this.setText(0, 0, "Entwicklung zum Vortag:");

			// set the portfolio's gain in value or decline
			BigDecimal gainOrDeclineOfPortfolioValue = sumOfValueGains.subtract(sumOfValueDeclines);

			if (gainOrDeclineOfPortfolioValue.signum() == -1) {
				// the total value declined
				this.setText(0, 3, "Portfolio-Kursverlust");
				this.setText(0, 4, NumberFormat.getCurrencyFormat("EUR").format(gainOrDeclineOfPortfolioValue.abs()));
				this.getCellFormatter().getElement(0, 4).getStyle().setColor(StyleConstants.NEGATIVE_COLOR);
				;
			} else {
				// the total value did not decline
				this.setText(0, 3, "Portfolio-Kursgewinn");
				this.setText(0, 4, NumberFormat.getCurrencyFormat("EUR").format(gainOrDeclineOfPortfolioValue));
				this.getCellFormatter().getElement(0, 4).getStyle().setColor(StyleConstants.POSITIVE_COLOR);
			}

			// set the labels for the other aggregations and the values
			this.setText(2, 0, "Kursgewinne der Tops");
			this.setText(2, 1, NumberFormat.getCurrencyFormat("EUR").format(topsValueGain));
			this.getCellFormatter().getElement(2, 1).getStyle().setColor(StyleConstants.POSITIVE_COLOR);

			this.setText(3, 0, "Summe aller Kursgewinne");
			this.setText(3, 1, NumberFormat.getCurrencyFormat("EUR").format(sumOfValueGains));
			this.getCellFormatter().getElement(3, 1).getStyle().setColor(StyleConstants.POSITIVE_COLOR);

			this.setText(2, 3, "Kursverluste der Flops");
			this.setText(2, 4, NumberFormat.getCurrencyFormat("EUR").format(flopsValueDecline));
			this.getCellFormatter().getElement(2, 4).getStyle().setColor(StyleConstants.NEGATIVE_COLOR);

			this.setText(3, 3, "Summe aller Kursverluste");
			this.setText(3, 4, NumberFormat.getCurrencyFormat("EUR").format(sumOfValueDeclines));
			this.getCellFormatter().getElement(3, 4).getStyle().setColor(StyleConstants.NEGATIVE_COLOR);
		}

		/**
		 * Creates and initializes an aggregations widget.
		 */
		protected AggregationsWidget() {
			super(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
			this.setWidth("100%");
			this.getColumnFormatter().setWidth(0, "34%");
			this.getColumnFormatter().setWidth(1, "15%");
			this.getColumnFormatter().setWidth(2, "2%");
			this.getColumnFormatter().setWidth(3, "34%");
			this.getColumnFormatter().setWidth(4, "15%");

			this.getCellFormatter().getElement(2, 1).getStyle().setTextAlign(TextAlign.RIGHT);
			this.getCellFormatter().getElement(3, 1).getStyle().setTextAlign(TextAlign.RIGHT);
			this.getCellFormatter().getElement(0, 4).getStyle().setTextAlign(TextAlign.RIGHT);
			this.getCellFormatter().getElement(2, 4).getStyle().setTextAlign(TextAlign.RIGHT);
			this.getCellFormatter().getElement(3, 4).getStyle().setTextAlign(TextAlign.RIGHT);
		}
	}

	/**
	 * A widget for the most recent security transactions.
	 */
	protected class SecurityTransactionsWidget extends Grid {

		/**
		 * The number of transactions shown
		 */
		private final static int NUMBER_OF_TRANSACTIONS = 3;

		/**
		 * Allows to set the visibility of the contained HTML tables content.
		 * 
		 * @param visibility
		 *            true = visible, false = not visible
		 */
		protected void setTableContentVisibility(boolean visibility) {
			if (visibility) {
				for (int index = 0; index < this.getRowCount(); index++) {
					// set visible
					this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.VISIBLE);
				}
			} else {
				for (int index = 0; index < this.getRowCount(); index++) {
					// set invisible
					this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.HIDDEN);
				}
			}
		}

		/**
		 * Updates this transactions widget such that it shows transactions of the given depot.
		 * 
		 * @param correspondingObject The depot, whose most recent transactions will be shown
		 */
		protected void update(SelectableSecurityDepot correspondingObject) {

			// reset the table, but only the content
			for (int row = 0; row < this.getRowCount(); row++) {
				for (int col = 0; col < this.getColumnCount(); col++) {
					this.setText(row, col, "");
				}
			}

			// set the header
			this.setText(0, 0, "letzte Transaktionen:");
			this.setText(0, 1, "Wertpapier");
			this.setText(0, 2, "Typ");
			this.setText(0, 3, "Anzahl");
			this.setText(0, 4, "Preis");

			List<SecurityTransaction> listOfTransaction = correspondingObject
					.getRecentTransactionsSorted(NUMBER_OF_TRANSACTIONS);

			for (int transactionIndex = 0; transactionIndex < listOfTransaction.size(); transactionIndex++) {
				// get the transaction
				SecurityTransaction aTransact = listOfTransaction.get(transactionIndex);

				// set the date
				String dateString = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM)
						.format(aTransact.getDateOfExecution());
				this.setText(1 + transactionIndex, 0, dateString);

				// set the security's name
				this.setText(1 + transactionIndex, 1, aTransact.getSecurity().getShortName());
				this.getCellFormatter().getElement(1 + transactionIndex, 1).getStyle().setColor("black");

				// set the transaction's type
				String typeString = aTransact.getIsSellTransaction() ? "Verkauf" : "Kauf";
				this.setText(1 + transactionIndex, 2, typeString);

				// set the quantity
				String quantityString = aTransact.getQuantity() + " Stk.";
				this.setText(1 + transactionIndex, 3, quantityString);

				// compute the average prize per security and set it
				BigDecimal totalPrize = aTransact.getTotalPrize().setScale(4, RoundingMode.DOWN);
				BigDecimal quantity = BigDecimal.valueOf(aTransact.getQuantity()).setScale(4, RoundingMode.DOWN);
				BigDecimal averagePrize = totalPrize.divide(quantity, RoundingMode.DOWN);
				String prizeString = NumberFormat.getCurrencyFormat("EUR").format(averagePrize) + "/Stk.";
				this.setText(1 + transactionIndex, 4, prizeString);

				// set the text alignment and color for the last column
				this.getCellFormatter().getElement(1 + transactionIndex, 4).getStyle().setTextAlign(TextAlign.RIGHT);
				this.getCellFormatter().getElement(1 + transactionIndex, 4).getStyle().setColor("black");
			}
		}

		/**
		 * Creates and initializes a security transaction widget.
		 */
		protected SecurityTransactionsWidget() {
			super(NUMBER_OF_TRANSACTIONS + 1, 5);
			this.setWidth("100%");
			this.getColumnFormatter().setWidth(0, "30%");
			this.getColumnFormatter().setWidth(1, "30%");
			this.getColumnFormatter().setWidth(2, "13%");
			this.getColumnFormatter().setWidth(3, "12%");
			this.getColumnFormatter().setWidth(4, "15%");
		}
	}

	/**
	 * Objects of this class visualize a portfolio's top investments.
	 */
	protected class TopsWidget extends VerticalPanel {
		
		/**
		 * Contains the visualizations of the top investments
		 */
		protected VerticalPanel content;

		/**
		 * The widget's header
		 */
		protected Label header;

		/**
		 * Updates the tops widget. 
		 * All investments in the given list are shown.
		 * It is assumed to be sorted.
		 * The investment with the greatest gain in total value must be at first position. 
		 * 
		 * @param sortedTops A sorted list of top investments (greatest gain in total value must be at first position)
		 */
		protected void update(List<SecurityInvestmentStruct> sortedTops) {
			this.content.clear();
			this.header.setVisible(true);

			// add widgets
			for (int i = 0; i < sortedTops.size(); i++) {
				SecurityInvestmentStruct aTop = sortedTops.get(i);
				this.content.add(new TopInvestmentWidget(aTop));
			}
		}

		/**
		 * Creates and initializes a tops widget.
		 */
		protected TopsWidget() {
			this.setWidth("100%");
			this.setSpacing(4);
			this.getElement().getStyle().setBackgroundColor(StyleConstants.TOP_WIDGET_COLOR);
			Label newHeader = new ContentLabelDefault("Meine Top-Investments");
			this.header = newHeader;
			newHeader.getElement().getStyle().setColor(StyleConstants.POSITIVE_COLOR);
			newHeader.setVisible(false);
			newHeader.getElement().getStyle().setPaddingBottom(4, Unit.PX);
			this.add(newHeader);
			this.setCellHorizontalAlignment(newHeader, HasHorizontalAlignment.ALIGN_CENTER);

			VerticalPanel newContent = new VerticalPanel();
			this.content = newContent;
			newContent.setWidth("100%");
			this.add(newContent);
		}
	}

	/**
	 * Objects of this class visualize the portfolio's flop-investments.
	 */
	protected class FlopsWidget extends VerticalPanel {
		
		/**
		 * Contains the investment's visualizations
		 */
		protected VerticalPanel content;

		/**
		 * The widget's header
		 */
		protected Label header;

		/**
		 * Updates the flops widget. 
		 * All investments in the given list are shown.
		 * It is assumed to be sorted.
		 * The investment with the most severe decline in total value must be at first position. 
		 * 
		 * @param sortedFlops The sorted list of flop-investments to show (most severe decline in total value must be at first position).
		 */
		protected void update(List<SecurityInvestmentStruct> sortedFlops) {
			this.content.clear();
			this.header.setVisible(true);

			// add widgets
			for (int i = 0; i < sortedFlops.size(); i++) {
				SecurityInvestmentStruct aFlop = sortedFlops.get(i);
				this.content.add(new FlopInvestmentWidget(aFlop));
			}
		}

		/**
		 * Created and initializes the flops widget.
		 */
		protected FlopsWidget() {
			this.setWidth("100%");
			this.setSpacing(4);
			this.getElement().getStyle().setBackgroundColor(StyleConstants.FLOP_WIDGET_COLOR);
			Label newHeader = new ContentLabelDefault("Meine Flop-Investments");
			newHeader.getElement().getStyle().setPaddingBottom(4, Unit.PX);
			this.header = newHeader;
			newHeader.getElement().getStyle().setColor(StyleConstants.NEGATIVE_COLOR);
			newHeader.setVisible(false);
			this.add(newHeader);
			this.setCellHorizontalAlignment(newHeader, HasHorizontalAlignment.ALIGN_CENTER);

			VerticalPanel newContent = new VerticalPanel();
			this.content = newContent;
			newContent.setWidth("100%");
			this.add(newContent);
		}

	}

}
