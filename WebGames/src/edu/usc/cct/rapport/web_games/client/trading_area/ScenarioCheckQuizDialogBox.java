package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalSplitPanel;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

import com.google.gwt.user.client.ui.Button;

//import edu.usc.cct.rapport.web_games.client.instructions.ScenarioInternationalizationConstants;



public class ScenarioCheckQuizDialogBox extends DialogBox {
	static final private ScenarioInternationalizationConstants constants = (ScenarioInternationalizationConstants) (GWT.isClient() ? GWT.create(ScenarioInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final ArrayList<RadioButton> Quiz1 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz2 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz3 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz4 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz5 = new ArrayList<RadioButton>(); 

	public ScenarioCheckQuizDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions){
		super(false, true);
		this.eventBus = eventBus;

		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		
		setHTML(constants.scenario_quiz_Window_Title());
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("750px", "550px");
	
		if (localName == "en"){
			HTML part1 = new HTML(constants.scenario_quiz_part1());
			HTML quiz1 = new HTML(constants.scenario_quiz_no1()); 
			absolutePanel.add(part1, 10, 10);			
			absolutePanel.add(quiz1, 10, 35);			
			
			RadioButton radioButtonQuestions1_1  = new RadioButton("Quiz1");
			radioButtonQuestions1_1.setHTML(constants.scenario_quiz_no1_ans1());
			radioButtonQuestions1_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions1_1, 20, 60);
			radioButtonQuestions1_1.setSize("266px", "19px");
			Quiz1.add(radioButtonQuestions1_1);
		
			RadioButton radioButtonQuestions1_2 = new RadioButton("Quiz1");
			radioButtonQuestions1_2.setHTML(constants.scenario_quiz_no1_ans2());
			radioButtonQuestions1_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions1_2, 320, 60);
			radioButtonQuestions1_2.setSize("196px", "19px");
			Quiz1.add(radioButtonQuestions1_2);
		
			RadioButton radioButtonQuestions1_3 = new RadioButton("Quiz1");
			radioButtonQuestions1_3.setHTML(constants.scenario_quiz_no1_ans3());
			radioButtonQuestions1_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions1_3, 20, 85);
			Quiz1.add(radioButtonQuestions1_3);
		
			RadioButton radioButtonQuestions1_4 = new RadioButton("Quiz1");
			radioButtonQuestions1_4.setHTML(constants.scenario_quiz_no1_ans4());
			radioButtonQuestions1_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions1_4, 320, 85);
			Quiz1.add(radioButtonQuestions1_4);
			
	    	VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 109, 105);
			verticalSplitPanel.setSize("446px", "32px");
			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz2 = new HTML(constants.scenario_quiz_no2()); 
			absolutePanel.add(quiz2, 10, 145);			
			
			RadioButton radioButtonQuestions2_1  = new RadioButton("Quiz2");
			radioButtonQuestions2_1.setHTML(constants.scenario_quiz_no2_ans1());
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 20, 170);
			radioButtonQuestions2_1.setSize("266px", "19px");
			Quiz2.add(radioButtonQuestions2_1);
		
			RadioButton radioButtonQuestions2_2 = new RadioButton("Quiz2");
			radioButtonQuestions2_2.setHTML(constants.scenario_quiz_no2_ans2());
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 320, 170);
			radioButtonQuestions2_2.setSize("196px", "19px");
			Quiz2.add(radioButtonQuestions2_2);
		
			RadioButton radioButtonQuestions2_3 = new RadioButton("Quiz2");
			radioButtonQuestions2_3.setHTML(constants.scenario_quiz_no2_ans3());
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 20, 195);
			Quiz2.add(radioButtonQuestions2_3);
		
			RadioButton radioButtonQuestions2_4 = new RadioButton("Quiz2");
			radioButtonQuestions2_4.setHTML(constants.scenario_quiz_no2_ans4());
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 320, 195);
			Quiz2.add(radioButtonQuestions2_4);
			
	    	VerticalSplitPanel verticalSplitPanel2 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel2, 109, 215);
			verticalSplitPanel2.setSize("446px", "32px");
			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz3 = new HTML(constants.scenario_quiz_no3()); 
			absolutePanel.add(quiz3, 10, 255);			
			
			RadioButton radioButtonQuestions3_1  = new RadioButton("Quiz3");
			radioButtonQuestions3_1.setHTML(constants.scenario_quiz_no3_ans1());
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 20, 280);
			radioButtonQuestions3_1.setSize("266px", "19px");
			Quiz3.add(radioButtonQuestions3_1);
		
			RadioButton radioButtonQuestions3_2 = new RadioButton("Quiz3");
			radioButtonQuestions3_2.setHTML(constants.scenario_quiz_no3_ans2());
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 320, 280);
			radioButtonQuestions3_2.setSize("196px", "19px");
			Quiz3.add(radioButtonQuestions3_2);
		
			RadioButton radioButtonQuestions3_3 = new RadioButton("Quiz3");
			radioButtonQuestions3_3.setHTML(constants.scenario_quiz_no3_ans3());
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 20, 305);
			Quiz3.add(radioButtonQuestions3_3);
		
			RadioButton radioButtonQuestions3_4 = new RadioButton("Quiz3");
			radioButtonQuestions3_4.setHTML(constants.scenario_quiz_no3_ans4());
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 320, 305);
			Quiz3.add(radioButtonQuestions3_4);
			
	    	VerticalSplitPanel verticalSplitPanel3 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel3, 109, 325);
			verticalSplitPanel3.setSize("446px", "32px");
			
			////////////////////////////////////////////////////////////////////////////////////		
	
			HTML part2 = new HTML(constants.scenario_quiz_part2());
			HTML quiz4 = new HTML(constants.scenario_quiz_no4()); 
			absolutePanel.add(part2, 10, 365);			
			absolutePanel.add(quiz4, 10, 385);			
			
			RadioButton radioButtonQuestions4_1  = new RadioButton("Quiz4");
			radioButtonQuestions4_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 20, 410);
			radioButtonQuestions4_1.setSize("266px", "19px");
			Quiz4.add(radioButtonQuestions4_1);
		
			RadioButton radioButtonQuestions4_2 = new RadioButton("Quiz4");
			radioButtonQuestions4_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 320, 410);
			radioButtonQuestions4_2.setSize("196px", "19px");
			Quiz4.add(radioButtonQuestions4_2);

	    	VerticalSplitPanel verticalSplitPanel4 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel4, 109, 430);
			verticalSplitPanel4.setSize("446px", "32px");
			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz5 = new HTML(constants.scenario_quiz_no5()); 
			absolutePanel.add(quiz5, 10, 470);			
			
			RadioButton radioButtonQuestions5_1  = new RadioButton("Quiz5");
			radioButtonQuestions5_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 20, 495);
			radioButtonQuestions5_1.setSize("266px", "19px");
			Quiz5.add(radioButtonQuestions5_1);
		
			RadioButton radioButtonQuestions5_2 = new RadioButton("Quiz5");
			radioButtonQuestions5_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 320, 495);
			radioButtonQuestions5_2.setSize("196px", "19px");
			Quiz5.add(radioButtonQuestions5_2);
		}
		Button button = new Button(constants.ok_button());
		absolutePanel.add(button, 640, 515);
		button.setSize("101px", "26px");
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions);
//				dialogBox.center();
				
//				hide();
//				final PreGameQuestionnaireDialogBox dialogBox  = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
//				dialogBox.center();
				
				if(!getAnswers(Quiz1).equals("0") & !getAnswers(Quiz2).equals("0") & !getAnswers(Quiz3).equals("0") & !getAnswers(Quiz4).equals("0") 
						& !getAnswers(Quiz5).equals("0")) {
					
					if(getAnswers(Quiz1).equals(constants.scenario_quiz_no1_ans()) 			& getAnswers(Quiz2).equals(String.valueOf(experimentConditions.getExpScenario())) 
							& getAnswers(Quiz3).equals(constants.scenario_quiz_no3_ans()) 	& getAnswers(Quiz4).equals(constants.scenario_quiz_no4_ans()) 
							& getAnswers(Quiz5).equals(constants.scenario_quiz_no5_ans())) {
						hide();
						final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions, true);
	//					final PreGameQuestionnaireDialogBox dialogBox  = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
						dialogBox.center();
					
					} else {
						hide();
						final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions, false);
	//					final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
						dialogBox.center();
					}
				}
			}
		});
		
		this.setWidget(absolutePanel);
	}
	
	public String getAnswers(final ArrayList<RadioButton> questions) {
		final Iterator<RadioButton> iterator = questions.iterator();
		String valueofButton = "";
		RadioButton radioButtonTemp;
		final StringBuilder builder = new StringBuilder();
		
		while (iterator.hasNext()) {
			radioButtonTemp = iterator.next();
			if (radioButtonTemp.getValue()){
				builder.append(radioButtonTemp.getFormValue());
			}
			
	};
	valueofButton = builder.toString();
	if (valueofButton.isEmpty())
		valueofButton = "0";
	return valueofButton;
		
	};
}
