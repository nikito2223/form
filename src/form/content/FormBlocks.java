package form.content;

import mindustry.content.*;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import form.audio.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static form.content.FormItems.*;
import static mindustry.Vars.*;
import static form.content.FormUnits.*;
import static form.content.FormLiquid.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.type.ItemStack.*;

public class
FormBlocks {
    public static Block
    //crafting
    pyratitecrucible, smelterplantupdated, siliconarcburners, coalpress, graphitepress, AirFiliter,
    //production
    slagdrill, crusherdrill, clippers,
    //distribution
    projectormoto,
    //liquids
    lithiumPump, lithiumconduit, lithiumconduitrouter, lithiumBridge,
    //power
    gannerSolarPanel, powerGerm,
    //turrets
    destroyers, foremdow, nedour,
    //defense
    lithiumConveyor, lithiumRouter, lithiumJunction, lithiumConveyorBridge,
    //environment & ores
    oreLithium, sleepingBlue, sleepingblueWall, darkBlueSand, distilledwater, fueloli, wallOrelithium, orePlatinum, blueBoulder, orerubyGreen, pinksand, redstone,
    //units
    foidgroundFactory,
    //storage
    coretomer,
    //special
	
    //sampenat
    launchomt, interplanetary,
    //walls
    lithiumWall, lithiumWallLarge, lithiumWallHuge;

    public static void load() {

        
        //endregion
        //region crafting
        pyratitecrucible = new GenericCrafter("pyratite-crucible"){{
            scaledHealth = 40;
            size = 3;
            craftTime = 120f;
            itemCapacity = 55;
            consumePower(8f);
            updateEffect = Fx.plasticburn;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            consumeLiquid(Liquids.water, 0.1f);
            consumeItems(with(sand, 20, lead, 15, coal, 20));
            outputItems = with(pyratite, 8);
            requirements(Category.crafting, with(lead, 360, copper, 300, silicon, 50));
        }};
		AirFiliter = new GenericCrafter("air-filiter"){{
            scaledHealth = 440;
            size = 4;
            craftTime = 120f;
            itemCapacity = 16;
            consumePower(8f);
            updateEffect = Fx.plasticburn;
            hasLiquids = true;
            consumeLiquid(carbondioxide, 0.8f);
            consumeItems(with(coal, 8));
            outputLiquid = new LiquidStack(FormLiquid.air, 0.8f);
            requirements(Category.crafting, with(FormItems.lithium, 30, silicon, 50));
        }};
        smelterplantupdated = new GenericCrafter("smelter-plant-updated") {{
            health = 140;
            liquidCapacity = 10;
            size = 3;
            hasPower = true;
            itemCapacity = 10;
            hasLiquids = true;
            hasItems = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawDefault());
            craftTime = 80;
            updateEffect = Fx.plasticburn;
            consumePower(3.2f);
            consumeItems(ItemStack.with(Items.scrap, 5));
            requirements(Category.crafting, ItemStack.with(Items.silicon, 15, Items.lead, 15, Items.graphite, 15));
            outputLiquid = new LiquidStack(Liquids.slag, 18f / 60f);
        }};
        siliconarcburners = new GenericCrafter("silicon-arc-burners"){{
            scaledHealth = 40;
            size = 3;
            craftTime = 120f;
            itemCapacity = 100;
            consumePower(8f);
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            consumeItems(with(sand, 20, coal, 20));
            outputItems = with(silicon, 3);
            requirements(Category.crafting, with(lithium, 50, graphite, 50));
        }};
            coalpress = new GenericCrafter("coal-press"){{
            requirements(Category.crafting, with(FormItems.lithium, 20));
            craftEffect = Fx.coalSmeltsmoke;
            outputItem = new ItemStack(Items.coal, 4);
            craftTime = 20f;
            size = 2;
            hasPower = hasItems = hasLiquids = true;
            rotateDraw = false;

            consumeLiquid(FormLiquid.fueloli, 0.1f);
            consumePower(0.7f);
        }};
        graphitepress = new GenericCrafter("graphite-press"){{
            scaledHealth = 40;
            size = 2;
            craftTime = 30f;
            itemCapacity = 40;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            consumeItems(with(coal, 15));
            outputItems = with(graphite, 2);
            requirements(Category.crafting, with(lithium, 70));
        }};
		//endCrafting
		
		//production
			slagdrill = new SolidPump("slag-drill"){{
            requirements(Category.production, with(Items.metaglass, 30, Items.graphite, 30, Items.lead, 30, Items.copper, 30));
            result = Liquids.slag;
            pumpAmount = 0.11f;
            size = 2;
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                spinSprite = true;
                rotateSpeed = 2f;
            }}, new DrawRegion("-top"));
            attribute = Attribute.heat;
            liquidCapacity = 10f;
            rotateSpeed = 1.4f;

            consumePower(1.5f);
        }};
			crusherdrill = new Drill("crusher-drill"){{
            requirements(Category.production, with(FormItems.lithium, 18));
            tier = 8;
            drillTime = 180f;
            size = 2;
			itemCapacity = 20;

            consumeLiquid(FormLiquid.distilledwater, 0.25f / 180f).boost();
        }};
			clippers = new BeamDrill("clippers"){{
            requirements(Category.production, with(FormItems.lithium, 40));
            consumePower(0.15f);

            drillTime = 350f;
            tier = 3;
            size = 2;
            range = 5;
            fogRadius = 5;
            researchCost = with(FormItems.lithium, 10);

            consumeLiquid(FormLiquid.distilledwater, 0.25f / 60f).boost();
        }};
		//endProduction
		
		//distribution
		projectormoto = new ForceProjector("projector-moto")
		{{
            requirements(Category.effect, with(FormItems.platinum, 175, FormItems.lithium, 15));
            size = 3;
            sides = 10;
            phaseRadiusBoost = 30f;
            radius = 130.7f;
            shieldHealth = 750f;
            cooldownNormal = 1.5f;
            cooldownLiquid = 1.2f;
            cooldownBrokenBase = 0.35f;

            itemConsumer = consumeItem(FormItems.lithium).boost();
            consumePower(4f);
        }};
		//endDistribution
		
		//liquid
			lithiumPump = new Pump("lithium-pump"){{
            requirements(Category.liquid, with(FormItems.lithium, 10));
            pumpAmount = 0.40f;
            liquidCapacity = 40f;
            size = 2;
        }};
			lithiumconduit = new Conduit("lithium-conduit"){{
            requirements(Category.liquid, with(FormItems.lithium, 1));
            health = 60;
            liquidCapacity = 17f;
            liquidPressure = 1.123f;
        }};
			lithiumconduitrouter = new LiquidRouter("lithium-conduit-router"){{
            requirements(Category.liquid, with(FormItems.lithium, 4));
            liquidCapacity = 20f;
            underBullets = true;
			size = 1;
            solid = false;
        }};
			lithiumBridge = new LiquidBridge("lithium-Bridge"){{
            requirements(Category.liquid, with(FormItems.lithium, 4, Items.graphite, 8));
            fadeIn = moveArrows = false;
            arrowSpacing = 6f;
            range = 6;
            hasPower = false;
        }};
		//endLiquids
		
		//power
		gannerSolarPanel = new SolarGenerator("genner-panel-large"){{
            requirements(Category.power, with(FormItems.lithium, 80));
            size = 4;
            powerProduction = 5.3f;
        }};
			powerGerm = new PowerNode("power-germ"){{
            requirements(Category.power, with(FormItems.lithium, 1, Items.graphite, 3));
            maxNodes = 15;
            laserRange = 8f;
        }};
		//endPower
		
		//turrets
			destroyers = new ItemTurret("destroyers"){{
            requirements(Category.turret, with(Items.silicon, 900, FormItems.lithium, 300, Items.graphite, 250));
            ammo(
                Items.graphite, new BasicBulletType(7.5f, 50){{
                    hitSize = 5.8f;
                    width = 15f;
                    height = 21f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 4;
                    reloadMultiplier = 2.7f;
                    knockback = 0.3f;
                }},
                FormItems.lithium, new BasicBulletType(8.5f, 50){{
                    hitSize =  7.8f;
                    width = 15f;
                    height = 40f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 5;
                    hitEffect = Fx.blastExplosion;
                    status = StatusEffects.burning;
                    reloadMultiplier = 3.7f;
                    knockback = 1.3f;
                }}
            );
            reload = 2f;
            recoilTime = reload * 1f;
            ammoUseEffect = Fx.casing3;
            range = 230f;
            inaccuracy = 3f;
            shootCone = 35f;
            scaledHealth = 200;
            shootSound = Sounds.shootSnap;
            recoil = 3f;
            shake = 2f;
            size = 4;
            shootSound = Sounds.shootBig;
			coolant = consumeCoolant(0.1f);
            scaledHealth = 160;
            coolant = consumeCoolant(0.20f);

            limitRange();
        }};
			foremdow = new ItemTurret("foremdow"){{
            requirements(Category.turret, with(FormItems.lithium, 40, Items.graphite, 17));
            ammo(
                Items.graphite, new ArtilleryBulletType(3f, 20){{
                    knockback = 0.8f;
                    lifetime = 10f;
                    width = height = 11f;
                    collidesAir = true;
                    collidesTiles = false;
                    ammoMultiplier = 3;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                }},
                Items.silicon, new ArtilleryBulletType(3f, 20){{
                    knockback = 0.8f;
                    lifetime = 10f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                    collidesAir = true;
                    ammoMultiplier = 6;
                    reloadMultiplier = 1.2f;
                    ammoMultiplier = 3f;
                    homingPower = 0.08f;
                    homingRange = 50f;
                }},
                FormItems.lithium, new ArtilleryBulletType(3f, 45){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.8f;
                    lifetime = 10f;
                    width = height = 13f;
                    collidesAir = true;
                    collidesTiles = true;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 70f;
                    status = StatusEffects.burning;
                    ammoMultiplier = 8;
                    statusDuration = 60f * 12f;
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    makeFire = true;
                    trailEffect = Fx.incendTrail;
                    ammoMultiplier = 4f;
                }}
            );
            reload = 5f;
            recoil = 2f;
            range = 130f;
            size = 2;
            shoot.shotDelay = 5f;
            shoot.shots = 2;
            rotateSpeed = 15f;
            inaccuracy = 17f;
            shootCone = 10f;
            health = 260;
            shootSound = FormSounds.pule;
            coolant = consumeCoolant(0.1f);
            limitRange(0f);
        }};
		    nedour = new LiquidTurret("nedour"){{
            requirements(Category.turret, with(FormItems.lithium, 100, FormItems.platinum, 50, Items.graphite, 30));
            ammo(
                FormLiquid.distilledwater, new LiquidBulletType(FormLiquid.distilledwater){{
                    lifetime = 49f;
                    speed = 8f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.3f;
                }},
                FormLiquid.fueloli, new LiquidBulletType(FormLiquid.fueloli){{
                    lifetime = 49f;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.2f;
                    layer = Layer.bullet - 2f;
                }}
            );
            size = 4;
            reload = 4f;
            shoot.shots = 2;
            velocityRnd = 0.1f;
            inaccuracy = 4f;
            recoil = 3f;
            shootCone = 45f;
            liquidCapacity = 60f;
            shootEffect = Fx.shootLiquid;
            range = 210f;
            scaledHealth = 2500;
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
        }};

		//endTurret
		
		//defense
			lithiumConveyor = new Conveyor("lithium-conveyor"){{
            requirements(Category.distribution, with(FormItems.lithium, 1));
            health = 65;
            speed = 0.10f;
            displayedSpeed = 10f;
        }};
			lithiumRouter = new Router("lithium-router"){{
            requirements(Category.distribution, with(FormItems.lithium, 3));
            buildCostMultiplier = 4f;
        }};
			lithiumConveyorBridge = new BufferedItemBridge("lithium-Conveyor-Bridge"){{
            requirements(Category.distribution, with(FormItems.lithium, 6));
            fadeIn = moveArrows = false;
            range = 6;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
			}};
			lithiumJunction = new Junction("lithium-Junction"){{
            requirements(Category.distribution, with(FormItems.lithium, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
        }};
		//endDefense
		
		//environment & ores
		darkBlueSand = new Floor("dark-blue-sand") {{
            itemDrop = Items.sand;
            attributes.set(Attribute.oil, -0.25f);
            mapColor = Color.valueOf("999999");
        }};
        pinksand = new Floor("pink-sand") {{
            itemDrop = Items.sand;
            mapColor = Color.valueOf("8664f4");
        }};
        redstone = new Floor("red-stone") {{
            mapColor = Color.valueOf("cc7a6a");
        }};
			oreLithium = new OreBlock("ore-lithium", FormItems.lithium){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            mapColor = Color.valueOf("4d59a1");
        }};
		orePlatinum = new OreBlock("ore-platinum", FormItems.platinum){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            mapColor = Color.valueOf("6dd7d1");
		}};
		orerubyGreen = new OreBlock("ore-ruby-Green", FormItems.rubyGreen){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            mapColor = Color.valueOf("6dd7d1");
        }};
		sleepingblueWall = new StaticWall("sleeping-blue-wall"){
        };
		sleepingBlue = new Floor("sleeping-blue"){{
            variants = 3;
            attributes.set(Attribute.water, 0.40f);
            attributes.set(Attribute.heat, -0.50f);
        }};
		distilledwater = new Floor("pooled-distilledwater"){{
            drownTime = 150f;
            status = StatusEffects.freezing;
            statusDuration = 240f;
            speedMultiplier = 0.5f;
            variants = 0;
            liquidDrop = FormLiquid.distilledwater;
            liquidMultiplier = 0.5f;
            isLiquid = true;
			mapColor = Color.valueOf("296635");

            emitLight = true;
            lightRadius = 25f;
            lightColor = Color.cyan.cpy().a(0.19f);
        }};
		fueloli = new Floor("pooled-fueloli"){{
            drownTime = 150f;
            status = StatusEffects.burning;
            statusDuration = 240f;
            speedMultiplier = 0.5f;
            variants = 0;
            liquidDrop = FormLiquid.fueloli;
            liquidMultiplier = 0.5f;
            isLiquid = true;

            emitLight = true;
            lightRadius = 25f;
            lightColor = Color.cyan.cpy().a(0.19f);
        }};
		wallOrelithium = new OreBlock("ore-wall-lithium", FormItems.lithium){{
            wallOre = true;
        }};
		blueBoulder = new Prop("blue-Boulder"){{
            variants = 2;
            sleepingBlue.asFloor().decoration = darkBlueSand.asFloor().decoration = this;
        }};
		//Endenvironment
		
		//units
			foidgroundFactory = new UnitFactory("Foid-ground-factory"){{
            scaledHealth = 120;
            size = 3;
            consumePower(3f);
            requirements(Category.units, with(FormItems.lithium, 100, silicon, 75));
            plans.add(
                new UnitPlan(FormUnits.genrtor, 20f * 15, with(FormItems.lithium, 10, silicon, 10)),
				new UnitPlan(FormUnits.herma, 20f * 15, with(FormItems.lithium, 10, silicon, 10))
            );
        }};
		//endUnits
		
		//storage
		coretomer = new CoreBlock("core-tomer"){{
            requirements(Category.effect, with(FormItems.lithium, 1200, FormItems.platinum, 700));
            alwaysUnlocked = true;
            size = 4;
            health = 18000;
            itemCapacity = 8000;
            unitType = FormUnits.arom;
        }};
		//endStorage
		
		//sampenat
			launchomt = new LaunchPad("launch-otm"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(FormItems.lithium, 40, Items.silicon, 140));
            size = 3;
            itemCapacity = 200;
            launchTime = 60f * 20;
            hasPower = true;
            consumePower(4f);
        }};
		interplanetary = new Accelerator("interplanetary"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(FormItems.lithium, 18000, Items.silicon, 11000, FormItems.platinum, 13000));
            researchCostMultiplier = 0.1f;
            size = 7;
            hasPower = true;
            consumePower(100f);
            buildCostMultiplier = 0.5f;
            scaledHealth = 80;
        }};
		//endSampenat
		
		//walls
			lithiumWall = new Wall("lithium-wall"){{
            scaledHealth = 800;
            size = 1;
            requirements(Category.defense, with(lithium, 6));
        }};
			lithiumWallLarge = new Wall("lithium-wall-large"){{
            scaledHealth = 1600;
            size = 2;
            requirements(Category.defense, with(lithium, 24));
        }};
			lithiumWallHuge = new Wall("lithium-wall-Huge"){{
            scaledHealth = 2200;
            size = 3;
            requirements(Category.defense, with(lithium, 48));
        }};
		//endWalls
		
    }
}
