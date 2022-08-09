package fr.sols;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Sols.MODID)
public class Sols {

    public static final String MODID = "sols";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Sols() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.addListener(Sols::playMusicOnLoadingScreen);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void playMusicOnLoadingScreen(final ScreenEvent.Render event){
        if(event.getScreen() instanceof LevelLoadingScreen){
            Minecraft.getInstance().getSoundManager().play((SimpleSoundInstance.forAmbientAddition(playMusic())));
        }
    }

    private static SoundEvent playMusic(){
        return SoundEvents.MUSIC_MENU;
    }

}
