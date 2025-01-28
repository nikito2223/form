package form.content;

import arc.math.*;
import arc.math.geom.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.Graphics.*;
import arc.Graphics.Cursor.*;
import arc.struct.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import arc.util.io.*;

import mindustry.entities.pattern.ShootSpread;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.gen.*;
import mindustry.graphics.*; 
import form.graphics.*; 
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.units.*;
import form.audio.*;
import arc.audio.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import form.world.blocks.campaign.*;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.logic.*;
import mindustry.ui.*;

//Import static
import static form.content.FormItems.*;
import static form.content.FormLiquid.*;
import static mindustry.content.Items.*;
import static mindustry.type.ItemStack.*;

import form.world.blocks.defense.turrets.*;

public class FormBlocks {
    public static Block 
    //crafting
    pyratitecrucible, smelterplantupdated, siliconarcburners, coalpress, graphitepress, airFiliter, vanadiaSmelter,
    //production
    slagdrill, crusherdrill, clippers, acidDrill,
    //distribution
    projectormoto,
    //liquids
    lithiumPump, lithiumconduit, lithiumconduitrouter, lithiumBridgeLiquid,
    //power
    gannerSolarPanel, powerGerm, battaryLithium,
    //turrets
    destroyers, foremdow, shower, dugasteret, tesla, acidGun, frezeeningIncinerator,
    //defense
    lithiumDuct, lithiumRouter, lithiumJunction, lithiumBridgeItem,
    //environment & ores
    oreLithium, darkblueStone, darkblueStoneWall, darkBlueSand, darkBlueSandWall, distilledwater, fueloli, wallOrelithium, orePlatinum, blueBoulder, orerhodium, pinksand, redstone, darkblueSandDistilledWater, deepDistilledwater, lava, pinksandWall,
    //units
    spiderFactory, spiderReconstructor,
    //storage
    coreCaser,
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
		airFiliter = new GenericCrafter("air-filiter"){{
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
            consumeItems(with(coal, 15));
            outputItems = with(graphite, 2);
            requirements(Category.crafting, with(lithium, 70));
        }};
        vanadiaSmelter = new GenericCrafter("vanadia-smelter"){{
            scaledHealth = 60;
            size = 2;
            craftTime = 20f;
            itemCapacity = 40;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            consumeItems(with(lithium, 10, coal, 20));
            outputItems = with(vanadium, 1);
            requirements(Category.crafting, with(lithium, 30, graphite, 30));
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
            requirements(Category.production, with(FormItems.lithium, 20));
            tier = 8;
            drillTime = 180f;
            size = 2;
			itemCapacity = 20;
            researchCost = with(FormItems.lithium, 20);
            consumeLiquid(FormLiquid.distilledwater, 0.25f / 180f).boost();
        }};
        acidDrill = new Drill("acid-drill"){{
            requirements(Category.production, with(FormItems.lithium, 90, FormItems.platinum, 40, Items.silicon, 120));
            tier = 9;
            drillTime = 180f;
            size = 2;
            itemCapacity = 20;
            researchCost = with(FormItems.lithium, 90, FormItems.platinum, 40, Items.silicon, 120);
            consumeLiquid(FormLiquid.acid, 0.20f / 60f);
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
            sides = 15;
            phaseRadiusBoost = 30f;
            radius = 153.3f;
            shieldHealth = 1375f;
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
			lithiumBridgeLiquid = new LiquidBridge("lithium-bridge-liquids"){{
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
            powerProduction = 3.3f;
        }};
			powerGerm = new BeamNode("power-germ"){{
            requirements(Category.power, with(FormItems.lithium, 10));
            consumesPower = outputsPower = true;
            health = 180;
            range = 15;
            fogRadius = 1;
            researchCost = with(FormItems.lithium, 7);

            consumePowerBuffered(2500f);
        }};
        battaryLithium = new Battery("battary-lithium"){{
            requirements(Category.power, with(FormItems.platinum, 20, FormItems.lithium, 50, Items.silicon, 30));
            size = 2;
            emptyLightColor = Color.valueOf("6784ff");
            fullLightColor = Color.valueOf("67fbd2");
            consumePowerBuffered(30000f);
            baseExplosiveness = 5f;
        }};
		//endPower
		
		//turrets
			destroyers = new ItemTurret("destroyers"){{
            requirements(Category.turret, with(Items.silicon, 900, FormItems.lithium, 300, Items.graphite, 250));
            ammo(
                Items.graphite, new BasicBulletType(7.5f, 50){{
                    hitSize = 5f;
                    width = 15f;
                    height = 21f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 4;
                    reloadMultiplier = 2.7f;
                    knockback = 0.3f;
                }},
                FormItems.lithium, new BasicBulletType(8.5f, 50){{
                    hitSize =  7f;
                    width = 15f;
                    height = 40f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 5;
                    hitEffect = Fx.blastExplosion;
                    status = StatusEffects.burning;
                    reloadMultiplier = 3.7f;
                    knockback = 1.3f;
                    status = FormStatus.hacker;
                }}
            );
            reload = 1f;
            recoilTime = reload * 1f;
            ammoUseEffect = Fx.casing3;
            range = 230f;
            shootY = 2f;
            drawer = new DrawTurret("base-");
            inaccuracy = 1f;
            shootCone = 35f;
            scaledHealth = 200;
            shootSound = Sounds.shootSnap;
            recoil = 1f;
            size = 3;
			coolant = consumeCoolant(0.1f);
            limitRange(0f);
        }};
			foremdow = new ItemTurret("foremdow"){{
            requirements(Category.turret, with(FormItems.lithium, 40, Items.graphite, 25));
            ammo(
                 Items.graphite, new BasicBulletType(7.5f, 50){{
                    hitSize = 2.8f;
                    width = 15f;
                    height = 21f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 4;
                    reloadMultiplier = 2.7f;
                    knockback = 0.3f;
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
                FormItems.lithium, new BasicBulletType(8.5f, 50){{
                    width = 25f;
                    hitSize = 7f;
                    height = 20f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 5;
                    hitEffect = despawnEffect = Fx.hitSquaresColor;
                    status = FormStatus.hacker;
                    reloadMultiplier = 3.7f;
                    knockback = 1.3f;
                    status = FormStatus.hacker;
                }},
                FormItems.platinum, new ArtilleryBulletType(3f, 45){{
                    hitEffect = Fx.plasticExplosion;
                    knockback = 1f;
                    lifetime = 80f;
                    width = height = 13f;
                    collidesTiles = false;
                    splashDamageRadius = 35f * 0.75f;
                    splashDamage = 45f;
                    status = FormStatus.platinum;
                    fragBullet = new BasicBulletType(2.5f, 10, "bullet"){{
                        width = 10f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 15f;
                        backColor = Pal.plastaniumBack;
                        frontColor = Pal.plastaniumFront;
                        despawnEffect = Fx.none;
                        collidesAir = false;
                    }};

                    fragBullets = 10;
                    backColor = Pal.plastaniumBack;
                    frontColor = Pal.plastaniumFront;
                }}
            );
            reload = 3f;
            recoil = 2f;
            range = 130f;
            size = 2;
            shoot.shotDelay = 5f;
            shoot.shots = 2;
            rotateSpeed = 15f;
            inaccuracy = 17f;
            shootCone = 10f;
            health = 260;
            drawer = new DrawTurret("base-");
            shootSound = FormSounds.pule;
            coolant = consumeCoolant(0.1f);
            limitRange(0f);
        }};
		  shower = new LiquidTurret("shower"){{
            requirements(Category.turret, with(FormItems.lithium, 100, FormItems.platinum, 50, Items.graphite, 30, FormItems.vanadium, 10));
            ammo(
                FormLiquid.distilledwater, new LiquidBulletType(FormLiquid.distilledwater){{
                    lifetime = 49f;
                    speed = 8f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    puddleSize = 8f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.3f;
                    drag = 0.001f;
                    layer = Layer.bullet - 2f;
                }},
                FormLiquid.fueloli, new LiquidBulletType(FormLiquid.fueloli){{
                    lifetime = 49f;
                    speed = 8f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.2f;
                    layer = Layer.bullet - 2f;
                }},
            FormLiquid.lava, new LiquidBulletType(FormLiquid.lava){{
                    lifetime = 49f;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    puddleSize = 8f;
                    orbSize = 6f;
                    drag = 0.001f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 2.5f;
                    layer = Layer.bullet - 2f;
                }}
            );
            size = 4;
            reload = 2f;
            shoot.shots = 3;
            velocityRnd = 0.1f;
            inaccuracy = 4f;
            recoil = 3f;
            shootCone = 45f;
            liquidCapacity = 60f;
            shootEffect = Fx.shootLiquid;
            range = 210f;
            scaledHealth = 2500;
            drawer = new DrawTurret("base-"){{

            }};
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
            researchCost = with(FormItems.lithium, 300, FormItems.platinum, 400, Items.graphite, 600, FormItems.vanadium, 100);
        }};

        dugasteret = new ItemTurret("dugasteret"){{
            requirements(Category.turret, with(FormItems.lithium, 250, Items.silicon, 800, Items.graphite, 400, FormItems.platinum, 90, FormItems.vanadium, 150));

            ammo(
            FormItems.lithium, new BasicBulletType(8f, 65){{
                knockback = 4f;
                width = 25f;
                hitSize = 7f;
                height = 20f;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                ammoMultiplier = 1;
                hitColor = backColor = trailColor = Color.valueOf("48aef4");
                frontColor = FormPal.hacked;
                trailWidth = 6f;
                trailLength = 3;
                hitEffect = despawnEffect = Fx.hitSquaresColor;
                buildingDamageMultiplier = 0.2f;
                status = FormStatus.hacker;
            }},
            FormItems.rhodium, new BasicBulletType(8f, 65){{
                knockback = 6f;
                width = 27f;
                hitSize = 8f;
                height = 20f;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                ammoMultiplier = 1;
                hitColor = backColor = trailColor = Color.valueOf("69d491");
                frontColor = FormPal.rhodium;
                trailWidth = 6f;
                trailLength = 3;
                hitEffect = despawnEffect = Fx.hitSquaresColor;
                buildingDamageMultiplier = 3.2f;
                status = FormStatus.rhodium;
            }},
            FormItems.platinum, new BasicBulletType(8f, 55){{
                hitEffect = despawnEffect = FormFx.platinum;
                    knockback = 3f;
                    lifetime = 80f;
                    width = height = 1f;
                    collidesTiles = false;
                    splashDamageRadius = 35f * 0.75f;
                    splashDamage = 45f;
                    status = FormStatus.platinum;
                    fragBullet = new BasicBulletType(2.5f, 10){{
                        width = 10f;
                        height = 12f;
                        shrinkY = 2f;
                        backColor = FormPal.platinumBack;
                        frontColor = FormPal.platinumFront;
                        despawnEffect = Fx.none;
                        collidesAir = true;
                    }};
                    backColor = FormPal.platinumBack;
                    frontColor = FormPal.platinumFront;
            }}
            );

            shoot = new ShootSpread(17, 4f);

            coolantMultiplier = 6f;

            inaccuracy = 0.2f;
            velocityRnd = 0.17f;
            shake = 1f;
            ammoPerShot = 3;
            maxAmmo = 30;
            consumeAmmoOnce = true;
            targetUnderBlocks = false;

            shootSound = Sounds.shootAltLong;

            drawer = new DrawTurret("base-"){{
                parts.add(new RegionPart("-front"){{
                    progress = PartProgress.warmup;
                    moveRot = -10f;
                    mirror = true;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, -5f));
                    heatColor = Color.red;
                }});
            }};
            shootY = 5f;
            outlineColor = Pal.darkOutline;
            size = 3;
            envEnabled |= Env.space;
            reload = 30f;
            recoil = 2f;
            range = 165f;
            shootCone = 40f;
            scaledHealth = 210;
            rotateSpeed = 3f;

            coolant = consume(new ConsumeLiquid(FormLiquid.distilledwater, 15f / 60f));
            limitRange();
        }};

        tesla = new PowerTurret("Tesla"){{
            requirements(Category.turret, with(FormItems.lithium, 60, FormItems.platinum, 30, Items.silicon, 20));
            shootType = new LightningBulletType(){{
                damage = 65;
                lightningLength = 25;
                collidesAir = false;
                ammoMultiplier = 1f;

                //for visual stats only.
                buildingDamageMultiplier = 1.25f;

                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = FormFx.platinum;
                    despawnEffect = Fx.none;
                    status = FormStatus.platinum;
                    statusDuration = 10f;
                    hittable = false;
                    lightColor = Color.white;
                    collidesAir = false;
                    buildingDamageMultiplier = 0.25f;
                }};
            }};
            reload = 45f;
            shootCone = 40f;
            rotateSpeed = 8f;
            targetAir = false;
            range = 150f;
            shootEffect = FormFx.platinum;
            heatColor = Color.red;
            drawer = new DrawTurret("base-"){{

            }};
            recoil = 3f;
            size = 2;
            health = 260;
            shootSound = Sounds.spark;
            consumePower(3.3f);
            coolant = consumeCoolant(0.1f);
        }};

        acidGun = new LiquidTurret("acid-gun"){{
            requirements(Category.turret, with(FormItems.lithium, 1200, Items.silicon, 800, Items.graphite, 400, FormItems.platinum, 500, FormItems.vanadium, 1050));

            ammo(
            FormLiquid.acid, new LiquidBulletType(FormLiquid.acid){{
                    lifetime = 49f;
                    speed = 8f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    puddleSize = 8f;
                    ammoMultiplier = 0.4f;
                    statusDuration = 60f * 4f;
                    status = FormStatus.platinum;
                    damage = 2.01f;
                    drag = 0.001f;
                    layer = Layer.bullet - 2f;
                    fragBullet = new BasicBulletType(5.5f, 7, "bullet"){{
                        width = 15f;
                        height = 7f;
                        shrinkY = 8f;
                        lifetime = 15f;
                        despawnEffect = Fx.none;
                        collidesAir = false;
                    }};

                }}
            );
            size = 4;
            shootY = 5f;
            reload = 2f;
            shoot.shots = 3;
            velocityRnd = 0.1f;
            inaccuracy = 4f;
            recoil = 3f;
            shootCone = 45f;
            liquidCapacity = 60f;
            shootEffect = Fx.shootLiquid;
            range = 260f;
            scaledHealth = 2500;
            drawer = new DrawTurret("base-"){{

            }};
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
            
        }};

        frezeeningIncinerator = new FreezingLaserTurret("frezeening_incinerator"){{
            requirements(Category.turret, with(FormItems.lithium, 1200, Items.silicon, 800, Items.graphite, 400, FormItems.platinum, 500, FormItems.vanadium, 1050));
            shootEffect = FormFx.shootBigSmokFreze;
            shootCone = 40f;
            recoil = 4f;
            size = 2;
            shake = 8f;
            range = 95f;
            reload = 40f;
            firingMoveFract = 0.5f;
            shootDuration = 230f;
            shootSound = Sounds.laserbig;
            loopSound = Sounds.beam;
            loopSoundVolume = 2f;

            shootType = new ContinuousLaserBulletType(48){{
                length = 96f;
                hitEffect = FormFx.hitfrezeeningIncinerator;
                hitColor = Color.valueOf("26beff");
                status = StatusEffects.freezing;
                drawSize = 420f;
                //timescaleDamage = true;
                despawnEffect = Fx.none;

                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};

            drawer = new DrawTurret("base-"){{ }};

            scaledHealth = 200;
            coolant = consumeCoolant(0.5f);
            consumePower(67f);
        }};

		//endTurret

		//defense
		lithiumDuct = new Duct("lithium-duct"){{
            requirements(Category.distribution, with(FormItems.lithium, 1));
            health = 65;
            speed = 4f; 
            //bridgeReplacement = lithiumBridgeItem;
            
            envEnabled |= Env.terrestrial | Env.underwater;
            envDisabled = Env.none;
            researchCost = with(FormItems.lithium, 5);
        }};
		lithiumRouter = new DuctRouter("lithium-router"){{
            requirements(Category.distribution, with(FormItems.lithium, 3));
            health = 90;
            speed = 5f;
            regionRotated1 = 1;
            solid = true;
            researchCost = with(FormItems.lithium, 9);
        }};
 
		lithiumBridgeItem = new DuctBridge("lithium-bridge"){{
            requirements(Category.distribution, with(FormItems.lithium, 6));
            health = 90;
            range = 8; // Дальность моста
            speed = 5f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
            ((Duct)lithiumDuct).bridgeReplacement = this;
            researchCost = with(FormItems.lithium, 12);
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
            mapColor = Color.valueOf("5c75f2");
        }};
        pinksand = new Floor("pink-sand") {{
            itemDrop = Items.sand;
            mapColor = Color.valueOf("8664f4");
        }};
        redstone = new Floor("red-stone") {{
            mapColor = Color.valueOf("cf8634");
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
            mapColor = Color.valueOf("d76dd1");
		}};
        orerhodium = new OreBlock("ore-rhodium", FormItems.rhodium){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            mapColor = Color.valueOf("a0ecbd");
        }};
		darkblueStone = new Floor("dark-blue-Stone"){{
            variants = 3;
            attributes.set(Attribute.water, 0.40f);
            attributes.set(Attribute.heat, -0.50f);
        }};
        
        //valid code since Floor extends Block
        

        darkblueStoneWall = new StaticWall("dark-blue-Stone-Wall") {{
            Block floor = new Floor("foo");
            floor = darkblueStone;
            darkblueStone.asFloor().wall = this;
            albedo = 0.6f;
        }};

        darkBlueSandWall = new StaticWall("dark-blue-sand-wall") {{
            Block floor = new Floor("one");
            floor = darkBlueSand;
            darkblueStone.asFloor().wall = this;
            albedo = 0.6f;
        }};

        pinksandWall = new StaticWall("pink-sand-wall") {{
            Block floor = new Floor("two-two");
            floor = pinksand;
            pinksand.asFloor().wall = this;
            albedo = 0.6f;
        }};
		fueloli = new Floor("pooled-fueloli"){{
            drownTime = 230f;
            status = StatusEffects.tarred;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = FormLiquid.fueloli;
            isLiquid = true;
            cacheLayer = CacheLayer.tar;
        }};

        lava = new Floor("deep-lava"){{
            drownTime = 230f;
            status = StatusEffects.tarred;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = FormLiquid.lava;
            isLiquid = true;
            cacheLayer = CacheLayer.slag;
        }};
		wallOrelithium = new OreBlock("ore-wall-lithium", FormItems.lithium){{
            wallOre = true;
        }};
		blueBoulder = new Prop("blue-Boulder"){{
            variants = 2;
            darkblueStone.asFloor().decoration = darkBlueSand.asFloor().decoration = this;
        }};

        deepDistilledwater = new Floor("deep-distilledwater"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = FormLiquid.distilledwater;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.wet;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};

        distilledwater = new Floor("shallow-distilledwater"){{
            speedMultiplier = 0.5f;
            variants = 0;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = FormLiquid.distilledwater;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};

        darkblueSandDistilledWater = new ShallowLiquid("dark-blue-sand-distilled-water"){{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
		//Endenvironment
		
		//units
		spiderFactory = new UnitFactory("spider-factory"){{
            scaledHealth = 120;
            size = 3;
            consumePower(3f);
            requirements(Category.units, with(FormItems.lithium, 100, silicon, 75));
            plans.add(
                new UnitPlan(FormUnits.genrtor, 60f * 15, with(FormItems.lithium, 10, silicon, 10)),
				new UnitPlan(FormUnits.herma, 60f * 15, with(FormItems.lithium, 10, silicon, 10))
            );
        }};

        spiderReconstructor = new Reconstructor("spider-reconstructor"){{
            requirements(Category.units, with(FormItems.lithium, 100, silicon, 75));

            size = 3;
            consumePower(3f);
            consumeItems(with(FormItems.lithium, 140, Items.graphite, 40, Items.silicon, 160));

            constructTime = 60f * 10f;

            upgrades.addAll(
                new UnitType[]{FormUnits.genrtor, FormUnits.mover}
            );
        }};
        
		//endUnits
		
		//storage
		coreCaser = new CoreBlock("core-caser"){{
            requirements(Category.effect, with(FormItems.lithium, 1200, FormItems.platinum, 200));
            unitType = FormUnits.arom;
            health = 18000;
            itemCapacity = 8000;
            size = 4;
            thrusterLength = 34/4f;
            armor = 5f;
            alwaysUnlocked = true;
            incinerateNonBuildable = true;

            isFirstTier = true;
            //TODO should this be higher?
            buildCostMultiplier = 0.7f;

            unitCapModifier = 15;
            researchCostMultiplier = 0.07f;
        }};
		//endStorage
		
		//sampenat
		launchomt = new FormLaunch("launch-otm"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(FormItems.lithium, 40, Items.silicon, 140));
            size = 3;
            itemCapacity = 200;
            launchTime = 60f * 20;
            hasPower = true;
            
            consumePower(4f);
        }};
		interplanetary = new FormAccelerator("interplanetary"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(FormItems.lithium, 111, Items.silicon, 111, FormItems.platinum, 111));
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
			lithiumWallHuge = new Wall("lithium-wall-huge"){{
            scaledHealth = 2200;
            size = 3;
            requirements(Category.defense, with(lithium, 48));
        }};
		//endWalls
    }
}
