package form.content;

import arc.graphics.*;
import form.maps.generators.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.content.Planets.*;
import static form.content.FormItems.*;


public class FormPlanets{

    public static Planet
        /* planets */ mathurak, satellite,
		/*star*/ sakeru, sapuke;

    public static void load() {
        

        sakeru = new Planet("sakeru", Planets.sun, 3f, 2){{
            bloom = true;
			solarSystem = this;
			drawOrbit = false;
            accessible = false;
			lightColor = Color.valueOf("61b3f1");
            orbitRadius = 1000;
			hasAtmosphere = true;
            meshLoader = () -> new SunMesh(
                    this, 6,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("4e4bde"),
                    Color.valueOf("1a17e3"),
                    Color.valueOf("2f2bff"),
                    Color.valueOf("2f2bff")
					);
        }};
        sapuke = new Planet("sapuke", sakeru, 2f, 0){{
            bloom = true;
            solarSystem = this;
            drawOrbit = false;
            accessible = false;
            lightColor = Color.valueOf("1c911a");
            hasAtmosphere = true;
            orbitRadius = 50f;
            meshLoader = () -> new SunMesh(
                    this, 9,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("fce46d"),
                    Color.valueOf("e8d576"),
                    Color.valueOf("d4b208"),
                    Color.valueOf("fff0a6")
					);

        }};
        satellite = new Planet("satellite", sapuke, 1f, 2) {{
            generator = new SatellitePlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
			defaultCore = FormBlocks.coretomer;
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 7, 0.1f, 0.28f, 5, Color.valueOf("efefef").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                new HexSkyMesh(this, 8, 0.2f, 0.23f, 5, Color.valueOf("afafaf").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                new HexSkyMesh(this, 9, 0.3f, 0.32f, 5, Color.valueOf("ffffff").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                new HexSkyMesh(this, 0, 0.3f, 0.32f, 5, Color.valueOf("cbcbcb").a(0.55f), 4, 0.35f, 1.35f, 0.45f)
            );
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.4f;
            orbitRadius = 30f;
            iconColor = Color.valueOf("b53a14");
            atmosphereColor = Color.valueOf("b53a14");
            alwaysUnlocked = true;
            startSector = 12;
            solarSystem = sapuke;
            ruleSetter = r -> {
                r.fog = true;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
            };
            landCloudColor = Pal.spore.cpy().a(0.5f);
        }};
        mathurak = new Planet("mathurak", sakeru, 1f, 3) {{
            generator = new MathurakPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 7);
            defaultCore = FormBlocks.coretomer;
            cloudMeshLoader = () -> new MultiMesh(
                    
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("828282").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                    new HexSkyMesh(this, 2, 0.3f, 0.32f, 6, Color.valueOf("7a7a7a").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                    new HexSkyMesh(this, 2, 0.3f, 0.32f, 5, Color.valueOf("b9baba").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                    new HexSkyMesh(this, 7, 0.1f, 0.28f, 8, Color.valueOf("7a7a7a").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 3, Color.valueOf("383838").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                    new HexSkyMesh(this, 8, 0.2f, 0.23f, 9, Color.valueOf("7a7a7a").a(0.65f), 3, 0.25f, 1.22f, 0.45f)
                );
            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            orbitRadius = 60f;
            allowLaunchLoadout = false;
            solarSystem = sakeru;
            landCloudColor = Color.valueOf("41b9ec");
            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = FormTeam.sievers;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };
            iconColor = Color.valueOf("4d6aff");
            atmosphereColor = Color.valueOf("002b64");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            defaultAttributes.set(FormAttributes.windPower, 0.8f);
            unlockedOnLand.add(FormBlocks.coretomer);
        }};


        /*Asteroid = new makAsteroid("Asteroid", sakeru, 1f, 3) {{
            
        }};*/


        //planeta sun
              //vanilla planets 
            serpulo.hiddenItems.addAll(mathurakItems).removeAll(Items.serpuloItems);
            erekir.hiddenItems.addAll(mathurakItems).removeAll(Items.erekirItems);

            // mod planets
           mathurak.hiddenItems.addAll(Vars.content.items()).removeAll(mathurakItems);
		   satellite.hiddenItems.addAll(Vars.content.items()).removeAll(mathurakItems);

    }
}
