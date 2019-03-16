package Overloaded.cards;

import Overloaded.OverloadedBase;
import Overloaded.characters.TheOverloaded;
import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static Overloaded.OverloadedBase.makeCardPath;

public class RechargeableDefend extends AbstractOverloadCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * Defend Gain 5 (8) block.
     */


    // TEXT DECLARATION

    public static final String ID = OverloadedBase.makeID("RechargeableDefend");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Skill.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheOverloaded.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int BLOCK = 10;
    private static final int UPGRADE_PLUS_BLOCK = 4;


    // /STAT DECLARATION/


    @Override
    public void applyPowers() {
        super.applyPowers();

        OverwriteCheck();
        if((canOverwrite) || costForTurn > EnergyPanel.totalCount){
            setCostForTurn(0);
        }else {
            setCostForTurn(cost);
        }

    }

    public RechargeableDefend() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
       block = baseBlock = BLOCK;

        this.tags.add(BaseModCardTags.BASIC_DEFEND); //Tag your strike, defend and form cards so that they work correctly.
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
       OverwriteCheck();
        if((canOverwrite) || cost > EnergyPanel.totalCount){
            AbstractDungeon.actionManager.addToBottom(new ExhaustAction(p, p, 1, false));
        }

            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));

    }
    //Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
            initializeDescription();
        }
    }
}
