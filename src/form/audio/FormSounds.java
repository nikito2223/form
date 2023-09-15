package form.audio;

import arc.*;
import arc.audio.*;
import arc.assets.*;
import arc.assets.loaders.SoundLoader.*;
import mindustry.*;

public class FormSounds {
	protected static Sound getSound(String soundName) {
    String name = "sounds/" + soundName;
    String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

    Sound sound = new Sound();

    AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundParameter(sound));
    desc.errored = Throwable::printStackTrace;

    return sound;
	}
	public static Sound pule = getSound("pule");
}