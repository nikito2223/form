package form.content;

import arc.struct.Seq;
import mindustry.type.SectorPreset;
import mindustry.game.Objectives.*;
import mindustry.content.*;
import arc.struct.*;
import mindustry.type.*;

import static form.content.FormBlocks.*;
import static form.content.FormItems.*;
import static form.content.FormSectors.*;
import static mindustry.content.Items.*;
import static form.content.FormLiquid.*;
import static mindustry.content.TechTree.*;

public class MathurakTechTree {
    static IntSet balanced = new IntSet();

    public static void load() {

        FormPlanets.mathurak.techTree = nodeRoot("@planet.form-mathurak.name", coretomer, () -> {

            
            node(crusherdrill, () -> {
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
		
            node(lithiumConveyor, () -> {
                node(lithiumRouter, () -> {
					node(lithiumJunction, () -> {
							node(lithiumConveyorBridge, () -> {
								node(FormBlocks.launchomt,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
									node(FormBlocks.interplanetary,Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
								});
							});  
						});
					});
				});
            });
			
			node(FormBlocks.foidgroundFactory, Seq.with(new SectorComplete(FormSectors.lemans)), () -> {
				node(FormUnits.genrtor, () -> {	
					});
				node(FormUnits.herma, () -> {
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
						new Research(FormBlocks.foidgroundFactory)
						), () -> {
							
					});
                });
            });
            
            node(lithiumPump, () -> {
                 node(lithiumconduit, () -> {
					node(lithiumconduitrouter, () -> {
						node(lithiumBridge, () -> {	
				});
           });
	   });
	});

            nodeProduce(lithium, () -> {
                node(FormLiquid.distilledwater, () -> {
                    node(FormLiquid.fueloli);
            });
                nodeProduce(platinum, () -> nodeProduce(lead, () -> {
                    nodeProduce(graphite, () -> {
                        nodeProduce(silicon, () -> {});
                        });
                    }));
                });
            });
    }
}
