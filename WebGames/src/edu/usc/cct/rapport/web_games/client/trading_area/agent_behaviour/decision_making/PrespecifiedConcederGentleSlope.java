package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumMap;
import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public class PrespecifiedConcederGentleSlope implements PlyRemainingIndexedProposalGenerator {

	public Proposal getPrespecifiedPotentialCounterproposal(final EnumSet<TradingObjectEnum> setOfTradingObjectEnum, final int plyRemaining) {

		final int turnsRemaining = plyRemaining / 2;
		if (turnsRemaining <= 0) {
			final IllegalStateException e = new IllegalStateException("No potential counterproposal is possible without a positive number of turns remaining in the negotiation.");
			throw e;
		};

		final EnumMap<TradingObjectEnum, Integer> potentialCounterproposal = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);
		final int[] prespecifiedTradingObjectCounts;
//[med,water,food, money]
//[med,water,food, hand sanitizer]
		switch (turnsRemaining) {
		case 1:
			prespecifiedTradingObjectCounts = new int[]{2, 1, 2, 1};
			break;
		case 2:
			prespecifiedTradingObjectCounts = new int[]{2, 1, 3, 3};
			break;
		case 3:
			prespecifiedTradingObjectCounts = new int[]{2, 2, 2, 3};
			break;
		case 4:
			prespecifiedTradingObjectCounts = new int[]{2, 2, 4, 3};
			break;
		case 5:
			prespecifiedTradingObjectCounts = new int[]{2, 3, 3, 3};
			break;
		case 6:
			prespecifiedTradingObjectCounts = new int[]{2, 3, 4, 4};
			break;
		case 7:
			prespecifiedTradingObjectCounts = new int[]{2, 3, 5, 5};
			break;
		case 8:
			prespecifiedTradingObjectCounts = new int[]{2, 4, 4, 4};
			break;
		case 9:
			prespecifiedTradingObjectCounts = new int[]{3, 2, 2, 2};
			break;
		case 10:
			prespecifiedTradingObjectCounts = new int[]{3, 3, 1, 1};
			break;
		case 11:
			prespecifiedTradingObjectCounts = new int[]{3, 3, 2, 2};
			break;
		default:
			prespecifiedTradingObjectCounts = new int[]{2, 4, 4, 4};
		};


		int tradingObjectCountIndex = 0;
		for (final TradingObjectEnum tradingObjectEnum: setOfTradingObjectEnum) {
			potentialCounterproposal.put(tradingObjectEnum, prespecifiedTradingObjectCounts[tradingObjectCountIndex]);
			++tradingObjectCountIndex;
		};

		final Proposal result = new Proposal(AgentEnum.counterpart, potentialCounterproposal);
		return result;
	};

};
