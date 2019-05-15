package Overloaded.actions;

import Overloaded.cards.AbstractOverloadCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class OverdrawAction extends AbstractGameAction {

    public OverdrawAction(int amount) {
        this.amount = amount;
    }
    public OverdrawAction() {
        this.amount = 1;
    }

    @Override
    public void update() {

                if (amount < AbstractDungeon.player.drawPile.size()) {
                    AbstractCard cardToDupe = AbstractDungeon.player.drawPile.getNCardFromTop(amount);

                    if(cardToDupe instanceof AbstractOverloadCard) {
                        AbstractOverloadCard Over = (AbstractOverloadCard)cardToDupe;
                        Over.onOverdraw();
                    }

                    AbstractDungeon.player.drawPile.moveToDiscardPile(cardToDupe);
                    AbstractDungeon.actionManager.addToTop(new MakeTempCardInDrawPileAction(cardToDupe, 1, true, true));
                }


        isDone = true;
    }
}
