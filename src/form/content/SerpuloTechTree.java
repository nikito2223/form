package form.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.SectorPresets;
import mindustry.content.TechTree.*;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;

public class SerpuloTechTree {
    public static void load() {
        newNode(FormBlocks.pyratitecrucible, Blocks.multiPress, Seq.with(new SectorComplete(FormSectors.deferhor)));
        newNode(FormBlocks.slagdrill, Blocks.waterExtractor, Seq.with(new SectorComplete(FormSectors.deferhor)));
        newNode(FormBlocks.smelterplantupdated, Blocks.melter, Seq.with(new SectorComplete(FormSectors.deferhor)));
        newNode(FormSectors.deferhor, SectorPresets.planetaryTerminal, Seq.with(new SectorComplete(SectorPresets.planetaryTerminal)));
    }

    private static void newNode(UnlockableContent content, UnlockableContent parent, Seq<Objective> objectives) {
        TechNode parentNode = parent.techNode;
        TechNode node = new TechNode(parentNode, content, content.researchRequirements());
        if (objectives != null) node.objectives = objectives;
    }
}
