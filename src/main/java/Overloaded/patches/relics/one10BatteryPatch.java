package Overloaded.patches.relics;

/*

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
    public static void Insert(AbstractGameAction __instance) {
        if (AbstractDungeon.player.hasRelic(one10Battery.ID)) {
            AbstractDungeon.player.getRelic(one10Battery.ID).flash();

            AbstractDungeon.actionManager.addToTop(new LoadDrawAction(__instance.amount));

            if((AbstractDungeon.player.drawPile.size() < __instance.amount) &&(AbstractDungeon.player.discardPile.size() > 0) ){

                AbstractDungeon.actionManager.addToTop(new EmptyDeckShuffleAction());
                AbstractDungeon.actionManager.addToTop(new ShuffleAction(AbstractDungeon.player.drawPile, false));
            }

          //  __instance.isDone = true;
          //  return SpireReturn.Return(null);
        }
      //  return SpireReturn.Continue();
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(AbstractPlayer.class, "createHandIsFullDialog");
            return LineFinder.findAllInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}

*/