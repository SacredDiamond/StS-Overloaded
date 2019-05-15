package Overloaded.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public abstract class AbstractOverloadCard extends CustomCard {

    // Custom Abstract Cards can be a bit confusing. While this is a simple base for simply adding a second magic number,
    // if you're new to modding I suggest you skip this file until you know what unique things that aren't provided
    // by default, that you need in your own cards. For now, go check out the other cards.

    // In this example, we use a custom Abstract Card in order to define a new magic number. From here on out, we can
    // simply use that in our cards, so long as we put "extends AbstractOverloadCard" instead of "extends CustomCard" at the start.
    // In simple terms, it's for things that we don't want to define again and again in every single card we make.

    public int OtherMagicNumber;        // Just like magic number, or any number for that matter, we want our regular, modifiable stat
    public int BaseOtherMagicNumber;    // And our base stat - the number in it's base state. It will reset to that by default.
    public boolean upgradedOtherMagicNumber; // A boolean to check whether the number has been upgraded or not.
    public boolean isOtherMagicNumberModified; // A boolean to check whether the number has been modified or not, for coloring purposes. (red/green)
    public boolean canOverwrite;

    public AbstractOverloadCard(final String id, final String name, final String img, final int cost, final String rawDescription,
                                final CardType type, final CardColor color,
                                final CardRarity rarity, final CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);

        // Set all the things to their default values.
        isCostModified = false;
        isCostModifiedForTurn = false;
        isDamageModified = false;
        isBlockModified = false;
        isMagicNumberModified = false;
        isOtherMagicNumberModified = false;
        canOverwrite = false;
    }

    public void OverwriteCheck() {
        canOverwrite = (this.cost > EnergyPanel.totalCount);
    }

    public void displayUpgrades() { // Display the upgrade - when you click a card to upgrade it
        super.displayUpgrades();
        if (upgradedOtherMagicNumber) { // If we set upgradedOtherMagicNumber = true in our card.
            OtherMagicNumber = BaseOtherMagicNumber; // Show how the number changes, as out of combat, the base number of a card is shown.
            isOtherMagicNumberModified = true; // Modified = true, color it green to highlight that the number is being changed.
        }

    }

    

    public void upgradeDefaultSecondMagicNumber(int amount) { // If we're upgrading (read: changing) the number. Note "upgrade" and NOT "upgraded" - 2 different things. One is a boolean, and then this one is what you will usually use - change the integer by how much you want to upgrade.
        BaseOtherMagicNumber += amount; // Upgrade the number by the amount you provide in your card.
        OtherMagicNumber = BaseOtherMagicNumber; // Set the number to be equal to the base value.
        upgradedOtherMagicNumber = true; // Upgraded = true - which does what the above method does.
    }
          // AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(AbstractDungeon.player.drawPile.getTopCard(), 1, true, true, false)));


}