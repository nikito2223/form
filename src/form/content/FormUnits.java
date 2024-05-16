package form.content;

import arc.graphics.Color;
import mindustry.ai.types.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.weapons.*;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.graphics.Pal;
import form.graphics.FormPal;

import static mindustry.Vars.*;

public class FormUnits{

    public static UnitType arom;
    public static UnitType herma;
    public static UnitType genrtor, mover;
        
    public static void load(){
        arom = new UnitType("arom") {{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            envDisabled = 0; 
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.2f;
            drag = 0.08f;
            speed = 5.6f;
            rotateSpeed = 7f;
            accel = 0.09f;
            itemCapacity = 60;
            health = 300f;
            armor = 2f;
            hitSize = 9f;
            engineSize = 0;
            payloadCapacity = 2f * 2f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;
            constructor = UnitEntity::create;

      fogRadius = 0f;
      targetable = false;
      hittable = false;

            setEnginesMirror(
                new UnitEngine(5.25f, 0f, 2.2f, 45f),
                new UnitEngine(0f, -4.25f, 2.2f, 0f)
            );

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 6.5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 3.1f;
                fractionRepairSpeed = 0.06f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;
                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});
        }};
        genrtor = new UnitType("genrtor"){{
            speed = 0.9f;
            targetAir = false;
            drag = 0.14f;
            hitSize = 12f;
            health = 270;
            accel = 0.4f;
            rotateSpeed = 5f;
            aiController = SuicideAI::new;
            constructor = LegsUnit::create;
            trailLength = 20;
            waveTrailX = 5f;
            trailScl = 1.3f;
            faceTarget = false;
            range = 100f;
            ammoType = new PowerAmmoType(900);
            armor = 4f;

            legCount = 3;
            legMoveSpace = 0.8f;
            legPairOffset = 3;
            legLength = 75f;
            legExtension = -20;
            legBaseOffset = 8f;
            stepShake = 1f;
            legLengthScl = 2f;
            rippleScale = 2f;
            legSpeed = 1f;

            legSplashDamage = 80;
            legSplashRange = 60;

            buildSpeed = 1.8f;


            weapons.add(
            new Weapon("heal-weapon-mount"){{
                shootSound = Sounds.lasershoot;
                reload = 24f;
                x = 8f;
                y = -6f;
                rotate = true;
                bullet = new LaserBoltBulletType(5.2f, 10){{
                    lifetime = 35f;
                    healPercent = 5.5f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            }},
            new Weapon("heal-weapon-mount"){{
                shootSound = Sounds.lasershoot;
                reload = 15f;
                x = 4f;
                y = 5f;
                rotate = true;
                bullet = new LaserBoltBulletType(5.2f, 8){{
                    lifetime = 35f;
                    healPercent = 3f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            }});
				weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 19f/4f;
                y = 19f/4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = true;

                repairSpeed = 3.6f / 2f;
                fractionRepairSpeed = 0.03f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 65f;
                }};
            }});
        }};
        mover = new UnitType("mover"){{
            speed = 0.9f;
            targetAir = false;
            drag = 0.14f;
            hitSize = 12f;
            health = 270;
            accel = 0.4f;
            rotateSpeed = 5f;
            aiController = SuicideAI::new;
            constructor = LegsUnit::create;
            trailLength = 20;
            waveTrailX = 5f;
            trailScl = 1.3f;
            faceTarget = false;
            range = 100f;
            ammoType = new PowerAmmoType(900);
            armor = 4f;
            //leg
            legCount = 8;
            legMoveSpace = 0.8f;
            legPairOffset = 3;
            legLength = 75f;
            legExtension = -20;
            legBaseOffset = 8f;
            stepShake = 1f;
            legLengthScl = 0.93f;
            rippleScale = 3f;
            legSpeed = 0.19f;

            legSplashDamage = 80;
            legSplashRange = 60;

            hovering = true;
            shadowElevation = 0.95f;
            groundLayer = Layer.legUnit;

            buildSpeed = 1.8f;

            weapons.add(
            new Weapon("heal-weapon-mount"){{
                shootSound = Sounds.lasershoot;
                reload = 15f;
                x = 4f;
                y = 5f;
                rotate = true;
                bullet = new LaserBoltBulletType(5.2f, 8){{
                    lifetime = 35f;
                    healPercent = 3f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            }});
                weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 19f/4f;
                y = 19f/4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = true;

                repairSpeed = 3.6f / 2f;
                fractionRepairSpeed = 0.03f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 65f;
                }};
            }});
                weapons.add(new Weapon("form-mover-cannon"){{
                y = -14f;
                x = 0f;
                shootY = 22f;
                mirror = false;
                reload = 210;
                shake = 10f;
                recoil = 10f;
                rotateSpeed = 1f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 30f;

                rotationLimit = 80f;

                bullet = new ArtilleryBulletType(3f, 50){{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 25f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 4f;
                    splashDamageRadius = 80f;
                    splashDamage = 75f;
                    backColor = Pal.sapBulletBack;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 5;
                    lightningLength = 20;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 10f;
                    lightRadius = 40f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.6f;

                    statusDuration = 60f * 10;

                    fragLifeMin = 0.3f;
                    fragBullets = 9;

                    fragBullet = new ArtilleryBulletType(2.3f, 30){{
                        knockback = 0.8f;
                        lifetime = 90f;
                        width = height = 20f;
                        collidesTiles = false;
                        splashDamageRadius = 70f;
                        splashDamage = 40f;
                        backColor = FormPal.platinumBack;
                        frontColor = lightningColor = FormPal.platinumFront;
                        lightning = 2;
                        lightningLength = 5;
                        smokeEffect = FormFx.hacker;
                        hitShake = 5f;
                        lightRadius = 30f;
                        lightColor = FormPal.platinumFront;
                        lightOpacity = 0.5f;

                        statusDuration = 60f * 10;
                    }};
                }};
            }});
        }};

        herma = new UnitType("herma"){{
            drag = 0.1f;
            speed = 0.62f;
            hitSize = 23f;
            health = 9500;
            armor = 6f;

            rotateSpeed = 2.7f;

            legCount = 6;
            legMoveSpace = 1f;
            legPairOffset = 3;
            legLength = 30f;
            legExtension = -15;
            legBaseOffset = 10f;
            stepShake = 1f;
            legLengthScl = 0.96f;
            rippleScale = 1.4f;
            legSpeed = 0.3f;
            ammoType = new PowerAmmoType(2000);

            legSplashDamage = 32;
            legSplashRange = 30;
            drownTimeMultiplier = 2f;
            aiController = SuicideAI::new;
            constructor = LegsUnit::create;
            hovering = true;
            shadowElevation = 0.65f;
            groundLayer = Layer.legUnit;

            BulletType sapper = new SapBulletType(){{
                sapStrength = 0.85f;
                length = 55f;
                damage = 40;
                shootEffect = Fx.shootSmall;
                hitColor = color = Color.valueOf("bf92f9");
                despawnEffect = Fx.none;
                width = 0.55f;
                lifetime = 30f;
                knockback = -1f;
            }};

            weapons.add(
            new Weapon("form-herma-weapon"){{
                top = false;
                y = 1f;
                x = 16f;
                shootY = 8f;
                reload = 45f;
                recoil = 5f;
                shake = 2f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.bang;
                inaccuracy = 3f;

                shoot.shots = 3;
                shoot.shotDelay = 4f;

                bullet = new BasicBulletType(7f, 50){{
                    width = 11f;
                    height = 20f;
                    lifetime = 25f;
                    shootEffect = Fx.shootBig;
                    lightning = 2;
                    lightningLength = 6;
                    lightningColor = Pal.surge;
                    //standard bullet damage is far too much for lightning
                    lightningDamage = 20;
                }};
            }}
            );
            weapons.add(new Weapon("form-herma-cannon"){{
                y = -14f;
                x = 0f;
                shootY = 22f;
                mirror = false;
                reload = 210;
                shake = 10f;
                recoil = 10f;
                rotateSpeed = 1f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 30f;

                rotationLimit = 80f;

                bullet = new ArtilleryBulletType(3f, 50){{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 25f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 4f;
                    splashDamageRadius = 80f;
                    splashDamage = 75f;
                    backColor = Pal.sapBulletBack;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 5;
                    lightningLength = 20;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 10f;
                    lightRadius = 40f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.6f;

                    status = FormStatus.platinum;
                    statusDuration = 60f * 10;

                    fragLifeMin = 0.3f;
                    fragBullets = 9;

                    fragBullet = new ArtilleryBulletType(2.3f, 30){{
                        hitEffect = FormFx.hacker;
                        knockback = 0.8f;
                        lifetime = 90f;
                        width = height = 20f;
                        collidesTiles = false;
                        splashDamageRadius = 70f;
                        splashDamage = 40f;
                        backColor = FormPal.platinumBack;
                        frontColor = lightningColor = FormPal.platinumFront;
                        lightning = 2;
                        lightningLength = 5;
                        smokeEffect = FormFx.hacker;
                        hitShake = 5f;
                        lightRadius = 30f;
                        lightColor = FormPal.platinumFront;
                        lightOpacity = 0.5f;

                        status = FormStatus.platinum;
                        statusDuration = 60f * 10;
                    }};
                }};
            }});
        }};
    }
}