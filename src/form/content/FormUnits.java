package form.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.*;
import static form.content.FormItems.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class FormUnits{

    public static UnitType
    arom, genrtor, herma;
       
    public void load(){
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
            constructor = UnitEntity::create;
            trailLength = 20;
            waveTrailX = 5f;
            trailScl = 1.3f;
            faceTarget = false;
            range = 100f;
            ammoType = new PowerAmmoType(900);
            armor = 4f;

            buildSpeed = 1.5f;

            weapons.add(new RepairBeamWeapon("form-herma-weapon"){{
                x = 0f;
                y = -5.5f;
                shootY = 6f;
                beamWidth = 0.8f;
                mirror = false;
                repairSpeed = 0.75f;

                bullet = new BulletType(){{
                    maxRange = 120f;
                }};
            }});

            new Weapon("form-herma-weapon"){{
                y = 1f;
                x = 16f;
                mirror = false;
                shootY = 8f;
                reload = 45f;
                
                recoil = 5f;
                shake = 2f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.bang;
                inaccuracy = 3f;

                shoot.shots = 3;
                shoot.shotDelay = 4f;

                bullet = new BasicBulletType(13f, 80){{
                    pierce = true;
                    pierceCap = 10;
                    width = 14f;
                    height = 33f;
                    lifetime = 15f;
                    shootEffect = Fx.shootBig;
                    fragVelocityMin = 0.4f;

                    hitEffect = Fx.blastExplosion;
                    splashDamage = 18f;
                    splashDamageRadius = 13f;

                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 30f;

                    fragBullet = new BasicBulletType(9f, 20){{
                        width = 10f;
                        height = 10f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;

                        lifetime = 20f;
                        hitEffect = Fx.flakExplosion;
                        splashDamage = 15f;
                        splashDamageRadius = 10f;
                    }};
                }};
            }};
				
        }};

        herma = new UnitType("herma"){{
            speed = 0.35f;
            hitSize = 26f;
            rotateSpeed = 1.65f;
            health = 1040;
            armor = 14f;
            mechStepParticles = true;
            stepShake = 0.75f;
            drownTimeMultiplier = 6f;
            mechFrontSway = 1.9f;
            mechSideSway = 0.6f;
			constructor = UnitEntity::create;
            ammoType = new ItemAmmoType(FormItems.lithium);

            mechStepParticles = true;
            stepShake = 0.15f;
            singleTarget = true;
            drownTimeMultiplier = 4f;

            BulletType smallBullet = new BasicBulletType(3f, 10){{
                width = 7f;
                height = 9f;
                lifetime = 50f;
            }};

            weapons.add(
            new Weapon("form-herma-weapon"){{
                y = 1f;
                x = 16f;
				mirror = false;
                shootY = 8f;
                reload = 45f;
				
                recoil = 5f;
                shake = 2f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.bang;
                inaccuracy = 3f;

                shoot.shots = 3;
                shoot.shotDelay = 4f;

                bullet = new BasicBulletType(13f, 80){{
                    pierce = true;
                    pierceCap = 10;
                    width = 14f;
                    height = 33f;
                    lifetime = 15f;
                    shootEffect = Fx.shootBig;
                    fragVelocityMin = 0.4f;

                    hitEffect = Fx.blastExplosion;
                    splashDamage = 18f;
                    splashDamageRadius = 13f;

                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 30f;

                    fragBullet = new BasicBulletType(9f, 20){{
                        width = 10f;
                        height = 10f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;

                        lifetime = 20f;
                        hitEffect = Fx.flakExplosion;
                        splashDamage = 15f;
                        splashDamageRadius = 10f;
                    }};
                }};
            }},


            new Weapon("form-herma-weapon"){{
                y = 1f;
                x = -16f;
                mirror = false;
                shootY = 8f;
                reload = 45f;
                
                recoil = 5f;
                shake = 2f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.bang;
                inaccuracy = 3f;

                shoot.shots = 3;
                shoot.shotDelay = 4f;

                bullet = new BasicBulletType(13f, 80){{
                    pierce = true;
                    pierceCap = 10;
                    width = 14f;
                    height = 33f;
                    lifetime = 15f;
                    shootEffect = Fx.shootBig;
                    fragVelocityMin = 0.4f;

                    hitEffect = Fx.blastExplosion;
                    splashDamage = 18f;
                    splashDamageRadius = 13f;

                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 30f;

                    fragBullet = new BasicBulletType(9f, 20){{
                        width = 10f;
                        height = 10f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;

                        lifetime = 20f;
                        hitEffect = Fx.flakExplosion;
                        splashDamage = 15f;
                        splashDamageRadius = 10f;
                    }};
                }};
            }},

            new Weapon("form-hermo-weapon"){{
                reload = 13f;
                x = 8.5f;
                y = 6f;
				mirror = false;
                rotate = true;
                ejectEffect = Fx.casing1;
                bullet = smallBullet;
            }},
            new Weapon("form-hermo-weapon"){{
                reload = 16f;
                x = 8.5f;
				mirror = false;
                y = -7f;
                rotate = true;
                ejectEffect = Fx.casing1;
                bullet = smallBullet;
            }}

            );
            weapons.add(
                new Weapon("form-hermo-weapon"){{
                reload = 13f;
                x = -8.5f;
                y = 6f;
                mirror = false;
                rotate = true;
                ejectEffect = Fx.casing1;
                bullet = smallBullet;
            }},
            new Weapon("form-hermo-weapon"){{
                reload = 16f;
                x = -8.5f;
                mirror = false;
                y = -7f;
                rotate = true;
                ejectEffect = Fx.casing1;
                bullet = smallBullet;
            }}
            );
        }};
    }
}