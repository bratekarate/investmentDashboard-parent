/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;
import java.util.Objects;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Objects of this class will be used in the dash board to select accounts or
 * depots
 *
 */
public abstract class AbstractSelectWidget<S extends Selectable> extends VerticalPanel {

	protected List<AbstractSelectButton<S>> selectButtons;

	protected ClickHandler generateClickHandler(S correspondingStructure, AbstractSelectButton<S> clickedButton,
			List<AbstractSelectButton<S>> allButtons, AbstractDetailWidget<S> detailWidget) {

		return new ClickHandler() {

			@Override
			public void onClick(ClickEvent arg0) {
				// check whether the clicked button was marked
				boolean wasMarked = clickedButton.isMarked();

				// set all buttons of this widget unmarked
				for (AbstractSelectButton<S> abtn : allButtons) {
					abtn.setUnmarked();
				}

				// two cases:
				// 1. the clicked button has not been marked
				// 2. the clicked button is the marked button

				if (!wasMarked) {
					// first case
					// set the button marked
					clickedButton.setMarked();
					// update the widget
					detailWidget.update(correspondingStructure);
				} else {
					// second case
					// do not mark any buttons
					// instead reset the datil widget
					detailWidget.resetAppearance();
				}
			}
		};

	}

	protected AbstractSelectWidget(List<AbstractSelectButton<S>> someSelectButtons,
			AbstractDetailWidget<S> detailWidget) {
		// validate input
		this.selectButtons = Objects.requireNonNull(someSelectButtons,
				"The given list of accounts or depots must not be null");

		// sort the list to guarantee the same order
		this.selectButtons.sort(null);

		// register ClickHandlers and add button to the widget
		for (int i = 0; i < this.selectButtons.size(); i++) {
			AbstractSelectButton<S> btn = this.selectButtons.get(i);
			btn.addClickHandler(
					this.generateClickHandler(btn.getCorrespondingStructure(), btn, this.selectButtons, detailWidget));
			this.add(btn);
		}
	}
}
