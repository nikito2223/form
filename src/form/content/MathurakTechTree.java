package form.content;

import arc.struct.Seq;
import mindustry.game.Objectives.*;
import arc.struct.*;

import static form.content.FormBlocks.*;
import static form.content.FormItems.*;
import static mindustry.content.Items.*;
import static mindustry.content.TechTree.*;

public class MathurakTechTree {
    static IntSet balanced = new IntSet();

    public static void load() {

        FormPlanets.mathurak.techTree = nodeRoot("@planet.form-mathurak.name", coretomer, () -> {
		
            node(lithiumDuct, () -> {
                node(lithiumRouter, () -> {
					node(lithiumJunction, () -> {
							node(lithiumBridgeItem, () -> {
								node(FormBlocks.launchomt,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
									node(FormBlocks.interplanetary,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
								});
							});  
						});
					});
				});
            });
            
            node(crusherdrill, () -> { 
                node(lithiumPump, () -> {
                 node(lithiumconduit, () -> {
                    node(lithiumconduitrouter, () -> {
                        node(lithiumBridgeLiquid, () -> {   
                });
           });
       });
    });
                node(coalpress, () -> {
                    node(graphitepress, () -> {
                        node(siliconarcburners, Seq.with(
                            new SectorComplete(FormSectors.lemans),
                            new Research(graphitepress),
                            new Research(FormItems.lithium)
                        ), () -> {
                            
                    });
                });
            });         
                    node(gannerSolarPanel,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
                        node(powerGerm,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
                            node(projectormoto,Seq.with(new SectorComplete(FormSectors.konota)), () -> {
                        
                    });
                });
            });
        });
			
			node(FormBlocks.spiderFactory, Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
				node(FormUnits.genrtor, () -> {	
                });
				node(FormUnits.herma, () -> { 
                });
                node(FormUnits.mover, Seq.with(new Research(spiderReconstructor)),  () -> { 
                });
                node(FormBlocks.spiderReconstructor, Seq.with(new SectorComplete(FormSectors.konota)), () -> {

                });
			});
		 
            node(foremdow, () -> {
                node(lithiumWall, () -> {
                node(lithiumWallLarge, () -> {
                    node(lithiumWallHuge, () -> {

                 });
            });
        });
                node(FormBlocks.destroyers,Seq.with(new SectorComplete(FormSectors.konota)), ()-> {});

            });
         node(FormSectors.start, () -> {
            node(FormSectors.lemans, () -> {
                node(FormSectors.konota,Seq.with(
                    new SectorComplete(FormSectors.lemans),
                    new Research(FormItems.lithium),
                    new Research(graphitepress),
                    new Research(coalpress),
                    new Research(siliconarcburners)
                    ), () -> {
						node(FormSectors.imposmor,Seq.with(
						new SectorComplete(FormSectors.konota),
						new Research(FormBlocks.spiderFactory)
						), () -> {
							
					});
                });
            });
        });

            nodeProduce(lithium, () -> {
                node(FormLiquid.distilledwater, () -> {
                    node(FormLiquid.fueloli);
            });
                nodeProduce(platinum, () -> 
                    nodeProduce(coal, () -> {
                        nodeProduce(graphite, () -> {
                            nodeProduce(silicon, () -> {});
                        });
                    }));
                });
            });

    }
}
