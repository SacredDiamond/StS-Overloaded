package Overloaded.relics;

import Overloaded.OverloadedBase;
import Overloaded.actions.LoadDrawAction;
import Overloaded.actions.newLoadDrawAction;
import basemod.BaseMod;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import Overloaded.util.TextureLoader;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static Overloaded.OverloadedBase.makeRelicOutlinePath;
import static Overloaded.OverloadedBase.makeRelicPath;

public class one10Battery extends CustomRelic {

    // ID, images, text.
    public static final String ID = OverloadedBase.makeID("one10Battery");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("placeholder_relic2.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic2.png"));

    public one10Battery() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.SOLID);
    }

    @Override
    public void atTurnStartPostDraw() {
        AbstractDungeon.actionManager.addToBottom(new newLoadDrawAction(1));
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
