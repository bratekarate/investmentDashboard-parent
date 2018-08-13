package org.goetheuni.investmentdashboard.client.ui;

import java.util.Objects;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class AbstractSelectButton<S extends Selectable> extends FocusPanel
		implements Comparable<AbstractSelectButton<S>> {

	protected HorizontalPanel content;

	protected S correspondingStructure;

	protected ContentLabelBlack amount;

	protected VolatilityLabel volatility;
	
	protected boolean isMarked;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	/**
	 * @return the correspondingStructure
	 */
	protected S getCorrespondingStructure() {
		return correspondingStructure;
	}

	/**
	 * @return the isMarked
	 */
	public boolean isMarked() {
		return isMarked;
	}

	protected void setMarked() {
		this.isMarked = true;
		this.getElement().getStyle().setBackgroundColor(StyleConstants.SELECTED_COLOR);
	}

	protected void setUnmarked() {
		this.isMarked = false;
		this.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AbstractSelectButton<S> o) {
		return this.correspondingStructure.compareTo(o.getCorrespondingStructure());
	}

	protected AbstractSelectButton(Image icon, S correspondingStructure, VolatilityLabel optionalVolatilityLabel,
			Label optionalAmountLabel) {

		// validate input
		Objects.requireNonNull(icon, "The given Image must not be null");
		this.correspondingStructure = Objects.requireNonNull(correspondingStructure,
				"The given account or depot must not be null");
		this.volatility = Objects.requireNonNull(optionalVolatilityLabel,
				"The given optional label must not be null. Please consider a blank label");

		Objects.requireNonNull(optionalAmountLabel,
				"The given optional amount label must not be null. Please consider a blank label");

		// initial state is unmarked
		this.isMarked = false;
		
		// set width
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());

		// set cursor style to pointer
		this.getElement().getStyle().setCursor(Style.Cursor.POINTER);

		// create a panel for the content
		this.content = new HorizontalPanel();
		this.content.setWidth(SizeConstants.ForCatWidgets.getWidth());
		this.content.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.add(this.content);

		// insert the icon
		this.content.add(icon);
		this.content.setCellWidth(icon, (Resources.getPictogramWidth() + 4) + "px");
		this.content.setCellVerticalAlignment(icon, HasVerticalAlignment.ALIGN_MIDDLE);

		// insert the name and the id
		VerticalPanel nameAndId = new VerticalPanel();
		ContentLabelBlack name = new ContentLabelBlack(correspondingStructure.getName());
		ContentLabelDefault id = new ContentLabelDefault(correspondingStructure.getID());
		nameAndId.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		nameAndId.add(name);
		nameAndId.add(id);
		this.content.add(nameAndId);

		// add optional volatility label

		this.content.add(optionalVolatilityLabel);
		this.content.setCellHorizontalAlignment(optionalVolatilityLabel, HasHorizontalAlignment.ALIGN_RIGHT);

		// add formatted amount in EUR and optional in X
		ContentLabelBlack amount = new ContentLabelBlack(correspondingStructure.getFormattedAmountInEUR());
		VerticalPanel amountPanel = new VerticalPanel();
		amountPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		amountPanel.add(amount);
		amountPanel.add(optionalAmountLabel);
		this.amount = amount;
		this.content.add(amountPanel);
		this.content.setCellHorizontalAlignment(amountPanel, HasHorizontalAlignment.ALIGN_RIGHT);
		this.content.setCellWidth(amountPanel, "25%");
	}

}
