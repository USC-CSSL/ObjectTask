package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumSet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.WebGamesClientBundle;

public enum TradingObjectEnum {
	blank,
	squiggle_1,
	squiggle_2,
	squiggle_3,
	squiggle_4,
	squiggle_5,
	squiggle_6,
	squiggle_7,
	squiggle_8,
	istockphoto_water_bottles,
	istockphoto_money_stack,
	istockphoto_tin_can,
	istockphoto_medication,
	sacredObjects_medication,
	sacredObjects_water_bottles,
	sacredObjects_tin_can,
	sacredObjects_money_stack,
	sacredObjects_hand_sanitizer,
	sacredObjects_document,
	sacredObjects_reform,
	sacredObjects_bonus,
	sacredObjects_immigration_bill,
	sacredObjects_gun_bill,
	sacredObjects_private_sector;

	static final private WebGamesClientBundle webGamesClientBundle = (WebGamesClientBundle) (GWT.isClient() ? GWT.create(WebGamesClientBundle.class) : null);
	static final private TradingObjectsInternationalizationConstants constants = (TradingObjectsInternationalizationConstants) (GWT.isClient() ? GWT.create(TradingObjectsInternationalizationConstants.class) : null);


	private String getDescription() {

		String result;

		switch (this) {
		case blank:
			result = "";
			break;
		case squiggle_1:
			result = constants.squiggle_1_Description();
			break;
		case squiggle_2:
			result = constants.squiggle_2_Description();
			break;
		case squiggle_3:
			result = constants.squiggle_3_Description();
			break;
		case squiggle_4:
			result = constants.squiggle_4_Description();
			break;
		case squiggle_5:
			result = constants.squiggle_5_Description();
			break;
		case squiggle_6:
			result = constants.squiggle_6_Description();
			break;
		case squiggle_7:
			result = constants.squiggle_7_Description();
			break;
		case squiggle_8:
			result = constants.squiggle_8_Description();
			break;
		case istockphoto_water_bottles:
			result = constants.istockphoto_water_bottles_Description();
			break;
		case istockphoto_money_stack:
			result = constants.istockphoto_money_stack_Description();
			break;
		case istockphoto_tin_can:
			result = constants.istockphoto_tin_can_Description();
			break;
		case istockphoto_medication:
			result = constants.istockphoto_medication_Description();
			break;
		case sacredObjects_water_bottles:
			result = constants.sacredObjects_water_bottles_Description();
			break;
		case sacredObjects_money_stack:
			result = constants.sacredObjects_money_stack_Description();
			break;
		case sacredObjects_tin_can:
			result = constants.sacredObjects_tin_can_Description();
			break;
		case sacredObjects_medication:
			result = constants.sacredObjects_medication_Description();
			break;
		case sacredObjects_hand_sanitizer:
			result = constants.sacredObjects_hand_sanitizer_Description();
			break;
		case sacredObjects_document:
			result = constants.sacredObjects_document_Description();
			break;
		case sacredObjects_reform:
			result = constants.sacredObjects_reform_Description();
			break;
		case sacredObjects_bonus:
			result = constants.sacredObjects_bonus_Description();
			break;
		case sacredObjects_immigration_bill:
			result = constants.sacredObjects_immigration_bill_Description();
			break;
		case sacredObjects_gun_bill:
			result = constants.sacredObjects_gun_bill_Description();
			break;
		case sacredObjects_private_sector:
			result = constants.sacredObjects_private_sector_Description();
			break;
			
		default:
			throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getDescription().");
		};

		return result;
	};


	private ImageResource getImageResource() {

		ImageResource result = null;

		switch (this) {
		case blank:
			result = webGamesClientBundle.blank();
			break;
		case squiggle_1:
			result = webGamesClientBundle.squiggle_1();
			break;
		case squiggle_2:
			result = webGamesClientBundle.squiggle_2();
			break;
		case squiggle_3:
			result = webGamesClientBundle.squiggle_3();
			break;
		case squiggle_4:
			result = webGamesClientBundle.squiggle_4();
			break;
		case squiggle_5:
			result = webGamesClientBundle.squiggle_5();
			break;
		case squiggle_6:
			result = webGamesClientBundle.squiggle_6();
			break;
		case squiggle_7:
			result = webGamesClientBundle.squiggle_7();
			break;
		case squiggle_8:
			result = webGamesClientBundle.squiggle_8();
			break;
		case istockphoto_water_bottles:
			result = webGamesClientBundle.istockphoto_water_bottles();
			break;
		case istockphoto_money_stack:
			result = webGamesClientBundle.istockphoto_money_stack();
			break;
		case istockphoto_tin_can:
			result = webGamesClientBundle.istockphoto_tin_can();
			break;
		case istockphoto_medication:
			result = webGamesClientBundle.istockphoto_medication();
			break;
		case sacredObjects_water_bottles:
			result = webGamesClientBundle.sacredObjects_water_bottles();
			break;
		case sacredObjects_money_stack:
			result = webGamesClientBundle.sacredObjects_money_stack();
			break;
		case sacredObjects_tin_can:
			result = webGamesClientBundle.sacredObjects_tin_can();
			break;
		case sacredObjects_medication:
			result = webGamesClientBundle.sacredObjects_medication();
			break;
		case sacredObjects_hand_sanitizer:
			result = webGamesClientBundle.sacredObjects_hand_sanitizer();
			break;
		case sacredObjects_document:
			result = webGamesClientBundle.sacredObjects_document();
			break;
		case sacredObjects_reform:
			result = webGamesClientBundle.sacredObjects_reform();
			break;
		case sacredObjects_bonus:
			result = webGamesClientBundle.sacredObjects_bonus();
			break;
		case sacredObjects_immigration_bill:
			result = webGamesClientBundle.sacredObjects_immigration_bill();
			break;
		case sacredObjects_gun_bill:
			result = webGamesClientBundle.sacredObjects_gun_bill();
			break;
		case sacredObjects_private_sector:
			result = webGamesClientBundle.sacredObjects_private_sector();
			break;
		default:
			throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getImage.");
		};

		return result;
	};


	public Image getImage() {

		final ImageResource imageResource = this.getImageResource();
		final String hoverHint = this.getDescription();

		final Image result = new Image(imageResource.getURL());
		result.setTitle(hoverHint);
		result.setWidth("100%");
		result.setHeight("100%");
		return result;
	};


	public Integer getPayoff(final AgentEnum agentEnum) {

		final Integer result;

		switch (agentEnum) {
			case counterpart: {
	
				switch (this) {
				case squiggle_1:
					result = 1;
					break;
				case squiggle_2:
					result = 2;
					break;
				case squiggle_3:
					result = 3;
					break;
				case squiggle_4:
					result = 4;
					break;
				case squiggle_5:
					result = 4;
					break;
				case squiggle_6:
					result = 4;
					break;
				case squiggle_7:
					result = 4;
					break;
				case squiggle_8:
					result = 4;
					break;
				case istockphoto_water_bottles:
					result = 10;
					break;
				case istockphoto_money_stack:
					result = 1;
					break;
				case istockphoto_tin_can:
					result = 5;
					break;
				case istockphoto_medication:
					result = 50;
					break;
				case sacredObjects_water_bottles:
					result = 10;
					break;
				case sacredObjects_money_stack:
					result = 1;
					break;
				case sacredObjects_hand_sanitizer:
					result = 1;
					break;
				case sacredObjects_tin_can:
					result = 5;
					break;
				case sacredObjects_medication:
					result = 50;
					break;
				case sacredObjects_document:
					result = 30;
					break;
				case sacredObjects_reform:
					result = 20;
					break;
				case sacredObjects_bonus:
					result = 10;
					break;
				case sacredObjects_immigration_bill:
					result = 30;
					break;
				case sacredObjects_gun_bill:
					result = 20;
					break;
				case sacredObjects_private_sector:
					result = 10;
					break;
				case blank:
					throw new IllegalStateException("Blank is not a true trading object: its worth to the counterpart should never be queried.");
				default:
					throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getPayoff.");
				};
			};
			break;
			
			case player: {
				switch (this) {
				case squiggle_1:
					result = 3;
					break;
				case squiggle_2:
					result = 3;
					break;
				case squiggle_3:
					result = 2;
					break;
				case squiggle_4:
					result = 2;
					break;
				case squiggle_5:
					result = 10;
					break;
				case squiggle_6:
					result = 0;
					break;
				case squiggle_7:
					result = 5;
					break;
				case squiggle_8:
					result = 15;
					break;
				case istockphoto_water_bottles:
					result = 5;
					break;
				case istockphoto_money_stack:
					result = 1;
					break;
				case istockphoto_tin_can:
					result = 10;
					break;
				case istockphoto_medication:
					result = 50;
					break;
				case sacredObjects_water_bottles:
					result = 5;
					break;
				case sacredObjects_money_stack:
					result = 1;
					break;
				case sacredObjects_hand_sanitizer:
					result = 1;
					break;
				case sacredObjects_tin_can:
					result = 10;
					break;
				case sacredObjects_medication:
					result = 50;
					break;
				case sacredObjects_document:
					result = 30;
					break;
				case sacredObjects_reform:
					result = 20;
					break;
				case sacredObjects_bonus:
					result = 10;
					break;
				case sacredObjects_immigration_bill:
					result = 30;
					break;
				case sacredObjects_gun_bill:
					result = 20;
					break;
				case sacredObjects_private_sector:
					result = 10;
					break;
				case blank:
					throw new IllegalStateException("Blank is not a true trading object: its worth to the player should never be queried.");
				default:
					throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getPayoff.");
				};
			};
			break;

			default:
				throw new IllegalStateException("Unhandled AgentEnum in TradingObjectEnum.getPayoff.");
		};

		return result;
	};

};
