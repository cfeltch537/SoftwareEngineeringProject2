package edu.ycp.cs320.fokemon_webApp.shared.MoveClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;

public enum MoveName {
	Confused("Confused"), Pound("Pound"), Karate_Chop("Karate Chop"), DoubleSlap(
			"DoubleSlap"), Comet_Punch("Comet Punch"), Mega_Punch("Mega Punch"), Pay_Day(
			"Pay Day"), Fire_Punch("Fire Punch"), Ice_Punch("Ice Punch"), ThunderPunch(
			"ThunderPunch"), Scratch("Scratch"), ViceGrip("ViceGrip"), Guillotine(
			"Guillotine"), Razor_Wind("Razor Wind"), Swords_Dance(
			"Swords Dance"), Cut("Cut"), Gust("Gust"), Wing_Attack(
			"Wing Attack"), Whirlwind("Whirlwind"), Fly("Fly"), Bind("Bind"), Slam(
			"Slam"), Vine_Whip("Vine Whip"), Stomp("Stomp"), Double_Kick(
			"Double Kick"), Mega_Kick("Mega Kick"), Jump_Kick("Jump Kick"), Rolling_Kick(
			"Rolling Kick"), Sand_Attack("Sand Attack"), Headbutt("Headbutt"), Horn_Attack(
			"Horn Attack"), Fury_Attack("Fury Attack"), Horn_Drill("Horn Drill"), Tackle(
			"Tackle"), Body_Slam("Body Slam"), Wrap("Wrap"), Take_Down(
			"Take Down"), Thrash("Thrash"), Double_Edge("Double Edge"), Tail_Whip(
			"Tail Whip"), Poison_Sting("Poison Sting"), Twineedle("Twineedle"), Pin_Missile(
			"Pin Missle"), Leer("Leer"), Bite("Bite"), Growl("Growl"), Roar(
			"Roar"), Sing("Sing"), Supersonic("Supersonic"), SonicBoom(
			"SonicBoom"), Disable("Disable"), Acid("Acid"), Ember("Ember"), Flamethrower(
			"Flamethrower"), Mist("Mist"), Water_Gun("Water Gun"), Hydro_Pump(
			"Hydro Pump"), Surf("Surf"), Ice_Beam("Ice Beam"), Blizzard(
			"Blizzard"), Psybeam("Psybeam"), BubbleBeam("BubbleBeam"), Aurora_Beam(
			"Aurora Beam"), Hyper_Beam("Hyper Beam"), Peck("Peck"), Drill_Peck(
			"Drill Peck"), Submission("Submission"), Low_Kick("Low Kick"), Counter(
			"Counter"), Seismic_Toss("Seismic Toss"), Strength("Strength"), Absorb(
			"Absorb"), Mega_Drain("Mega Drain"), Leech_Seed("Leech Seed"), Growth(
			"Growth"), Razor_Leaf("Razor Leaf"), SolarBeam("SolarBeam"), PoisonPowder(
			"PoisonPowder"), Stun_Spore("Stun Spore"), Sleep_Powder(
			"Sleep Powder"), Petal_Dance("Petal Dance"), String_Shot(
			"String Shot"), Dragon_Rage("Dragon Rage"), Fire_Spin("Fire Spin"), ThunderShock(
			"ThunderShock"), Thunderbolt("Thunderbolt"), Thunder_Wave(
			"Thunder Wave"), Thunder("Thunder"), Rock_Throw("Rock Throw"), Earthquake(
			"Earthquake"), Fissure("Fissure"), Dig("Dig"), Toxic("Toxic"), Confusion(
			"Confusion"), Psychic("Psychic"), Hypnosis("Hypnosis"), Meditate(
			"Meditate"), Agility("Agility"), Quick_Attack("Quick Attack"), Rage(
			"Rage"), Teleport("Teleport"), Night_Shade("Night Shade"), Mimic(
			"Mimic"), Screech("Screech"), Double_Team("Double Team"), Recover(
			"Recover"), Harden("Harden"), Minimize("Minimize"), SmokeScreen(
			"SmokeScreen"), Confuse_Ray("Confuse Ray"), Withdraw("Withdraw"), Defense_Curl(
			"Defense Curl"), Barrier("Barrier"), Light_Screen("Light Screen"), Haze(
			"Haze"), Reflect("Reflect"), Focus_Energy("Focus Energy"), Bide(
			"Bide"), Metronome("Metronome"), Mirror_Move("Mirror Move"), Selfdestruct(
			"Selfdestruct"), Egg_Bomb("Egg Bomb"), Lick("Lick"), Smog("Smog"), Sludge(
			"Sludge"), Bone_Club("Bone Club"), Fire_Blast("Fire Blast"), Waterfall(
			"Waterfall"), Clamp("Clamp"), Swift("Swift"), Skull_Bash(
			"Skull Bash"), Spike_Cannon("Spike Cannon"), Constrict("Constrict"), Amnesia(
			"Amnesia"), Kinesis("Kinesis"), Softboiled("Softboiled"), Hi_Jump_Kick(
			"Hi Jump Kick"), Glare("Glare"), Dream_Eater("Dream Eater"), Poison_Gas(
			"Poison Gas"), Barrage("Barrage"), Leech_Life("Leech Kiss"), Lovely_Kiss(
			"Lovely Kiss"), Sky_Attack("Sky Attack"), Transform("Transform"), Bubble(
			"Bubble"), Dizzy_Punch("Dizzy Punch"), Spore("Spore"), Flash(
			"Flash"), Psywave("Psywave"), Splash("Splash"), Acid_Armor(
			"Acid Armor"), Crabhammer("Crabhammer"), Explosion("Explosion"), Fury_Swipes(
			"Fury Swipes"), Bonemerang("Bonemerang"), Rest("Rest"), Rock_Slide(
			"Rock Slide"), Hyper_Fang("Hyper Fang"), Sharpen("Sharpen"), Conversion(
			"Conversion"), Tri_Attack("Tri Attack"), Super_Fang("Super Fang"), Slash(
			"Slash"), Substitute("Substitute"), Struggle("Struggle");

	private static final List<MoveName> MOVES = Collections
			.unmodifiableList(Arrays.asList(values()));
	private static final int length = MOVES.size();
	
	public static MoveName getMove(int i)	{
		return MOVES.get(i);
	}

	public String name;


	private MoveName(String moveName) {
		this.name = moveName;
	}


	/**
	 * @return the length
	 */
	public static int getLength() {
		return length;
	}
}
