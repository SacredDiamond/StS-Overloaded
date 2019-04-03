package Overloaded.actions;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class OneTenBatteryAction extends AbstractGameAction {

    public OneTenBatteryAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {


        for (int i = 0; i < amount; i++) {

           if (i < AbstractDungeon.player.drawPile.size()) {
                AbstractCard cardToDupe = AbstractDungeon.player.drawPile.getNCardFromTop(i);
                AbstractDungeon.player.drawPile.moveToDiscardPile(cardToDupe);
                AbstractDungeon.actionManager.addToTop(new MakeTempCardInDrawPileAction(cardToDupe, 1, true, true));
            }

        }

        isDone = true;
    }
}
