package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Random;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RichTextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

import com.google.gwt.user.client.ui.Button;

//import edu.usc.cct.rapport.web_games.client.instructions.ScenarioInternationalizationConstants;



public class ScenarioDialogBox extends DialogBox {
	static final private ScenarioInternationalizationConstants constants = (ScenarioInternationalizationConstants) (GWT.isClient() ? GWT.create(ScenarioInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
//	final private EventBus eventBus;
	
	public ScenarioDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions){
	super(false, true);
//	this.eventBus = eventBus;
	
	setHTML(constants.scenario_Window_Title());
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
//		absolutePanel.setSize("545px", "595px");
		absolutePanel.setSize("750px", "550px");
		
		
		RichTextArea richTextArea = new RichTextArea();
		absolutePanel.add(richTextArea, 0, 0);
//		richTextArea.setSize("537px", "559px");
		richTextArea.setSize("740px", "505px");
		
		if(experimentConditions.getExpScenario()==2)
			richTextArea.setHTML(constants.scenario_textA());
		if(experimentConditions.getExpScenario()==3)
			richTextArea.setHTML(constants.scenario_textB());
		if(experimentConditions.getExpScenario()==4)
			richTextArea.setHTML(constants.scenario_textC());

		Button button = new Button(constants.ok_button());
//		absolutePanel.add(button, 440, 569);
		absolutePanel.add(button, 640, 515);
		button.setSize("101px", "26px");
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();				
//				final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, 1, experimentConditions);
//				final PreGameQuestionnaireDialogBox dialogBox  = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
				final ScenarioCheckQuizDialogBox dialogBox = new ScenarioCheckQuizDialogBox(eventBus, experimentConditions);
				dialogBox.center();
			}
		});
		
		this.setWidget(absolutePanel);
	}
	
	public ScenarioDialogBox(final int expScenario){
		setHTML(constants.scenario_Window_Title());
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
//		absolutePanel.setSize("545px", "595px");
		absolutePanel.setSize("750px", "550px");
		
		
		RichTextArea richTextArea = new RichTextArea();
		absolutePanel.add(richTextArea, 0, 0);
//		richTextArea.setSize("537px", "559px");
		richTextArea.setSize("740px", "505px");
		
		if(expScenario==2)
			richTextArea.setHTML(constants.scenario_textA());
		if(expScenario==3)
			richTextArea.setHTML(constants.scenario_textB());
		if(expScenario==4)
			richTextArea.setHTML(constants.scenario_textC());
		Button button = new Button(constants.ok_button());
//		absolutePanel.add(button, 440, 569);
		absolutePanel.add(button, 640, 515);
		button.setSize("101px", "26px");
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		
		this.setWidget(absolutePanel);
	}
}
