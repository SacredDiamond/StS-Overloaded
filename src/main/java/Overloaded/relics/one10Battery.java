package Overloaded.relics;

import Overloaded.OverloadedBase;
import basemod.BaseMod;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import Overloaded.util.TextureLoader;
import Overloaded.patches.relics.one10BatteryPatch;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static Overloaded.OverloadedBase.makeRelicOutlinePath;
import static Overloaded.OverloadedBase.makeRelicPath;

public class one10Battery extends CustomRelic {
    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * At the start of each combat, gain 1 Strength (i.e. Vajra)
     */

    // ID, images, text.
    public static final String ID = OverloadedBase.makeID("one10Battery");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("placeholder_relic2.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic2.png"));

    public one10Battery() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.SOLID);
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new one10Battery();
    }

}
