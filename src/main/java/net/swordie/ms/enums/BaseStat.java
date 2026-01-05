package net.swordie.ms.enums;

import net.swordie.ms.client.character.Char;
import net.swordie.ms.client.character.skills.Option;
import net.swordie.ms.client.character.skills.info.ToBaseStat;
import net.swordie.ms.client.character.skills.temp.CharacterTemporaryStat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 5/4/2018.
 */
public enum BaseStat {
    unk,
    str,             // Strength
    strR,            // Strength %
    dex,             // Dexterity
    dexR,            // Dexterity %
    inte,            // Intelligence (often labeled 'int' in game, 'inte' in WZ data)
    intR,            // Intelligence %
    luk,             // Luck
    lukR,            // Luck %
    mdf,             // Max DF (Demon Force) / TF (Time Force) / PP (Psychic Point)
    pad,             // Physical Attack Damage (Attack Power)
    padR,            // Physical Attack %
    mad,             // Magic Attack Damage (Magic Attack)
    madR,            // Magic Attack %
    pdd,             // Physical Defense
    pddR,            // Physical Defense %
    mdd,             // Magic Defense
    mddR,            // Magic Defense %
    mhp,             // Max HP
    mhpR,            // Max HP %
    mmp,             // Max MP
    mmpR,            // Max MP %
    cr,              // Critical Rate %
    addCrOnBoss,     // Additional Critical Rate on Bosses
    crDmg,           // Critical Damage %
    fd,              // Final Damage %
    damR,            // Damage % (Total Damage)
    bd,              // Boss Damage %
    nbd,             // Normal Monster Damage % (Non-Boss)
    ied,             // Ignore Enemy Defense % (IED)
    asr,             // Abnormal Status Resistance (Status Resistance)
    ter,             // Elemental Resistance (and/or Status Duration Reduction)
    eleAttrResistance, // Elemental Attribute Resistance
    acc,             // Accuracy
    accR,            // Accuracy %
    eva,             // Avoidability
    evaR,            // Avoidability %
    jump,            // Jump
    speed,           // Movement Speed
    expR,            // Bonus EXP %
    comboKillOrbExpR, // Exp multiplier specifically for Combo Kill Orbs
    dropR,           // Item Drop Rate %
    dropRMulti,      // Item Drop Rate Multiplier (e.g., from coupons)
    mesoR,           // Meso Acquisition Rate %
    mesoG,           // Meso Acquisition (Flat amount)
    mesoRMulti,      // Meso Acquisition Rate Multiplier
    booster,         // Attack Speed Booster level
    stance,          // Knockback Resistance (Stance) %
    mastery,         // Weapon Mastery %
    damageOver,      // Max Damage Cap Increase (Legacy stat, now mostly unused)
    allStat,         // All Stats (STR, DEX, INT, LUK)
    allStatR,        // All Stats %
    hpRecovery,      // HP Recovery (passive/periodic)
    mpRecovery,      // MP Recovery (passive/periodic)
    incAllSkill,     // +1 to All Skill Levels (Decent Skills or passive boost)
    strLv,           // Strength per 10 Character Levels
    dexLv,           // Dexterity per 10 Character Levels
    intLv,           // Intelligence per 10 Character Levels
    lukLv,           // Luck per 10 Character Levels
    summonTimeR,     // Summon Duration %
    buffTimeR,       // Buff Duration %
    dotBuffTimeR,    // DoT Duration %
    runeBuffTimerR,  // Buff Duration % specifically for Rune's EXP buff
    noCoolProp,      // Chance to skip Cooldowns
    reduceCooltimeR, // Cooldown Reduction % (e.g., -5% CD)
    reduceCooltime,  // Cooldown Reduction Flat (e.g., -1 sec CD)
    costhpR,         // HP Cost Reduction % (for skills)
    costmpR,         // MP Cost Reduction % (for skills)
    costForceR,      // Force Cost Reduction % (Demon Force, etc.)
    hpDrain,         // HP Drain (Recover HP on attack)
    mpDrain,         // MP Drain (Recover MP on attack)
    onHitHpRecoveryR, // Chance to recover HP when hit
    onHitMpRecoveryR, // Chance to recover MP when hit
    recoveryUp,      // Potions/Heal Recovery % Increase
    mpconReduce,     // MP Consumption Reduction
    padLv,           // Attack Power per 10 Character Levels
    madLv,           // Magic Attack per 10 Character Levels
    mhpLv,           // Max HP per 10 Character Levels
    mmpLv,           // Max MP per 10 Character Levels
    dmgReduce,       // Damage Reduction % (Standard)
    dmgReduce_fixDmg,// Damage Reduction % (Affects Fixed/Proportional %HP Attacks)
    magicGuard,      // Magic Guard Effect (% of damage taken to MP)
    invincibleAfterRevive, // Invincibility duration after reviving
    shopDiscountR,   // Shop Price Discount %
    pqShopDiscountR, // PQ Shop Price Discount %
    ozBoostR,        // Tower of Oz Point Multiplier %
    protectiveShield,// Protective Shield (HP Overlay)
    deathPenaltyDurationDecR, // Decrease Death Penalty Experience Loss Duration
    arc,             // Arcane Power
    authForce,       // Authentic Force
    ;


    public static BaseStat getFromStat(Stat s) {
        switch (s) {
            case str:
                return str;
            case dex:
                return dex;
            case inte:
                return inte;
            case luk:
                return luk;
            case mhp:
                return mhp;
            case mmp:
                return mmp;
            default:
                return unk;
        }
    }

    public BaseStat getRateVar() {
        switch (this) {
            case str:
                return strR;
            case dex:
                return dexR;
            case inte:
                return intR;
            case luk:
                return lukR;
            case pad:
                return padR;
            case mad:
                return madR;
            case pdd:
                return pddR;
            case mdd:
                return mddR;
            case mhp:
                return mhpR;
            case mmp:
                return mmpR;
            case acc:
                return accR;
            case eva:
                return evaR;
            default:
                return null;
        }
    }

    public BaseStat getLevelVar() {
        switch (this) {
            case str:
                return strLv;
            case dex:
                return dexLv;
            case inte:
                return intLv;
            case luk:
                return lukLv;
            case pad:
                return padLv;
            case mad:
                return madLv;
            case mhp:
                return mhpLv;
            case mmp:
                return mmpLv;
        }
        return null;
    }

    public static Map<BaseStat, Integer> getFromCTS(Char chr, CharacterTemporaryStat ctsArg, Option o) {
        Map<BaseStat, Integer> stats = new HashMap<>();
        switch (ctsArg) {
            case IndiePAD:
            case PyramidBonusDamageBuff:
                stats.put(pad, o.nOption);
                break;
            case EPAD:
            case PAD:
            case BlessingArmorIncPAD:
            case HayatoPAD:
                stats.put(pad, o.nOption);
                break;
            case IndieMAD:
            case BlessOfDarkness:
                stats.put(mad, o.nOption);
                break;
            case MAD:
            case EMAD:
            case HakuBlessing:
                stats.put(mad, o.nOption);
                break;
            case IndieDEF:
                stats.put(pdd, o.nOption);
                break;
            case DEF:
            case EPDD:
                stats.put(pdd, o.nOption);
                break;
            case HowlingAttackDamage:
            case BeastFormDamageUp:
                stats.put(padR, o.nOption);
                break;
            case IndiePADR:
                stats.put(padR, o.nOption);
                break;
            case IndieMADR:
                stats.put(madR, o.nOption);
                break;
            case IndiePDDR:
                stats.put(pddR, o.nOption);
                break;
            case IndieMHP:
                stats.put(mhp, o.nOption);
                break;
            case IndieMHPR:
            case MaxHP:
            case IncMaxHP:
            case BeastFormMaxHP:
            case HayatoHPR:
                stats.put(mhpR, o.nOption);
                break;
            case IndieMMP:
                stats.put(mmp, o.nOption);
                break;
            case MaxMP:
            case IncMaxMP:
                stats.put(mmpR, o.nOption);
                break;
            case IndieMMPR:
                stats.put(mmpR, o.nOption);
                break;
            case IndieACC:
                stats.put(acc, o.nOption);
                break;
            case ACC:
                stats.put(acc, o.nOption);
                break;
            case ACCR:
                stats.put(accR, o.nOption);
                break;
            case IndieEVA:
                stats.put(eva, o.nOption);
                break;
            case EVA:
                stats.put(eva, o.nOption);
                break;
            case IndieEVAR:
                stats.put(evaR, o.nOption);
                break;
            case EVAR:
            case RWMovingEvar:
                stats.put(evaR, o.nOption);
                break;
            case Speed:
                stats.put(speed, o.nOption);
                break;
            case IndieSpeed:
                stats.put(speed, o.nOption);
                break;
            case IndieJump:
                stats.put(jump, o.nOption);
                break;
            case Jump:
                stats.put(jump, o.nOption);
                break;
            case IndieAllStat:
                stats.put(str, o.nOption);
                stats.put(dex, o.nOption);
                stats.put(inte, o.nOption);
                stats.put(luk, o.nOption);
                break;
            case IndieDodgeCriticalTime:
            case IndieCr:
                stats.put(cr, o.nOption);
                break;
            case CriticalGrowing:
                stats.put(crDmg, o.xOption);
            case EnrageCr:
            case CriticalBuff:
            case ItemCritical:
            case HayatoCr:
                stats.put(cr, o.nOption);
                break;
            case SharpEyes:
                // Combination of Cr, CrDmg, Ied
                stats.put(cr, o.xOption);
                stats.put(crDmg, o.yOption);
                stats.put(ied, o.mOption);
                break;
            case Enrage:
                stats.put(fd, o.xOption); // fd
                break;
            case EnrageCrDamMin:
            case SoulGazeCriDamR:
            case BullsEye:
            case IndieCrDmg:
                stats.put(crDmg, o.nOption);
                break;
            case HolySymbol:
                stats.put(dropR, o.sOption);
                // Fall through intended
            case ExpBuffRate:
            case CarnivalExp:
            case PlusExpRate:
            case IndieEXP:
            case IndieRelaxEXP:
                stats.put(expR, o.nOption);
                break;
            case IndieBooster:
            case Booster:
            case PartyBooster:
            case HayatoBooster:
                stats.put(booster, o.nOption);
                break;
            case STR:
                stats.put(str, o.nOption);
                break;
            case IndieSTR:
                stats.put(str, o.nOption);
                break;
            case IndieDEX:
                stats.put(dex, o.nOption);
                break;
            case IndieINT:
                stats.put(inte, o.nOption);
                break;
            case IndieLUK:
                stats.put(luk, o.nOption);
                break;
            case BasicStatUp:
            case IndieStatR:
            case IndieAllStatR:
                stats.put(strR, o.nOption);
                stats.put(dexR, o.nOption);
                stats.put(intR, o.nOption);
                stats.put(lukR, o.nOption);
                break;
            case DEXR:
                stats.put(dexR, o.nOption);
                break;
            case IndieDamR:
                stats.put(damR, o.nOption);
                break;
            case DamR:
            case BattoujutsuAdvance:
                stats.put(damR, o.nOption);
                break;
            case IndieMDF:
                stats.put(mdf, o.nOption);
                break;
            case IndiePMdR:
                stats.put(fd, o.nOption);
                break;
            case IndieAsrR:
                stats.put(asr, o.nOption);
                break;
            case AsrR:
            case AsrRByItem:
            case IncAsrR:
                stats.put(asr, o.nOption);
                break;
            case IndieTerR:
                stats.put(ter, o.nOption);
                break;
            case TerR:
            case IncTerR:
                stats.put(ter, o.nOption);
                break;
            case HayatoBoss:
            case IndieBDR:
            case Preparation:
            case BdR:
                stats.put(bd, o.nOption);
                break;
            case Stance:
            case IndieStance:
                stats.put(stance, o.nOption);
                break;
            case IndieIgnoreMobpdpR:
                stats.put(ied, o.nOption);
                break;
            case AdvancedBless:
                // TODO
                break;
            case DropRIncrease:
            case DropRate:
            case IndiePartyDrop:
            case ItemUpByItem:
                stats.put(dropR, o.nOption);
                break;
            case MesoUp:
            case MesoUpByItem:
                stats.put(mesoR, o.nOption);
                break;
            case EMHP:
                stats.put(mhp, o.nOption);
                break;
            case EMMP:
                stats.put(mmp, o.nOption);
                break;
            case Bless:
                // TODO
                break;
            case IndieScriptBuff:
                stats.put(buffTimeR, o.nOption);
                break;
            case RhoAias:
            case DamageReduce:
            case DamAbsorbShield:
            case Jinsoku:
            case AngelicBursterSoulResonance:
                stats.put(dmgReduce, o.nOption);
                break;
            case IndieHitDamageInclHPR:
                stats.put(dmgReduce_fixDmg, -o.nOption); // IndieHitDmgInclHPR  increases hit dmg if nValue is positive
                break;
            case IndieDamReduceR:
                stats.put(dmgReduce, o.nOption);
                break;
            case IndieDrainHP:
                stats.put(hpDrain, o.nOption);
                break;
            case ComboDrain:
                stats.put(hpDrain, o.nOption);
                break;
            case ManaReflection:
                stats.put(costmpR, o.xOption);
                break;
            case MagicGuard:
                stats.put(magicGuard, o.nOption);
                break;
            case ElementalReset:
                stats.put(eleAttrResistance, o.nOption);
                break;
            case IndieCooltimeReduce:
                stats.put(reduceCooltimeR, o.nOption);
                break;
            case ComboCounter:
                ToBaseStat.comboCounter(chr, o, stats);
                break;
            case BowMasterConcentration:
                ToBaseStat.focusedFury(chr, o, stats);
                break;
            case IndieArcaneForce:
                stats.put(arc, o.nOption);
                break;
            case PowerTransferGauge:
                ToBaseStat.transferPowerGauge(chr, o, stats);
                break;
            case ElementalCharge:
                stats.put(damR, o.nOption);
                stats.put(pad, o.wOption);
                stats.put(asr, o.uOption);
                stats.put(dmgReduce_fixDmg, o.zOption);
                break;
            case BlessingArmor:
                stats.put(dmgReduce_fixDmg, o.yOption);
                break;
            case UnityOfPower:
                stats.put(crDmg, o.nOption * 10);
                break;
            case KillingPoint:
                stats.put(pad, o.nOption * 10);
                break;
            case ProtectiveShield:
            case BlitzShield:
            case IndieProtectiveShield:
                stats.put(protectiveShield, o.nOption);
                break;
            case Dice:
                ToBaseStat.rollDice(chr, o, stats);
                break;
            case FinalCut:
                stats.put(fd, o.nOption - 100);
                break;
            case AddAttackCount:
                ToBaseStat.ignisRoar(chr, o, stats);
                break;
            case BlessEnsenble:
                ToBaseStat.blessEnsemble(chr, o, stats);
                break;
            case DotBasedBuff:
                ToBaseStat.elementalDrain(chr, o, stats);
                break;
            default:
                stats.put(unk, o.nOption);
        }
        return stats;
    }

    public Stat toStat() {
        switch (this) {
            case str:
                return Stat.str;
            case dex:
                return Stat.dex;
            case inte:
                return Stat.inte;
            case luk:
                return Stat.luk;
            case mhp:
                return Stat.mhp;
            case mmp:
                return Stat.mmp;
            default:
                return null;
        }
    }

    public boolean isNonAdditiveStat() {
        return this == fd || this == ied;
    }

    public boolean isLevelStat() {
        return this == strLv || this == dexLv || this == intLv || this == lukLv || this == padLv || this == madLv
                || this == mhpLv || this == mmpLv;
    }

    public int getMaxByEquips(Char chr) {
        // Add after release
//        switch (this) {
//            case dropR:
//            case mesoR:
//                return chr.getLevel() < 200 ? 80
//                        : chr.getLevel() < 250 ? 100
//                        : 120;
//        }

        return 0;
    }

    public static BaseStat getBaseStatByName(String statName) {
        switch (statName) {
            case "STR":
            case "Flat STR":
                return str;
            case "DEX":
            case "Flat DEX":
                return dex;
            case "INT":
            case "Flat INT":
                return inte;
            case "LUK":
            case "Flat LUK":
                return luk;
            case "STR %":
            case "STR%":
                return strR;
            case "DEX %":
            case "DEX%":
                return dexR;
            case "INT %":
            case "INT%":
                return intR;
            case "LUK %":
            case "LUK%":
                return lukR;
            case "ATT":
            case "Flat ATT":
                return pad;
            case "Magic ATT":
            case "Flat Magic ATT":
                return mad;
            case "ATT %":
            case "ATT%":
                return padR;
            case "Magic ATT %":
            case "Magic ATT%":
            case "MATT%":
            case "MATT %":
                return madR;
            case "Boss Damage":
            case "Boss Damage %":
            case "BDR":
                return bd;
            case "IED":
            case "Ignore Defense %":
                return ied;
            case "All Stat":
            case "Flat All Stat":
                return allStat;
            case "All Stat %":
            case "All Stat%":
                return allStatR;
            case "Max HP":
            case "Flat Max HP":
                return mhp;
            case "Max MP":
            case "Flat Max MP":
                return mmp;
            case "HP %":
            case "HP%":
                return mhpR;
            case "MP %":
            case "MP%":
                return mmpR;
            case "Damage %":
            case "Damage%":
            case "Total Damage %":
            case "Total Damage%":
                return damR;
            case "STR Per 10 levels":
                return strLv;
            case "DEX Per 10 levels":
                return dexLv;
            case "INT Per 10 levels":
                return intLv;
            case "LUK Per 10 levels":
                return lukLv;
            case "Crit Damage %":
                return crDmg;
            case "Item Drop %":
                return dropR;
            case "Meso Drop %":
                return mesoR;
            case "Cooltime Reduction":
            case "Cooldown Reduction":
                return reduceCooltime;
            case "Crit Rate %":
            case "Crit Rate%":
                return cr;
        }
        return null;
    }

    public static List<BaseStat> mainStats = Arrays.asList(str, dex, inte, luk);
    public static List<BaseStat> mainStatsR = Arrays.asList(strR, dexR, intR, lukR);

    public static List<BaseStat> getMainStats() {
/*        List<BaseStat> res = new ArrayList<>();
        res.add(str);
        res.add(dex);
        res.add(inte);
        res.add(luk);
        return res;*/
        return mainStats;
    }

    public static List<BaseStat> getMainStatsPerc() {
        /*List<BaseStat> res = new ArrayList<>();
        res.add(strR);
        res.add(dexR);
        res.add(intR);
        res.add(lukR);
        return res;*/
        return mainStatsR;
    }
}
