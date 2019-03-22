package Overloaded.patches.relics;

import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
import com.evacipated.cardcrawl.modthespire.lib.Matcher;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.defect.ScrapeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;

import Overloaded.relics.one10Battery;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDiscardEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect;
import javassist.CtBehavior;

import java.util.logging.Logger;

import static Overloaded.OverloadedBase.logger;

@SpirePatch(
        clz = DrawCardAction.class,
        method = "update"
)
@SpirePatch(
        clz = ScrapeAction.class,
        method = "update"
)
public class one10BatteryPatch {


    @SpireInsertPatch(locator = Locator.class)
    public static void Insert(AbstractGameAction self) {

        if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
            AbstractDungeon.player.getRelic(one10Battery.ID).flash();

        }

    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher("com.megacrit.cardcrawl.characters.AbstractPlayer", "createHandIsFullDialog");
            return LineFinder.findAllInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}

