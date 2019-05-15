package Overloaded.cards;

import Overloaded.OverloadedBase;
import Overloaded.actions.LoadDrawAction;
import Overloaded.actions.newLoadDrawAction;
import Overloaded.characters.TheOverloaded;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Overloaded.OverloadedBase.makeCardPath;

public class Compile extends AbstractOverloadCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * Defend Gain 5 (8) block.
     */


    // TEXT DECLARATION

    public static final String ID = OverloadedBase.makeID("Compile");
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
    private static final int DRAW = 5;
    private static final int EXHAUST = 2;


    // /STAT DECLARATION/


    public Compile() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);

magicNumber = baseMagicNumber = DRAW;
OtherMagicNumber = BaseOtherMagicNumber = EXHAUST;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new newLoadDrawAction(magicNumber));
        AbstractDungeon.actionManager.addToBottom(new ExhaustAction(p, p, OtherMagicNumber, false));
    }

    //Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
            upgradeDefaultSecondMagicNumber(1);
            initializeDescription();
        }
    }
}
