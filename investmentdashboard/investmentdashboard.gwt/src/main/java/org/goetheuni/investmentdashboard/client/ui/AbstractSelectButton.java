package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

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

	protected void setMarked() {
		this.getElement().getStyle().setBackgroundColor(StyleConstants.SELECTED_COLOR);
	}

	protected void setUnmarked() {
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

	protected AbstractSelectButton(Image icon, S correspondingStructure, List<Label> optionalLabels, Label optionalAmountLabel) {

		// validate input
		Objects.requireNonNull(icon, "The given Image must not be null");
		this.correspondingStructure = Objects.requireNonNull(correspondingStructure,
				"The given account or depot must not be null");
		Objects.requireNonNull(optionalLabels,
				"The given list of optional labels must not be null. Please consider an empty list");

		Objects.requireNonNull(optionalAmountLabel,
				"The given optional amount label must not be null. Please consider a blank label");
				
		// set width
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());

		// create a panel for the content
		this.content = new HorizontalPanel();
		this.content.setWidth(SizeConstants.ForCatWidgets.getWidth());
		this.content.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.add(this.content);

		// insert the icon
		this.content.add(icon);
		this.content.setCellWidth(icon, (Resources.getPictogramWidth() + 4) + "px");

		// insert the name and the id
		VerticalPanel nameAndId = new VerticalPanel();
		ContentLabelBlack name = new ContentLabelBlack(correspondingStructure.getName());
		ContentLabelDefault id = new ContentLabelDefault(correspondingStructure.getID());
		nameAndId.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		nameAndId.add(name);
		nameAndId.add(id);
		this.content.add(nameAndId);

		
		// add optional currency label
		for(Label optionalLabel : optionalLabels) {
			this.content.add(optionalLabel);
			this.content.setCellHorizontalAlignment(optionalLabel, HasHorizontalAlignment.ALIGN_RIGHT);
		}

		// add formatted amount in EUR and optional in X
		ContentLabelBlack amount = new ContentLabelBlack(correspondingStructure.getFormattedAmountInEUR());
		VerticalPanel amountPanel = new VerticalPanel();
		amountPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		amountPanel.add(amount);
		amountPanel.add(optionalAmountLabel);
		this.amount = amount;
		this.content.add(amountPanel);
		this.content.setCellHorizontalAlignment(amountPanel, HasHorizontalAlignment.ALIGN_RIGHT);
	}

}
