package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumMap;
import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public class PrespecifiedToughSteepSlopeStrategyFruits8 implements PlyRemainingIndexedProposalGenerator {

	public Proposal getPrespecifiedPotentialCounterproposal(final EnumSet<TradingObjectEnum> setOfTradingObjectEnum, final int plyRemaining) {

//		final int turnsRemaining = plyRemaining / 5;
		final int turnsRemaining = plyRemaining / 11;

		if (turnsRemaining <= 0) {
			final IllegalStateException e = new IllegalStateException("No potential counterproposal is possible without a positive number of turns remaining in the negotiation.");
			throw e;
		};

		final EnumMap<TradingObjectEnum, Integer> potentialCounterproposal = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);
		final int[] prespecifiedTradingObjectCounts;

		switch (turnsRemaining) {
		// fruits negotiation: 3 items each 
			case 1:
//				prespecifiedTradingObjectCounts = new int[]{2, 1, 2};	// item1(3), item2(4), item3(5) >> 1 2 3	(fruits1 set)
				prespecifiedTradingObjectCounts = new int[]{2, 2, 1};	// item1(3), item2(5), item3(4) >> 1 3 2	(fruits8 set = fruits4 set)
				break;
			case 2:
//				prespecifiedTradingObjectCounts = new int[]{2, 1, 2};
				prespecifiedTradingObjectCounts = new int[]{2, 2, 1};
				break;
			case 3:
//				prespecifiedTradingObjectCounts = new int[]{0, 3, 2};
				prespecifiedTradingObjectCounts = new int[]{0, 2, 3};
				break;
			case 4:
//				prespecifiedTradingObjectCounts = new int[]{2, 1, 3};
				prespecifiedTradingObjectCounts = new int[]{2, 3, 1};
				break;
			case 5:
//				prespecifiedTradingObjectCounts = new int[]{0, 3, 3};
				prespecifiedTradingObjectCounts = new int[]{0, 3, 3};
				break;
			case 6:
//				prespecifiedTradingObjectCounts = new int[]{3, 1, 3};
				prespecifiedTradingObjectCounts = new int[]{3, 3, 1};
				break;
			default:
//				prespecifiedTradingObjectCounts = new int[]{2, 2, 3};
				prespecifiedTradingObjectCounts = new int[]{2, 3, 2};
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
