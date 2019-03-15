package Overloaded.patches.relics;
import Overloaded.relics.one10Battery;
import com.megacrit.cardcrawl.actions.defect.*;
import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.powers.*;
import javassist.*;
import com.evacipated.cardcrawl.modthespire.lib.*;


@SpirePatches({ @SpirePatch(clz = DrawCardAction.class, method = "update"), @SpirePatch(clz = ScrapeAction.class, method = "update") })

public class one10BatteryPatch {
    @SpireInsertPatch(locator = Locator.class)
    public static void Insert(final AbstractGameAction self) {
        if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
            AbstractDungeon.player.getRelic(one10Battery.ID).flash();
            AbstractCard top;
            for(int i = 0; i<self.amount;i++) {
                top = AbstractDungeon.player.drawPile.getTopCard();
                AbstractDungeon.actionManager.addToBottom(new DiscardSpecificCardAction(top));
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(top.makeStatEquivalentCopy(), 1, true, true, false));
            }
        }
    }

    private static class Locator extends SpireInsertLocator
    {
        public int[] Locate(final CtBehavior ctMethodToPatch) throws Exception {
            final Matcher finalMatcher = (Matcher)new Matcher.MethodCallMatcher("com.megacrit.cardcrawl.characters.AbstractPlayer", "createHandIsFullDialog");
            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}