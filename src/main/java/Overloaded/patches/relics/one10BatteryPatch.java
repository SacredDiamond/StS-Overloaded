package Overloaded.patches.relics;

import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
import com.evacipated.cardcrawl.modthespire.lib.Matcher;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.defect.ScrapeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;

import Overloaded.relics.one10Battery;
import javassist.CtBehavior;

import java.util.logging.Logger;

import static Overloaded.OverloadedBase.logger;

@SpirePatch(clz = DrawCardAction.class, method = "update")
@SpirePatch(clz = ScrapeAction.class, method = "update")
public class one10BatteryPatch {


    @SpireInsertPatch(locator = Locator.class)
    public static void Insert(AbstractGameAction self) {
        if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
            AbstractDungeon.player.getRelic(one10Battery.ID).flash();

            logger.info("player has 110% battery? | " + AbstractDungeon.player.hasRelic(one10Battery.ID) );
            logger.info("what is self? | " + self);
            logger.info("how much is self.amount? | " + self.amount);

            if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
                AbstractDungeon.player.getRelic(one10Battery.ID).flash();
                AbstractCard top;

                logger.info("-.-.-.- entering loop -.-.-.-.-");
                for(int i = 0; i<self.amount;i++) {
                    logger.info("what is self? | " + self);
                    logger.info("how much is self.amount? | " + self.amount);
                    logger.info("what is i? | " + i);

                    top = AbstractDungeon.player.drawPile.getTopCard();
                    logger.info("what is the top card of the deck? | " + top);

                    AbstractDungeon.actionManager.addToBottom(new DiscardSpecificCardAction(top, AbstractDungeon.player.drawPile));
                    AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(top.makeStatEquivalentCopy(), 1, true, true, false));
                }

                logger.info("player has 110% battery? | " + AbstractDungeon.player.hasRelic(one10Battery.ID) );
                logger.info("what is self? | " + self);
                logger.info("how much is self.amount? | " + self.amount);
            }

        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher("com.megacrit.cardcrawl.characters.AbstractPlayer", "createHandIsFullDialog");
            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}

/*
        logger.info("player has 110% battery? | " + AbstractDungeon.player.hasRelic(one10Battery.ID) );
        logger.info("what is self? | " + self);
        logger.info("how much is self.amount? | " + self.amount);

        if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
            AbstractDungeon.player.getRelic(one10Battery.ID).flash();
            AbstractCard top;

            logger.info("-.-.-.- entering loop -.-.-.-.-");
            for(int i = 0; i<self.amount;i++) {
                logger.info("what is self? | " + self);
                logger.info("how much is self.amount? | " + self.amount);
                logger.info("what is i? | " + i);

                top = AbstractDungeon.player.drawPile.getTopCard();
                logger.info("what is the top card of the deck? | " + top);

                AbstractDungeon.actionManager.addToBottom(new DiscardSpecificCardAction(top, AbstractDungeon.player.drawPile));
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(top.makeStatEquivalentCopy(), 1, true, true, false));
            }

            logger.info("player has 110% battery? | " + AbstractDungeon.player.hasRelic(one10Battery.ID) );
            logger.info("what is self? | " + self);
            logger.info("how much is self.amount? | " + self.amount);
        }
 */